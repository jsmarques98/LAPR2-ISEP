package app.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;

class RecordTestResultsControllerTest {

    private RecordTestResultsController ctrl;

    @BeforeEach
    void setUp() {

        ctrl = new RecordTestResultsController();
    }

    @AfterEach
    void tearDown() {
        ctrl = null;
    }

    @Test
    void createValueRecords() {
        ctrl = new RecordTestResultsController();

        try {
            ctrl.createValueRecords("1", 10, 50, 50, "HB000", LocalDate.now());


        } catch (IllegalArgumentException e) {
            fail();
        }
        try {
            ctrl.createValueRecords("9", 50, 90, 70, "MCH00", LocalDate.now());


        } catch (IllegalArgumentException e) {

        }
    }
}

