package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LabTest {

   private Lab lab;

    public LabTest(){
        lab = new Lab("12AB5", "ClinicLab", "OxfordStreet 10",
                "12345678901", "1234567890");
    }

    @Test
    public void testConstructor() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Lab("12AB56", "ClinicLab", "OxfordStreet 10",
                    "12345678901", "1234567890");
        });

        assertThrows(IllegalArgumentException.class, () ->
        {
            new Lab("12AB5", "abcdefghijklmnopqertuvxz", "OxfordStreet 10",
                    "12345678901", "1234567890");
        });

        assertThrows(IllegalArgumentException.class, () ->
        {
            new Lab("12AB5", "ClinicLab", "ruadocanidelopontedabarcaportofeijao",
                    "12345678901", "1234567890");
        });
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Lab("12AB5", "ClinicLab", "OxfordStreet 10",
                    "111111111111", "1234567890");
        });

        assertThrows(IllegalArgumentException.class, () ->
        {
            new Lab("12AB5", "ClinicLab", "OxfordStreet 10",
                    "12345678901", "22222222222");
        });
    }

    @Test
    public void setLabID() {
        lab.setLabId("12AB5");

        Assert.assertEquals("12AB5", lab.getLabId());

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setLabId(null);
        });
    }

    @Test
    public void setName() {
        lab.setName("Lab Name");
        Assert.assertEquals("Lab Name", lab.getName());

        assertDoesNotThrow(() -> {
            lab.setName("ClinicalClinical");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setName("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setName("ClinicalClinicalClinical");
        });
    }

    @Test
    public void setAddress() {
        lab.setAddress("Clinical Lab");

        Assert.assertEquals("Clinical Lab", lab.getAddress());

        assertDoesNotThrow(() -> {
            lab.setAddress("ClinicalClinicalClinicalClinic");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setAddress(null);
        });
    }

    @Test
    public void setPhoneNumber() {
        lab.setPhoneNr("12345678901");
        Assert.assertEquals("12345678901", lab.getPhoneNr());

        assertDoesNotThrow(() -> {
            lab.setPhoneNr("12345678901");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setPhoneNr("123456789101112");
        });
    }


    @Test
    public void setTINnr() {
        lab.setTin("1234567890");
        Assert.assertEquals("1234567890", lab.getTin());

        assertDoesNotThrow(() -> {
            lab.setTin("1234567890");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setTin("12345678901");
        });

    }

    @Test
    public void getLabId() {
        Assert.assertEquals("12AB5", lab.getLabId());
    }

    @Test
    public void getName() {
        Assert.assertEquals("ClinicLab", lab.getName());

    }

    @Test
    public void getAddress() {
        Assert.assertEquals("OxfordStreet 10", lab.getAddress());
    }

    @Test
    public void getPhoneNr() {
        Assert.assertEquals("12345678901", lab.getPhoneNr());
    }

    @Test
    public void getTINnr() {
        Assert.assertEquals("1234567890", lab.getTin());

    }

    @Test
    public void testToString() {
        String result = String.format("LabID: %s%nName: %s%nAddress: %s%nPhoneNumber: %s%nTIN: %s", lab.getLabId(),
                lab.getName(), lab.getAddress(), lab.getPhoneNr(), lab.getTin());

        Assert.assertEquals(result, lab.toString());
    }
}
