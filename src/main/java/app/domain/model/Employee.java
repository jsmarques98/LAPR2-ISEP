package app.domain.model;



public class Employee {


    private String role;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String socCode;


    public Employee (String id, String role, String name, String address, String phoneNumber, String email, String socCode, String passe){
//    id =
        checkRoleRules(role);
        checkNameRules(name);
        checkAddressRules(address);
        checkPhoneNUmberRules(phoneNumber);
        checkEmailRules(email);
        checkSocCodeRules(socCode);


        this.role = role;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
//        passe =

    }



    private void checkSocCodeRules(String socCode) {
        if (socCode.length() == 0)

            throw new IllegalArgumentException("socCode cannot be blank.");
        if ( (socCode.length() > 5))
            throw new IllegalArgumentException("socCode must have 5 chars.");
    }

    private void checkEmailRules(String email) {
        if (email.length() == 0 )
            throw new IllegalArgumentException("email cannot be blank.");
        if ( (email.length() > 41))
            throw new IllegalArgumentException("email must have les the 40 chars.");
    }

    private void checkPhoneNUmberRules(String phoneNumber) {
        if (phoneNumber.length() == 0 )
            throw new IllegalArgumentException("phoneNumber cannot be blank.");
        if ( (phoneNumber.length() > 12))
            throw new IllegalArgumentException("phoneNumber must have 11 chars.");
    }


    private void checkAddressRules(String address) {
        if (address.length() == 0 )
            throw new IllegalArgumentException("address cannot be blank.");
        if ( (address.length() > 31))
            throw new IllegalArgumentException("address must have les the 31 chars.");
    }

    private void checkNameRules(String name) {
        if (name.length() == 0 )
            throw new IllegalArgumentException("name cannot be blank.");
        if ( (name.length() > 36))
            throw new IllegalArgumentException("name must have les the 36 chars.");

}

    private void checkRoleRules(String role) {
        if (role.length() == 0 )
            throw new IllegalArgumentException("role cannot be blank.");
        if ( (role.length() > 16))
            throw new IllegalArgumentException("role must have les the 16 chars.");
    }

    public void setRole(String role) {
        this.role = role;
    }
}
