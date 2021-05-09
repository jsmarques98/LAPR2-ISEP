package app.domain.model;

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


}


