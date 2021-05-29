package app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClinicalChemestryTechnologistTest {

    public final ClinicalChemestryTechnologist cct1;
    public final List<Employee> employeeList;

    public ClinicalChemestryTechnologistTest() {
        cct1 = new ClinicalChemestryTechnologist("ADMINISTRATOR", "Maria Alegre", "sad", "asd", "maria@gmail.com", "asd");
        employeeList = new ArrayList<>();
        employeeList.add(cct1);
    }

    @Test
    public void teste(){
        Employee criada = employeeList.get(0);
        assertEquals(cct1,criada);
    }

}