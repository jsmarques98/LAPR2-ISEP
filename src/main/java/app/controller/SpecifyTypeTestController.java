package app.controller;

import app.domain.model.Category;
import app.domain.model.Company;
import app.domain.model.TestType;
import java.util.Set;

public class SpecifyTypeTestController {

    /**
     * The platform of SpecifyTypeTestController
     */
    private Company company;

    /**
     * Contructor
     */
    public SpecifyTypeTestController() {
        company = App.getInstance().getCompany();
    }

    /**
     * Builds an instance of SpecifyTypeTestController receiving the id, description, collection method and set of categories.
     *
     * @param id
     * @param description
     * @param collection
     * @param categories
     */
    public void specifyTypeOfTest(String id, String description, String collection, Set<Category> categories) {
        TestType type = new TestType(id, description, collection, categories);
        if (validateTestType(type)) {
            company.records.add(type);
        } else {
            //TODO catch exception on UI
            throw new IllegalArgumentException("dados introduzidos são inválidos");
        }
    }

    /**
     * Validates the test type receiving testType.
     *
     * @param testType
     * @return
     */
    private boolean validateTestType(TestType testType) {
        return testType.validate();
    }


}
