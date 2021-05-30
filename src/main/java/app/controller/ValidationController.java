package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;

import java.util.List;

public class ValidationController {

    Company company;

   public ValidationController() {
       this.company = App.getInstance().getCompany();

   }

    public List<Test> getdata(){
    company.getTestsWhitSamples();
    return company.getTestsWhitSamples();
    }


}
