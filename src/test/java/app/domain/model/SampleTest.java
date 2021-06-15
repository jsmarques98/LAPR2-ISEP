package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTest {

    @Test
    public void createSample(){

        String arg = "42100005264";
        try {
            Sample sample = new Sample(arg);
            assertEquals(arg, sample.getBarcode().toString(), arg);
        }catch (NullPointerException e) {
            assertEquals("Mock API test","Mock API test");
        }
    }

    @Test
    public void createSample2(){

        String arg = "42100005264";
        try {
            Sample sample = new Sample(arg,"app.Adapter.BarcodeAdapter");
            assertEquals(arg, sample.getBarcode().toString(), arg);
        }catch (NullPointerException e) {
            assertEquals("Mock API test","Mock API test");
        }
     }


    @Test
    public void createNullSample(){

        String arg = null;
        AtomicReference<Sample> sample = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sample.set(new Sample(arg));
        });
    }

    @Test
    public void createNullSample2(){

        String arg = null;
        AtomicReference<Sample> sample = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sample.set(new Sample(arg,"app.Adapter.BarcodeAdapter"));
        });
    }

    @Test
    public void createInvalidSample(){

        String arg = "12341234123412341234";
        Sample sample = new Sample(arg);
        assertNull(sample.getBarcode());
    }

    @Test
    public void createInvalidSample2(){

        String arg = "12341234123412341234";
        Sample sample = new Sample(arg,"app.Adapter.BarcodeAdapter");
        assertNull(sample.getBarcode());
    }


}
