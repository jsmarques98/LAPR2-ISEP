package app.controller;

import app.domain.model.*;
import app.dto.ClientDTO;

public class RegisterClientController {

    private Company company;
    private Client client;
    public RegisterClientController() {
        this(App.getInstance().getCompany());
    }


    public RegisterClientController(Company company) {
        this.company = company;
        this.client = null;
    }


    public boolean createClient(String name, String TINNumber, String address, String gender, String cCard, String nhs, String date, String phoneNumber, String email) {
        this.client = this.company.createClient(name, TINNumber, address, gender, cCard, nhs, date, phoneNumber, email);
        return this.company.validateClient(client);
    }

    public boolean saveClient() {
        return this.company.saveClient(client);
    }




}




