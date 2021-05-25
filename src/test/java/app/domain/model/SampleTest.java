package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest {

    @Test
    public void createSample(){

        String arg = "42100005264";
        Sample sample = new Sample(arg);

        assertEquals(arg, sample.getBarcode().toString(), arg);
    }

    @Test()
    public void createNullSample(){

        String arg = null;
        AtomicReference<Sample> sample = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sample.set(new Sample(arg));
        });

    }
}
