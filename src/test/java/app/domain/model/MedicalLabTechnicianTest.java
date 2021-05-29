package app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicalLabTechnicianTest {

    public final MedicalLabTechnician ml1;
    public final List<Employee> employeeList;

    public MedicalLabTechnicianTest() {
        ml1 = new MedicalLabTechnician("ADMINISTRATOR", "Maria Alegre", "sad", "asd", "maria@gmail.com", "asd");
        employeeList = new ArrayList<>();
        employeeList.add(ml1);
    }

    @Test
    public void teste(){
        Employee criada = employeeList.get(0);
        assertEquals(ml1,criada);
    }

}