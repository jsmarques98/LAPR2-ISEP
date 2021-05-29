
package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiagnosisTest {

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
    void testConstructor() {
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
    void getReport() {
        Assertions.assertEquals("TelevisionTelevisionTelevisionTelevision" +
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
    void setReport() {
        writeRep.setReport("TelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevision");

        Assertions.assertEquals("TelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevisionTelevision", writeRep.getReport());

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

        Assertions.assertEquals(result, writeRep.toString());
    }
}
