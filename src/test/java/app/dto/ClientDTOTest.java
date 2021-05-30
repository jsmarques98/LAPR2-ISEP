package app.dto;

import app.domain.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientDTOTest {

        ClientDTO c1;

        @BeforeEach
        void instantiation() {
            c1 = new ClientDTO("Manuel", "5555555555", "5555555555555555", "555555555555", "03/05/2021", "55555555555", "manel@gmail.com", "0");
        }

        @Test
        void testDTO() {
            String name ="Manuel";
            String number = "5555555555";
            String cCard = "5555555555555555";
            String nhs = "555555555555";
            String date = "03/05/2021";
            String phoneNumber = "55555555555";
            String email = "manel@gmail.com";
            String password = "0";

            assertEquals(c1.getBirthdate(),date);
            assertEquals(c1.getTINNumber(),number);
            assertEquals(c1.getCCNumber(),cCard);
            assertEquals(c1.getBirthdate(),date);
            assertEquals(c1.getEmail(),email);
            assertEquals(c1.getPassword(),password);
            assertEquals(c1.getNHSNumber(),nhs);
            assertEquals(c1.getPhoneNumber(),phoneNumber);
        }

    }