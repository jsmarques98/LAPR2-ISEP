package app.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewTestResultsControllerTest {

    private ViewTestResultsController ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new ViewTestResultsController();
    }

    @AfterEach
    void tearDown() {
        ctrl = null;
    }

    @Test
    void clientTests() {
    }

    @Test
    void clientSignedIn() {
    }
}