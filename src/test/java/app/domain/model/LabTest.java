package app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

 class LabTest {

  // private Lab lab;

    //public LabTest(){
         Lab lab = new Lab("12AB5", "ClinicLab", "OxfordStreet 10",
                "12345678901", "1234567890");
    //}

    @Test
     void testConstructor() {
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
    void testSetLabID() {
        lab.setLabId("12AB5");

        Assertions.assertEquals("12AB5", lab.getLabId());

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setLabId(null);
        });
    }



    @Test
     void testToString() {
        String result = String.format("LabID: %s%nName: %s%nAddress: %s%nPhoneNumber: %s%nTIN: %s", lab.getLabId(),
                lab.getName(), lab.getAddress(), lab.getPhoneNr(), lab.getTin());

        Assertions.assertEquals(result, lab.toString());
    }

    @Test
     void testGetLabId() {
        Assertions.assertEquals("12AB5", lab.getLabId());
    }

    @Test
     void testGetName() {
        Assertions.assertEquals("ClinicLab", lab.getName());
    }

    @Test
     void testGetAddress() {
        Assertions.assertEquals("OxfordStreet 10", lab.getAddress());
    }

    @Test
    void testGetPhoneNr() {
        Assertions.assertEquals("12345678901", lab.getPhoneNr());
    }

    @Test
     void testGetTin() {
        Assertions.assertEquals("1234567890", lab.getTin());
    }


    @Test
    void testSetName() {
        lab.setName("Lab Name");
        Assertions.assertEquals("Lab Name", lab.getName());

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
     void testSetAddress() {
        lab.setAddress("Clinical Lab");

        Assertions.assertEquals("Clinical Lab", lab.getAddress());

        assertDoesNotThrow(() -> {
            lab.setAddress("ClinicalClinicalClinicalClinic");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setAddress(null);
        });
    }

    @Test
     void testSetPhoneNr() {
        lab.setPhoneNr("12345678901");
        Assertions.assertEquals("12345678901", lab.getPhoneNr());

        assertDoesNotThrow(() -> {
            lab.setPhoneNr("12345678901");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setPhoneNr("123456789101112");
        });
    }

    @Test
     void testSetTin() {
        lab.setTin("1234567890");
        Assertions.assertEquals("1234567890", lab.getTin());

        assertDoesNotThrow(() -> {
            lab.setTin("1234567890");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            lab.setTin("12345678901");
        });
    }


}
