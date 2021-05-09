package app.controller;

import app.domain.model.TestType;
import java.util.ArrayList;
import java.util.List;

public class TestTypeRecord {

    /**
     * The test types list.
     */
    private List<TestType> record;

    /**
     * Creates a record of the test types.
     */
    public TestTypeRecord() {
        record = new ArrayList<>();
    }

    /**
     * Appends the test type to the list.
     * @param type
     * @return
     */
    public boolean appendTestType(TestType type) {
        return record.add(type);
    }
}
