package app.domain.model;

import app.dto.ClientDTO;
import auth.domain.model.User;

public class Receptionist {

    private Client registeredClient = null;

    //convert ClientDTO to Client and assign it to registeredClient
    public void createClient(ClientDTO clientDTO){


    }

    public Client getClient(){
        return registeredClient;
    }


}
