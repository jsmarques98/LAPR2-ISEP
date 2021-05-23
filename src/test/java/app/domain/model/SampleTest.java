package app.domain.model;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class SampleTest {

    @Test
    public void createSample(){
        Sample sample = new Sample();

        String arg = "A69A";

        sample.generateBarcode(arg);

        assertTrue("Expected: " + arg + " Got: " + sample.getBarcode().toString(),sample.getBarcode().toString().equals(arg));
    }
}
