package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputSimulator implements Input {

    private List<Datapoint> datapoints = new ArrayList<>();

    private Snapshot snapshot = new Snapshot();

    public double getTimeDisplacement() {
        return timeDisplacement;
    }

    private double timeDisplacement;
    private int index;

    public InputSimulator(String rawPath) {
        InputStream in = getClass().getResourceAsStream("/testfiles/" + rawPath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            parseData(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeDisplacement = getTimeDisplacement(datapoints.get(12000));//TODO: Skal egentlig være 0
    }

    public static Datatype parseDatatype(String string) {
        return Datatype.valueOf(string.substring(9, string.length() - 1));
    }

    public static double parseTime(String string) {
        try {
            return Double.valueOf(string.substring(12, string.length() - 1));
        } catch (Exception e) {

        }
        return 404;
    }

    private static double getTimeDisplacement(Datapoint point) {
        double startTimeSimulated = point.getTime();
        double startTimeReal = System.currentTimeMillis() / 1000.0;
        return startTimeReal - startTimeSimulated;
    }

    private void parseData(BufferedReader reader) throws IOException {
        String[] data;
        while (reader.ready()) {
            data = reader.readLine().split(",");
            readLine(data);
        }
    }

    private void readLine(String[] data) {
        Datapoint datapoint = new Datapoint(data[1], parseTime(data[2]),parseDatatype(data[0]));
        datapoints.add(datapoint);
    }

    @Override
    public Snapshot getLatestDataPoints() {
        double currTime = System.currentTimeMillis() / 1000.0;
        while (index < datapoints.size() && currTime > datapoints.get(index).getTime() + timeDisplacement) {
            index++;
            addPoint(datapoints.get(index));
        }
        if (index >= datapoints.size()) {
            timeDisplacement = getTimeDisplacement(datapoints.get(0));
            index = 0;
        }
        return snapshot;
    }

    public void addPoint(Datapoint datapoint) {
        switch (datapoint.getDatatype()) {
            case accelerator_pedal_position: snapshot.accelerator_pedal_position = datapoint; break;
            case brake_pedal_status: snapshot.brake_pedal_status = datapoint; break;
            case button_state: snapshot.button_state = datapoint; break;
            case door_status: snapshot.door_status = datapoint; break;
            case engine_speed: snapshot.engine_speed = datapoint; break;
            case fuel_consumed_since_restart: snapshot.fuel_consumed_since_restart = datapoint; break;
            case fuel_level: snapshot.fuel_level = datapoint; break;
            case headlamp_status: snapshot.headlamp_status = datapoint; break;
            case ignition_status: snapshot.ignition_status = datapoint; break;
            case latitude: snapshot.latitude = datapoint; break;
            case longitude: snapshot.longitude = datapoint; break;
            case odometer: snapshot.odometer = datapoint; break;
            case steering_wheel_angle: snapshot.steering_wheel_angle = datapoint; break;
            case torque_at_transmission: snapshot.torque_at_transmission = datapoint; break;
            case transmission_gear_position: snapshot.transmission_gear_position = datapoint; break;
            case vehicle_speed: snapshot.vehicle_speed = datapoint; break;
            case speed_limit: snapshot.speed_limit = datapoint; break;
            case windshield_wiper_status: snapshot.speed_limit = datapoint; break;
        }
    }


}
