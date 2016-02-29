import input.InputSimulator;
import org.junit.Assert;
import org.junit.Test;

public class inputSimTest {

    @Test
    public void testSimulator() {
        InputSimulator inputSimulator = new InputSimulator("speedTest.json");
        Assert.assertNotNull(inputSimulator);
    }

}
