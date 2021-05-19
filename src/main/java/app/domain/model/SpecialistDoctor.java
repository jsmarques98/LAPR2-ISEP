package app.domain.model;

public class SpecialistDoctor extends Employee {

    private String doctorIndxNumber;

    public SpecialistDoctor(String roleId, String name, String address, String phoneNumber, String email, String socCode, String indxNumber) {
        super(roleId, name, address, phoneNumber, email, socCode);
        checkIndxNumberRules(indxNumber);
        this.doctorIndxNumber = indxNumber;
    }

    private void checkIndxNumberRules(String indxNumber) {
        if (indxNumber.length() < 1 )
            throw new IllegalArgumentException("indxNumber cannot be blank.");
        if ( (indxNumber.length() > 7))
            throw new IllegalArgumentException("indxNumber must have 6 chars.");
    }
}
