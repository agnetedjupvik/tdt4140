import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {
    public static void main(String[] args) {
        Path path = Paths.get("downtown-crosstown.json");
        try(BufferedReader reader = Files.newBufferedReader(path)) {
            while(reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
