package app.controller;

import java.util.List;

public class Company {

    private List<RegisterLab>registerLabList;
    private List<RegisterTest>registerTestList;

    public RegisterLab registerLab(String labId, String name, String address, int phoneNr, int TINnr){
        return new RegisterLab(labId, name, address, phoneNr, TINnr);
    }

    public RegisterTest registerTest(String testName, String sample){
        return new RegisterTest(testName, sample);
    }

    public boolean validateLab(RegisterLab lab){
        if (lab == null)
        {
            return false;
        }
        return ! this.registerLabList.contains(lab);
    }

    public boolean validateTest(RegisterTest test){
        if (test == null){
            return false;
        }
        return ! this.registerTestList.contains(test);
    }

    public boolean saveLab(RegisterLab lab){
        if (!validateLab(lab)){
            return false;
        }
        return this.registerLabList.add(lab);
    }

    public boolean saveTest(RegisterTest test){
        if (!validateTest(test)) {
            return false;
        }
        return this.registerTestList.add(test);
    }

}
