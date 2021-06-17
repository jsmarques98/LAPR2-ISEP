package app.controller;

import app.domain.model.Lab;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterEmployeeControllerTest {

    private RegisterEmployeeController ctrl;
    private Lab lab1;

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
            lab1 = new Lab("11111","laboratorio1","porto","99999999999","9999999999");
            ctrl.createEmloyee("ADMINISTRATOR", "maria","dsad", "77777777777","maria@gmail.com", "1111", lab1);


        } catch (IllegalArgumentException e) {
            fail();
        }
        try {
            lab1 = new Lab("11111","laboratorio1","porto","99999999999","9999999999");
            ctrl.createEmloyee("ADMINISTRATOR", "maria", "dsad", "77777777777","maria@gmail.com", "1111", lab1);


        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void createSpecialistDoctor() {
        ctrl = new RegisterEmployeeController();

        try {
            lab1 = new Lab("11111","laboratorio1","porto","99999999999","9999999999");
            ctrl.createSpecialistDoctor("SPECIALIST_DOCTOR", "maria", "dsad", "77777777777","maria@gmail.com", "1111", lab1, "1111");

        } catch (IllegalArgumentException e) {
            fail();
        }
        try {
            lab1 = new Lab("11111","laboratorio1","porto","99999999999","9999999999");
            ctrl.createSpecialistDoctor("ADMINISTRATOR", "maria", "dsad", "77777777777","maria@gmail.com", "1111", lab1,"1111");


        } catch (IllegalArgumentException e) {

        }
    }
}