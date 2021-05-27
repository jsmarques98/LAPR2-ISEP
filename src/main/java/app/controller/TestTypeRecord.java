package app.controller;

import app.domain.model.Company;
import app.domain.model.TestType;
import java.util.ArrayList;
import java.util.List;

public class TestTypeRecord {

    /**
     * The test types list.
     */


    /**
     * Creates a record of the test types.
     */
    public TestTypeRecord() {
        Company.record = new ArrayList<>();
    }

    /**
     * Appends the test type to the list.
     * @param type
     * @return
     */
    public boolean appendTestType(TestType type) {
        return Company.record.add(type);
    }

    public List<TestType> getRecord() {
        return Company.record;
    }
}
