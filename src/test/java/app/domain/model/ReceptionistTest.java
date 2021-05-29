package app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceptionistTest {

    public final Receptionist r1;
    public final List<Employee> employeeList;

    public ReceptionistTest() {
        r1 = new Receptionist("ADMINISTRATOR", "Maria Alegre", "sad", "asd", "maria@gmail.com", "asd");
        employeeList = new ArrayList<>();
        employeeList.add(r1);
    }

    @Test
    public void teste(){
        Employee criada = employeeList.get(0);
        assertEquals(r1,criada);
    }

}