package rest;

import input.Input;
import input.InputSimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class Application implements CommandLineRunner {

    public static Input inputSimulator = new InputSimulator("downtown-crosstown.json");

    @Autowired
    Logger logger;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.getSnapshot(inputSimulator);
    }
}