package app.controller;

import app.domain.model.Client;
import app.domain.model.Test;
import app.domain.model.ValueRecords;

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
        for (Test t : company.tests) {
            if(t.getTinNumber().equals(client.getTINNumber())){
                listaTestesClients.add(t);
            }
        }

        return listaTestesClients;
    }

    public List<ValueRecords> valueRecords(Test t){
        List<ValueRecords> listaFinal= new ArrayList<>();
        for (ValueRecords v : company.valueRecordsList) {
            if(v.getId().equals(t.getTestID())){
                listaFinal.add(v);
            }
        }
        return listaFinal;
    }
}
