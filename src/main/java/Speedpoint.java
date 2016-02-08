/**
 * Created by simen on 08.02.16.
 */
public class Speedpoint {
    public Datatype datatype = Datatype.vehicle_speed;
    public float speed;

    @Override
    public String toString() {
        return "Speedpoint{" +
                "datatype=" + datatype +
                ", speed=" + speed +
                ", time=" + time +
                '}';
    }

    public float time;
}
