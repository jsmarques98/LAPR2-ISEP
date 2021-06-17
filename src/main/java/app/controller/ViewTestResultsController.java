package app.controller;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ViewTestResultsController {



    private Company company;
    private AuthFacade authFacade;

    public ViewTestResultsController() {
        this.company = App.getInstance().getCompany();
        this.authFacade = company.getAuthFacade();
    }

    public List<Test> clientTests() {
        List<Test> listaTestesCliente = new ArrayList<>();
        for (Test t : Company.tests) {
            if(t.getTinNumber().equals(clientSignedIn().getTINNumber())){
                listaTestesCliente.add(t);
            }
        }


        return listaTestesCliente;
    }

    public Client clientSignedIn() {
        UserSession currentSession = authFacade.getCurrentUserSession();
        String userName = currentSession.getUserName();

        for (Client c : Company.clientsList) {
            if (c.getEmail().equals(userName)) {
                return c;
            }

        }
        return null;
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {

        }
        return props;
    }
}
