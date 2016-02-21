package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputSimulator implements Input {

    private List<Speedpoint> speed = new ArrayList<>();
    private double timeDisplacement;
    private int index;

    public InputSimulator(String rawPath) {
        InputStream in = getClass().getResourceAsStream("/testfiles/" + rawPath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            parseData(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeDisplacement = getTimeDisplacement(speed.get(0));
    }

    public static Datatype parseDatatype(String string) {
        return Datatype.valueOf(string.substring(9, string.length() - 1));
    }

    public static double parseTime(String string) {
        return Double.valueOf(string.substring(12, string.length() - 1));
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
        if (parseDatatype(data[0]) == Datatype.vehicle_speed) {
            speed.add(new Speedpoint(data[1], parseTime(data[2])));
        }
    }

    @Override
    public Speedpoint getLatestSpeedpoint() {
        double currTime = System.currentTimeMillis() / 1000.0;
        while (index < speed.size() && currTime > speed.get(index).getTime() + timeDisplacement) {
            index++;
        }
        if (index >= speed.size()) {
            timeDisplacement = getTimeDisplacement(speed.get(0));
            index = 0;
        }
        return speed.get(index);
    }
}
