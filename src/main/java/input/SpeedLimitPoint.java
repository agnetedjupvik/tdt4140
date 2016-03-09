package input;

/**
 * Created by Even on 09/03/2016.
 */
public class SpeedLimitPoint implements  Datapoint{
    private final Datatype datatype = Datatype.speed_limit;
    private final double speedLimit;
    private final double time;

    public SpeedLimitPoint(double speedLimit, double time) {
        this.speedLimit = speedLimit;
        this.time = time;
    }

    public SpeedLimitPoint(String rawSpeed, double time) {
        this(parseSpeed(rawSpeed), time);
    }

    public static double parseSpeed(String string) {
        return Double.valueOf(string.substring(string.indexOf(':') + 1));
    }

    public Datatype getDatatype() {
        return datatype;
    }

    public double getValue() {
        return speedLimit;
    }

    public double getTime() {
        return time;
    }
}
