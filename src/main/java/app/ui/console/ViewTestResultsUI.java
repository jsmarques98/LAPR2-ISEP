package app.ui.console;

import app.controller.App;
import app.controller.ViewTestResultsController;
import app.domain.model.Test;
import auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

public class ViewTestResultsUI implements Runnable {

    private final ViewTestResultsController controller;

    public ViewTestResultsUI() {
        controller = new ViewTestResultsController();
    }


    @Override
    public void run() {
        List<Test> lista = new ArrayList<>();
        lista = controller.clientTests();
        if(lista.isEmpty()){
            System.out.println("nao ha testes ");
        }else {
            for (Test t : lista) {
                System.out.println(t);
            }
        }
    }
}
