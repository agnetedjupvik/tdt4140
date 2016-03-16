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
    private double timeDisplacement;
    private int index;
    public InputSimulator(String rawPath) {
        InputStream in = getClass().getResourceAsStream("/testfiles/" + rawPath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            parseData(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //timeDisplacement = getTimeDisplacement(datapoints.get(12000));//TODO: Skal egentlig være 0

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

    public double getTimeDisplacement() {
        return timeDisplacement;
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
            snapshot.addPoint(datapoints.get(index++));
        }
        if (index >= datapoints.size()) {
            timeDisplacement = getTimeDisplacement(datapoints.get(0));
            index = 0;
        }
        return snapshot;
    }

}
