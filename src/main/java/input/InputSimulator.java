package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputSimulator implements Input {

    private List<Speedpoint> speed = new ArrayList<>();
    private double timeDisplacement;
    private int index;

    public InputSimulator(String rawPath) {
        Path path = Paths.get(rawPath);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
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
        while (currTime > speed.get(index).getTime() + timeDisplacement) {
            index++;
        }
        return speed.get(index);
    }
}
