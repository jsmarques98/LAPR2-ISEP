package app.ui.console;

import app.controller.App;
import app.domain.model.Client;
import app.domain.model.Company;
import auth.domain.model.Email;

public class ViewTestResultsUI implements Runnable {
    @Override
    public void run() {
        Email email = App.getInstance().getCurrentUserSession().getUserId();
        Client currentClient = null;
        for (Client c : Company.clientsList) {
            if (email.getEmail().equals(c.getEmail())) {
                currentClient = c;
            }
        }
        System.out.println("Client Menu:\n");
        assert currentClient != null;
        System.out.println("Client info:\n" + currentClient);
    }
}
