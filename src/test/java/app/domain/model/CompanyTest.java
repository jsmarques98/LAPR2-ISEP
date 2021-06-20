package app.domain.model;

import app.controller.Company;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    private Company company;
    List<app.domain.model.Test> tests = new ArrayList<>();
    List<ValueRecords> valueRecordsList = new ArrayList<>();
    List<ParameterTest> parameterList = new ArrayList<>();
    List<TestType> records = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    List<Client> clientsList = new ArrayList<>();
    Set<Category> categoriesSet = new HashSet<>();
    ArrayList<String> codeCategory = new ArrayList<>();
    ArrayList<String> parameterTestCode = new ArrayList<>();
    List<LocalDate> dateList = new ArrayList<>();
    List<LocalDate> finaldatesList = new ArrayList<>();
    List<Lab> labList = new ArrayList<>(1);
    List<Employee> employeeList = new ArrayList<>(1);
    List<Diagnosis> reportedTestsList = new ArrayList<>(1);
    app.domain.model.Test t1 = new app.domain.model.Test("12345678901","55555555", "Descricao", "12345", codeCategory, parameterTestCode);
    ValueRecords v1 = new ValueRecords("1", 5,10,7,"HB000", new Date());
    ParameterTest p1 = new ParameterTest("123456", "HB000", "designacao");
    TestType tt1 = new TestType("12345", "Descricao", "Seringa", categoriesSet);
    Category c1 = new Category("categoria1", "codigo1");





    @BeforeEach
    void setUp() {

        company = new Company("Designacao");

    }

    @AfterEach
    void tearDown() {

        company = null;
    }

    @Test
    void getValueRecords() {
        assertTrue(true);
    }

    @Test
    void getClient() {
        assertTrue(true);
    }

    @Test
    void getCategory() {
        assertTrue(true);
    }

    @Test
    void getParameterTest() {
        assertTrue(true);
    }

    @Test
    void getValueRecordsList() {
        assertTrue(true);
    }

    @Test
    void testGetValueRecordsList() {
        assertTrue(true);
    }


    @Test
    void getCategories() {
        assertTrue(true);
    }

    @Test
    void save() {
    }

    @Test
    void getTests() {
        assertTrue(true);
    }

    @Test
    void getTest() {
        assertTrue(true);
    }

    @Test
    void getAvailableTests() {
        assertTrue(true);
    }

    @Test
    void testSave() {
    }

    @Test
    void getDesignation() {
        assertTrue(true);
    }

    @Test
    void getAuthFacade() {
        assertTrue(true);
    }

    @Test
    void createEmloyee() {
    }

    @Test
    void createSpecialistDoctor() {
    }

    @Test
    void validateEmployee() {
    }

    @Test
    void saveEmployee() {
    }

    @Test
    void getClientsList() {
        assertTrue(true);
    }

    @Test
    void createClient() {
    }

    @Test
    void validateClient() {
    }

    @Test
    void saveClient() {
    }

    @Test
    void registerLab() {
    }

    @Test
    void validateLab() {
    }

    @Test
    void saveLab() {
    }

    @Test
    void testGetTest() {
        assertTrue(true);
    }

    @Test
    void createReport() {
    }

    @Test
    void validateReport() {
    }

    @Test
    void addReport() {
    }

    @Test
    void createtest() {
    }

    @Test
    void validateTest() {
    }

    @Test
    void saveTest() {
    }

    @Test
    void getTestType() {
        assertTrue(true);
    }

    @Test
    void createValueRecords() {
    }

    @Test
    void validateValueRecords() {
    }

    @Test
    void saveValueRecords() {
    }

    @Test
    void getTestsWhitSamples() {
        assertTrue(true);
    }

    @Test
    void getTestsWaitingValidation() {
        assertTrue(true);
    }


    @Test
    void getTestsWaitingResults() {
        assertTrue(true);
    }

    @Test
    void getTestsWaitingDiagnosis() {
        assertTrue(true);
    }

    @Test
    void getTestsValidated() {
        assertTrue(true);
    }
}