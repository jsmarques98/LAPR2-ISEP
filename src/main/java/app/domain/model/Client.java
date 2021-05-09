package app.domain.model;

import java.util.Objects;

public class Client {
    String name;
    String CCNumber;
    String NHSNumber;
    String birthdate;
    String sex;
    String TINNumber;
    String phoneNumber;
    String email;
    String Password;




    public Client(String name, String number, String cCard, String nhs, String date, String phoneNumber, String email, String password) {

        this.name = name;
        this.TINNumber = number;
        this.CCNumber = cCard;
        this.NHSNumber = nhs;
        this.birthdate = date;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.Password = password;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, email);
    }
}


