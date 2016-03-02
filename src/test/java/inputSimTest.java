import input.InputSimulator;
import input.Speedpoint;
import javafx.scene.Cursor;
import org.junit.Assert;
import org.junit.Test;

public class inputSimTest {

    @Test
    public void testSimulator() {
        InputSimulator inputSimulator = new InputSimulator("speedTest.json");
        Assert.assertNotNull(inputSimulator);
    }

    @Test
    public void loopTest() {
        InputSimulator inputSimulator = new InputSimulator("loopTest.json");
        int index = 0;
        Speedpoint current = inputSimulator.getLatestSpeedpoint();
        Speedpoint first = current;
        while (index < 4) {
            Speedpoint newSpeedPoint = inputSimulator.getLatestSpeedpoint();
            if (newSpeedPoint != current) {
                current = newSpeedPoint;
                index++;
            }
        }
        Assert.assertEquals(current, first);
    }

}
