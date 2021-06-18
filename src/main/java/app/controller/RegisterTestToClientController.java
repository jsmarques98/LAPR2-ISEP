package app.controller;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.Date;

public class RegisterTestToClientController {
    private Company company;
    public Test test;

    public RegisterTestToClientController() {
        company = App.getInstance().getCompany();
    }

    public boolean createTest(String tinNumber, String nhscode, String description, String idTestType , ArrayList listCodeCategory, ArrayList listParameterTestCode)  {
        this.test = this.company.createtest(tinNumber, nhscode, description, idTestType ,listCodeCategory, listParameterTestCode) ;
        return this.company.validateTest(test);
    }

    public boolean saveTest() {
        test.setTest_Reg_DateHour(new Date());
        return this.company.saveTest(test);
    }

}
