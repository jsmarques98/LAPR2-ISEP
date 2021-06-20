package app.controller;

import app.domain.model.Test;
import app.domain.model.ValueRecords;

import java.util.Date;
import java.util.List;

public class ValidationController {

    Company company;

   public ValidationController() {
       this.company = App.getInstance().getCompany();

   }

    public List<Test> getdata(){
    return company.getTestsWhitSamples();
    }

    public void validate(Test test){
       Date currDate = new Date();
       test.setTest_Validation_DateHour(currDate);
       for (ValueRecords valueRecords : company.getValueRecords(test.getTestID())) {
           valueRecords.setDate(currDate);
       }
    }


}
