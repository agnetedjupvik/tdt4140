package input;

public class Datapoint {
    private final Datatype datatype;
    private final double value;
    private final double time;

    public Datapoint(Datatype datatype, double data, double time) {
        this.datatype = datatype;
        this.value = data;
        this.time = time;
    }

    public Datapoint(String rawData, double time, Datatype datatype) {
        this(datatype, parseValue(rawData), time);
    }

    public static double parseValue(String string) {
        try {
            return Double.valueOf(string.substring(string.indexOf(':') + 1));
        } catch (Exception e) {

        }
        return 404;
    }

    public Datatype getDatatype() {
        return datatype;
    }

    public double getValue() {
        return value;
    }

    public double getTime() {
        return time;
    }
}
