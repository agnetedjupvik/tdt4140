/**
 * Created by simen on 08.02.16.
 */

/**
 * Class to represent a speed measurement
 */
public class Speedpoint {
    private Datatype datatype = Datatype.vehicle_speed;
    private float speed;
    private float time;

    /**
     * Create a new speed point
     * @param speed
     * @param time
     */
    public Speedpoint(float speed, float time) {
        this.speed = speed;
        this.time = time;
    }

    /**
     * Create new speed point
     */
    public Speedpoint() {

    }

    /**
     * Get time measurement
     * @return time
     */
    public float getTime() {
        return time;
    }

    /**
     * Set time measurement
     * @param time time
     */
    public void setTime(float time) {
        this.time = time;
    }

    /**
     * Get speed measurement
     * @return speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Set speed measurement
     * @param speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Get data type
     * @return data type
     */
    public Datatype getDatatype() {
        return datatype;
    }

    /**
     * Set data type
     * @param datatype data type
     */
    public void setDatatype(Datatype datatype) {
        this.datatype = datatype;
    }

    @Override
    public String toString() {
        return "Speedpoint{" +
                "datatype=" + datatype +
                ", speed=" + speed +
                ", time=" + time +
                '}';
    }

}
