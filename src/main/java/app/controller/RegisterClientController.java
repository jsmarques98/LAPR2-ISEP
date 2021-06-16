package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Receptionist;
import app.dto.ClientDTO;

public class RegisterClientController {
        Client client;


    private Company company;


    //factory for class Client, goes from args -> clientDTO -> client
    public Client createClient(String args[]){

        client = new Client(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        return client;
    }




    public boolean registerClient(Client client){


        boolean cliente = this.registerClient(client);
        company = App.getInstance().getCompany();
        company.save(client);
        return true;
    }


}
