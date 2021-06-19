package app.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsultTestsControllerTest {

    private ConsultTestsController ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new ConsultTestsController();
    }

    @AfterEach
    void tearDown() {
        ctrl = null;
    }

    @Test
    void clientsList() {

        ctrl = new ConsultTestsController();


    }

    @Test
    void clientTestsConsult() {

        ctrl = new ConsultTestsController();
    }
}