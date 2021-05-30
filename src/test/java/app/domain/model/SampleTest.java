package app.domain.model;

import app.controller.RecordSamplesController;
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

    @Test
    public void createNullSample(){

        String arg = null;
        AtomicReference<Sample> sample = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sample.set(new Sample(arg));
        });
    }

    @Test
    public void testSettersGetters(){
        String arg = "42100005264";
        Sample sample = new Sample(arg);

        double val = 1.69;

        sample.setESR00(val);
        sample.setHB000(val);
        sample.setMCH00(val);
        sample.setMCV00(val);
        sample.setMCHC0(val);
        sample.setPLT00(val);

        assertEquals(val, sample.getPLT00(), val);
        assertEquals(val, sample.getMCHC0(), val);
        assertEquals(val, sample.getMCV00(), val);
        assertEquals(val, sample.getMCH00(), val);
        assertEquals(val, sample.getHB000(), val);
        assertEquals(val, sample.getESR00(), val);
    }

}
