package app.ui.console;

import app.controller.App;
import app.controller.ViewTestResultsController;
import app.domain.model.Client;
import app.domain.model.Company;
import auth.domain.model.Email;

public class ViewTestResultsUI implements Runnable {

    private final ViewTestResultsController controller;

    public ViewTestResultsUI() {
        controller = new ViewTestResultsController();
    }


    @Override
    public void run() {
        Email email = App.getInstance().getCurrentUserSession().getUserId();
        System.out.println(cont);


    }
}
