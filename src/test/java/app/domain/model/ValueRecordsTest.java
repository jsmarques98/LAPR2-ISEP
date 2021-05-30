package app.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValueRecordsTest {

    private ValueRecords records;

    @BeforeEach
    void setUp() {
        records = new ValueRecords("1", 5, 10, 7, "HB000");
    }

    @AfterEach
    void tearDown() {
        records = null;
    }

    @Test
    void getMinValue() {
        assertEquals(5,records.getMinValue());
    }

    @Test
    void setMinValue() {
        assertEquals(5,records.getMinValue());
        records.setMinValue(8);
        assertEquals(8,records.getMinValue());
    }

    @Test
    void getMaxValue() {
        assertEquals(10, records.getMaxValue());
    }

    @Test
    void setMaxValue() {
        assertEquals(10, records.getMaxValue());
        records.setMaxValue(12);
        assertEquals(12, records.getMaxValue());
    }

    @Test
    void getRegisteredValue() {
        assertEquals(7,records.getRegisteredValue());
    }

    @Test
    void setRegisteredValue() {
        assertEquals(7, records.getRegisteredValue());
        records.setRegisteredValue(9);
        assertEquals(9, records.getRegisteredValue());
    }
    

    @Test
    void testToString() {
        assertFalse(records.toString().isEmpty());
    }
}
