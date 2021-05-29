
package app.domain.model;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiagnosisTest {

    private app.domain.model.Test test;
    Diagnosis writeRep = new Diagnosis("TelevisionTelevisionTelevisionTelevision" +
            "TelevisionTelevisionTelevisionTelevision" +
            "TelevisionTelevisionTelevisionTelevision" +
            "TelevisionTelevisionTelevisionTelevision" +
            "TelevisionTelevisionTelevisionTelevision" +
            "TelevisionTelevisionTelevisionTelevision" +
            "TelevisionTelevisionTelevisionTelevision" +
            "TelevisionTelevisionTelevisionTelevision" +
            "TelevisionTelevisionTelevisionTelevision" +
            "TelevisionTelevisionTelevisionTelevision", this.test);

    @Test
    public void testConstructor() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Diagnosis("TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevisionahah", this.test);
        });
    }

    @Test
    public void getReport() {
        Assert.assertEquals("TelevisionTelevisionTelevisionTelevision" +
                "TelevisionTelevisionTelevisionTelevision" +
                "TelevisionTelevisionTelevisionTelevision" +
                "TelevisionTelevisionTelevisionTelevision" +
                "TelevisionTelevisionTelevisionTelevision" +
                "TelevisionTelevisionTelevisionTelevision" +
                "TelevisionTelevisionTelevisionTelevision" +
                "TelevisionTelevisionTelevisionTelevision" +
                "TelevisionTelevisionTelevisionTelevision" +
                "TelevisionTelevisionTelevisionTelevision", writeRep.getReport());
    }

    @Test
    public void setReport() {
        writeRep.setReport("Este é o report do teste");

        Assert.assertEquals("Este é o report do teste", writeRep.getReport());

        assertDoesNotThrow(() -> {
            writeRep.setReport("TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision" +
                    "TelevisionTelevisionTelevisionTelevision"
            );
        });

        assertThrows(IllegalArgumentException.class, () -> {
            writeRep.setReport(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            writeRep.setReport("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            writeRep.setReport("\"TelevisionTelevisionTelevisionTelevision\" +\n" +
                    "                    \"TelevisionTelevisionTelevisionTelevision\" +\n" +
                    "                    \"TelevisionTelevisionTelevisionTelevision\" +\n" +
                    "                    \"TelevisionTelevisionTelevisionTelevision\" +\n" +
                    "                    \"TelevisionTelevisionTelevisionTelevision\" +\n" +
                    "                    \"TelevisionTelevisionTelevisionTelevision\" +\n" +
                    "                    \"TelevisionTelevisionTelevisionTelevision\" +\n" +
                    "                    \"TelevisionTelevisionTelevisionTelevision\" +\n" +
                    "                    \"TelevisionTelevisionTelevisionTelevision\" +\n" +
                    "                    \"TelevisionTelevisionTelevisionTelevisionahahha\"");
        });


    }

    @Test
    public void testToString() {
        String result = String.format("Report: %s%nTest: %s%n", writeRep.getReport(), this.test);

        Assert.assertEquals(result, writeRep.toString());
    }
}
