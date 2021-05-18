package app.domain.model;

import java.lang.*;
import java.util.ArrayList;
import java.util.Random;

public class Employee {

    private String id;
    private String role;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String socCode;
    private String password;


    public Employee (String role, String name, String address, String phoneNumber, String email, String socCode){
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
        this.id = createEmployeeId();
        this.password = generatePasswordEmployee();
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

        if(!this.roles.contains(role))
            throw new IllegalArgumentException("role does note exists");
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {return name;}

    public String getId() {
        return id;
    }

    public String getPassword() { return password; }

    /**
     * Método que converte o nome completo em iniciais do empregado
     * e devolve uma String com essas iniciais e o seu número
     *
     * @return String com iniciais + número
     */
    public String createEmployeeId(){
        int num = Company.employeeList.size()+1;
        String temp = "";
        String[] arr = name.split(" ");
        for (String var : arr) {
            temp += var.charAt(0);
        }
        temp += String.valueOf(num);
        return temp;
    }

    public String generatePasswordEmployee() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static ArrayList<String> roles = new ArrayList<>(5);

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", socCode='" + socCode + '\'' +
                '}';
    }
}
