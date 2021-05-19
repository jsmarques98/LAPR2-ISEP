package app.domain.model;
import app.dto.ClientDTO;
import auth.domain.model.User;
public class Receptionist extends Employee{

    public Receptionist(String roleId, String name, String address, String phoneNumber, String email, String socCode) {
        super(roleId, name, address, phoneNumber, email, socCode);
    }

    private Client registeredClient = null;

    //convert ClientDTO to Client and assign it to registeredClient
    public void createClient(ClientDTO clientDTO){


    }

    public Client getClient(){
        return registeredClient;
    }

}
