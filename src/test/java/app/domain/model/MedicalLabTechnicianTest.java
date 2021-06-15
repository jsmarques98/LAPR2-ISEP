package app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicalLabTechnicianTest {

    public final MedicalLabTechnician ml1;
    public final List<Employee> employeeList;
    public final Lab lab1;

    public MedicalLabTechnicianTest() {
        lab1 = new Lab("11111","laboratorio1","porto","99999999999","9999999999");
        ml1 = new MedicalLabTechnician("ADMINISTRATOR", "Maria Alegre", "sad", "asd", "maria@gmail.com", "asd", lab1);
        employeeList = new ArrayList<>();
        employeeList.add(ml1);
    }

    @Test
    public void teste(){
        Employee criada = employeeList.get(0);
        assertEquals(ml1,criada);
    }

}