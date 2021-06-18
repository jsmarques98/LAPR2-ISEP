package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Test;

import java.util.ArrayList;
import java.util.List;

public class ConsultTestsController {

    private Company company;
    private Client client;

    public ConsultTestsController() {
        this.company = App.getInstance().getCompany();
    }

    public List<Client> clientsList(){
        List<Client> listaClientes = company.getClientsList();
        return listaClientes;
    }

    public List<Test> clientTestsConsult(Client client) {
        List<Test> listaTestesClients = new ArrayList<>();
        for (Test t : Company.tests) {
            if(t.getTinNumber().equals(client.getTINNumber())){
                listaTestesClients.add(t);
            }
        }

        return listaTestesClients;
    }
}
