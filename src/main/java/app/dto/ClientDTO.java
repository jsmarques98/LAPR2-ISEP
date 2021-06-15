package app.dto;

public class ClientDTO {
    String name;
    String CCNumber;
    String NHSNumber;
    String birthdate;
    String TINNumber;
    String phoneNumber;
    String email;
    String Password;
    String roleID = "Client";


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

    public String getRoleID() {
        return roleID;
    }

    public ClientDTO(String name, String number, String cCard, String nhs, String date, String phoneNumber, String email, String password) {

        this.name = name;
        this.TINNumber = number;
        this.CCNumber = cCard;
        this.NHSNumber = nhs;
        this.birthdate = date;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.Password = password;
        this.roleID = roleID;
    }

}
