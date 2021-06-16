package app.domain.model;

import app.domain.shared.Constants;

import java.io.Serializable;
import java.io.StringReader;
import java.util.Objects;

public class Client implements Serializable {

    String name;
    String CCNumber;
    String NHSNumber;
    String address;
    String gender;
    String birthdate;
    String TINNumber;
    String phoneNumber;
    String email;
    String password;
    private String roleId;

    public Client(String name, String TINNumber, String address, String gender, String cCard, String nhs, String date, String phoneNumber, String email) {

        this.name = name;
        this.TINNumber = TINNumber;
        this.address = address;
        this.gender = gender;
        this.CCNumber = cCard;
        this.NHSNumber = nhs;
        this.birthdate = date;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = "1234566789";
        this.roleId = Constants.ROLE_CLIENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(email, client.email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", CCNumber='" + CCNumber + '\'' +
                ", NHSNumber='" + NHSNumber + '\'' +
                ", Addres='"+ address+'\''+
                ", gender='"+ gender+'\''+
                ", birthdate='" + birthdate + '\'' +
                ", TINNumber='" + TINNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }

    public String getCCNumber() {
        return CCNumber;
    }

    public String getTINNumber() {
        return TINNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRoleID() {
        return roleId;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() { return address; }

    public String getGender() { return gender; }

    public void setAddress(String address) { this.address = address; }

    public void setGender(String gender) { this.gender = gender; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

     public void setGender(String gender) {
        this.gender = gender;
    }
}

