package app.controller;

import app.domain.model.*;

public class RegisterTestToClientController {
    private Company company;
    private Test test;

    public RegisterTestToClientController() {
        this(App.getInstance().getCompany());
    }

    public RegisterTestToClientController(Company company) {
        this.company = company;
        this.test = null;
    }

    public boolean createTest(String testID, String nhscode, TestType testType, Category category, parameterTest parameterTest )  {
        this.test = this.company.createtest(testID, nhscode,testType, category,parameterTest ) ;
        return this.company.validateTest(test);
    }
    public boolean saveTest() {
        return this.company.saveTest(test);
    }
}
