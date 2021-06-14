package app.controller;

import app.domain.model.Company;

public class ImportTestsController {
    Company company;

    public ImportTestsController(){
        this.company = App.getInstance().getCompany();
    }

    public void importFrom( String path ){

    }


}
