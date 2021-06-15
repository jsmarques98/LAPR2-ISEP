package app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LaboratoryCoordinatorTest {
    public final LaboratoryCoordinator lc1;
    public final Lab lab1;
    public final List<Employee> employeeList;

    public LaboratoryCoordinatorTest() {
        lab1 = new Lab("11111","laboratorio1","porto","99999999999","9999999999");
        lc1 = new LaboratoryCoordinator("ADMINISTRATOR", "Maria Alegre", "sad", "asd", "maria@gmail.com", "asd", lab1);
        employeeList = new ArrayList<>();
        employeeList.add(lc1);
    }

    @Test
    public void teste() {
        Employee criada = employeeList.get(0);
        assertEquals(lc1, criada);

    }
}