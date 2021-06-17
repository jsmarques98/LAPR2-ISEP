package app.domain.model;

public class SpecialistDoctor extends Employee {

    private final String doctorIndxNumber;

    public SpecialistDoctor(String roleId, String name, String address, String phoneNumber, String email, String socCode, Lab lab, String indxNumber) {
        super(roleId, name, address, phoneNumber, email, socCode, lab);
        this.doctorIndxNumber = indxNumber;
    }

}
