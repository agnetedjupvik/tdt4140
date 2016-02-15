import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/downtown-crosstown.json");
        List<Speedpoint> speed = new ArrayList<>();
        float startTime;
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String[] data = reader.readLine().split(",");
            startTime = Float.valueOf(data[2].substring(12,data[2].length()-1));
            while(reader.ready()) {
                if (Datatype.valueOf(data[0].substring(9,data[0].length()-1)) == Datatype.vehicle_speed) {
                    speed.add(newSpeedPoint(data, startTime));
                }
                data = reader.readLine().split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Speedpoint newSpeedPoint(String[] data, float startTime) {
            Speedpoint speedpoint = new Speedpoint();
            speedpoint.setSpeed((Float.valueOf(data[1].substring(data[1].indexOf(':')+1))));
            speedpoint.setTime((Float.valueOf(data[2].substring(12,data[2].length()-1))) - startTime);
        return speedpoint;
    }
}
