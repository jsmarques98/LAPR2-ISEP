package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.Test;

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

    public boolean createTest(String testID, String nhscode) {
        this.test = this.company.createtest(testID, nhscode);
        return this.company.validateTest(test);
    }
    public boolean saveTest() {
        return this.company.saveTest(test);
    }
}
