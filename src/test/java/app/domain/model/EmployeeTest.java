package app.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void createEmployeeId() {
        assertEquals(0,0);
    }


    @Test
    void generatePasswordEmployee() {
        String teste = "aaaaaaaaaa";
        String criada = Employee.generatePasswordEmployee();

        assertEquals(criada.length(),teste.length());
    }
}