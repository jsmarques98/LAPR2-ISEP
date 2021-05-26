package app.controller;

import app.domain.model.*;

import java.util.ArrayList;

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

    public boolean createTest(String ccNum, String nhscode, String description, String idTestType , ArrayList listCodeCategory, ArrayList listParameterTestCode)  {
        this.test = this.company.createtest(ccNum, nhscode, description, idTestType ,listCodeCategory, listParameterTestCode) ;
        return this.company.validateTest(test);
    }
    public boolean saveTest() {
        return this.company.saveTest(test);
    }
}
