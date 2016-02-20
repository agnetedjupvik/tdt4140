package input;

public class Speedpoint implements Datapoint {
    private final Datatype datatype = Datatype.vehicle_speed;
    private final double speed;
    private final double time;

    public Speedpoint(double speed, double time) {
        this.speed = speed;
        this.time = time;
    }

    public Speedpoint(String rawSpeed, double time) {
        this(parseSpeed(rawSpeed), time);
    }

    public static double parseSpeed(String string) {
        return Double.valueOf(string.substring(string.indexOf(':') + 1));
    }

    public Datatype getDatatype() {
        return datatype;
    }

    public double getValue() {
        return speed;
    }

    public double getTime() {
        return time;
    }
}
