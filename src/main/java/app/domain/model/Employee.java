package app.domain.model;

import java.lang.*;
import java.util.ArrayList;
import java.util.Random;

public class Employee {

    private String id;
    private String roleId;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String socCode;
    private String password;


    public Employee (String roleId, String name, String address, String phoneNumber, String email, String socCode){
        this.roleId = roleId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
        this.id = createEmployeeId();
        this.password = generatePasswordEmployee();
    }

    public void setRole(String role) {
        this.roleId = role;
    }

    public String getName() {return name;}

    public String getId() {
        return id;
    }

    public String getPassword() { return password; }

    public String getRoleId() { return roleId; }

    public String getEmail() { return email;}

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
                ", roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", socCode='" + socCode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
