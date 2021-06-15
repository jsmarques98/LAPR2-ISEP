package app.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    Client c1;
    Client c2;
    Client c3;

    @BeforeEach
    void instantiation() {
        c1 = new Client("Manuel", "5555555555", "5555555555555555", "555555555555", "03/05/2021", "55555555555", "manel@gmail.com");
        c2 = new Client("Manuel", "5555555555", "5555555555555555", "555555555555", "03/05/2021", "55555555555", "manel@gmail.com");
        c3 = new Client("Rui", "0000000000", "0000000000000000", "555555555551", "03/06/2021", "55555555551", "manuyl@gmail.com");
    }

    @Test
    void testEquals() {

        assertEquals(c1,c1);
        assertEquals(c2,c1);
        assertNotEquals(c1,c3);

    }

    @Test
    void testToString() {
        String name ="Manuel";
        String number = "5555555555";
        String cCard = "5555555555555555";
        String nhs = "555555555555";
        String date = "03/05/2021";
        String phoneNumber = "55555555555";
        String email = "manel@gmail.com";

        String str = "Client{" +
                "name='" + name + '\'' +
                ", CCNumber='" + cCard + '\'' +
                ", NHSNumber='" + nhs + '\'' +
                ", birthdate='" + date + '\'' +
                ", TINNumber='" + number + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", Password='" + ""+ '\'' +
                '}';

        assertEquals(str, c1.toString());
    }

    @Test
    void getCCNumber() {
        String cCard = "5555555555555555";
        assertEquals(cCard, c1.getCCNumber());
    }

    @Test
    void getTINNumber() {
        String number = "5555555555";
        assertEquals(number, c1.getTINNumber());
    }

    @Test
    void getroleId() {
        String id = "Client";
        assertEquals(id, c1.getRoleID());
    }
}