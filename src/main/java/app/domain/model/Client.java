package app.domain.model;

import java.util.Objects;

public class Client {
    String name;
    String CCNumber;
    String NHSNumber;
    String birthdate;
    String TINNumber;
    String phoneNumber;
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public Client(String name, String TINNumber, String cCard, String nhs, String date, String phoneNumber, String email) {

        this.name = name;
        this.TINNumber = TINNumber;
        this.CCNumber = cCard;
        this.NHSNumber = nhs;
        this.birthdate = date;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = "";
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

    public String getEmail() { return email; }
}


