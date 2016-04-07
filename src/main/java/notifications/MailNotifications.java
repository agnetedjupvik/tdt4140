package notifications;

import input.Snapshot;
import rest.Application;

import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * Created by Espen Meidell <espen.meidell@gmail.com> on 06.04.16.
 */
public class MailNotifications {

    private long lastmailsent = 0;
    private String recipient = "espen.meidell@gmail.com";

    private  int counter = 0;

    private boolean sendmail = true;


    //Sender data
    private String from = "watchdog.alerter@gmail.com";
    private String pass = "watchdog123";



    /**
     * Start sending notifications if vehicle is speeding
     */
    public void startNotifications() {



        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Snapshot snapshot = Application.inputSimulator.getLatestDataPoints();
                if (snapshot.speed_limit.getValue()+5 < snapshot.vehicle_speed.getValue()) {
                    counter ++;
                    if (counter == 10) {
                        long now = System.currentTimeMillis();
                        if (now - lastmailsent > 1000 * 60 * 5) {
                            //SEND MAIL
                            System.out.println("Sending mail...");

                            if (sendmail) sendMail(snapshot.vehicle_speed.getValue(), snapshot.speed_limit.getValue());
                            lastmailsent = System.currentTimeMillis();
                        } else {
                            //Speeding, not sending
                            System.out.println("Not sending mail...");
                        }
                        counter = 0;
                    }
                }
            }
        }, 2000, 1000);





    }

    private void sendMail(double speed, double limit) {

        try {

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(from, pass);
                        }
                    });


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("koieapplicationgruppe3@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            message.setSubject("Watchdog Notification");
            message.setText("Dear user,\n\n" +
                    "We observed that your car was driving " + Double.toString(speed) + " mph in a \n" +
                    Double.toString(limit) + " mph zone. \n\n" +
                    "Kind Regards,\n" +
                    "The WatchDog Team");
            Transport.send(message);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
