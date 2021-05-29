package app.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterEmployeeControllerTest {

    private RegisterEmployeeController ctrl;


    @BeforeEach
    void setUp() {

        ctrl = new RegisterEmployeeController();
    }

    @AfterEach
    void tearDown() {
        ctrl = null;
    }

    @Test
    void createEmloyee() {
        ctrl = new RegisterEmployeeController();

        try {
            ctrl.createEmloyee("ADMINISTRATOR", "maria","dsad", "77777777777","maria@gmail.com", "1111");


        } catch (IllegalArgumentException e) {
            fail();
        }
        try {
            ctrl.createEmloyee("ADMINISTRATOR", "maria", "dsad", "77777777777","maria@gmail.com", "1111");


        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void createSpecialistDoctor() {
        ctrl = new RegisterEmployeeController();

        try {
            ctrl.createSpecialistDoctor("SPECIALIST_DOCTOR", "maria", "dsad", "77777777777","maria@gmail.com", "1111", "1111");

        } catch (IllegalArgumentException e) {
            fail();
        }
        try {
            ctrl.createSpecialistDoctor("ADMINISTRATOR", "maria", "dsad", "77777777777","maria@gmail.com", "1111","1111");


        } catch (IllegalArgumentException e) {

        }
    }
}