package app.domain.model;

public class ClinicalChemestryTechnologist extends Employee{


    public ClinicalChemestryTechnologist(String roleId, String name, String address, String phoneNumber, String email, String socCode, Lab lab) {
        super(roleId, name, address, phoneNumber, email, socCode, lab);
    }
}
