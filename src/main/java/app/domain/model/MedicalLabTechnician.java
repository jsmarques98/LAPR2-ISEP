package app.domain.model;

public class MedicalLabTechnician extends Employee{

    public MedicalLabTechnician(String roleId, String name, String address, String phoneNumber, String email, String socCode, Lab lab) {
        super(roleId, name, address, phoneNumber, email, socCode, lab);
    }
}
