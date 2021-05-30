package app.dto;

import java.util.Objects;

public class ClientDTO {
    String name;
    String CCNumber;
    String NHSNumber;
    String birthdate;
    String TINNumber;
    String phoneNumber;
    String email;
    String sex;
    String Password;


    public String getName() {
        return name;
    }

    public String getCCNumber() {
        return CCNumber;
    }

    public String getNHSNumber() {
        return NHSNumber;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getTINNumber() {
        return TINNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return Password;
    }

    public ClientDTO(String name, String number, String cCard, String nhs, String date, String phoneNumber, String email, String password) {

        this.name = name;
        this.TINNumber = number;
        this.CCNumber = cCard;
        this.NHSNumber = nhs;
        this.birthdate = date;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sex = sex;
        this.Password = password;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(phoneNumber, clientDTO.phoneNumber) && Objects.equals(email, clientDTO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, email);
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", CCNumber='" + CCNumber + '\'' +
                ", NHSNumber='" + NHSNumber + '\'' +
                ", birthdate='" + birthdate + '\'' + '\'' +
                ", TINNumber='" + TINNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
