package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Test;

import app.domain.model.ValueRecords;
import auth.AuthFacade;
import auth.UserSession;
import auth.domain.model.Email;
import java.util.ArrayList;
import java.util.List;


public class ViewTestResultsController {

    private Company company;
    private AuthFacade authFacade;

    public ViewTestResultsController() {
        this.company = App.getInstance().getCompany();
        this.authFacade = company.getAuthFacade();
    }

    public List<Test> clientTests() {
        List<Test> listaTestesClients = new ArrayList<>();
        for (Test t : company.tests) {
            if(t.getTinNumber().equals(clientSignedIn().getTINNumber())){
                listaTestesClients.add(t);
            }
        }
        return listaTestesClients;
    }

    public Client clientSignedIn() {

        Email email = App.getInstance().getCurrentUserSession().getUserId();
        UserSession currentSession = authFacade.getCurrentUserSession();

        for (Client c : company.clientsList) {
            if (email.getEmail().equals(c.getEmail())) {
                return c;
            }

        }
        return null;
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
