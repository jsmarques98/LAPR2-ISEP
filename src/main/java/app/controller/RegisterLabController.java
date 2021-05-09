package app.controller;
import app.domain.model.Company;
public class RegisterLabController {

    private Company company;
    private RegisterLab lab;
    private RegisterTest test;

    public RegisterLabController() {
    }

    public RegisterLabController(Company company, RegisterLab lab, RegisterTest test) {
        this.company = company;
        this.lab = null;
        this.test = null;
    }

    public boolean registerLab(String labId, String name, String address, int phoneNr, int TINnr){
        this.lab = this.company.registerLab(labId, name, address, phoneNr, TINnr);
        return this.company.validateLab(lab);
    }

    public boolean registerTest(String testName, String sample){
        this.test = this.company.registerTest(testName, sample);
        return this.company.validateTest(test);
    }

    public boolean saveLab(){
        return this.company.saveLab(lab);
    }

    public boolean saveTest(){
        return this.company.saveTest(test);
    }
}
