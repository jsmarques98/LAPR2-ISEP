package app.ui.console;

import app.controller.App;
import app.controller.ViewTestResultsController;
import app.domain.model.Test;
import auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewTestResultsUI implements Runnable {

    private final ViewTestResultsController controller;

    public ViewTestResultsUI() {
        controller = new ViewTestResultsController();
    }


    @Override
    public void run() {

        Scanner sc = new Scanner(System.in);
        List<Test> lista = new ArrayList<>();
        lista = controller.clientTests();
        if(lista.isEmpty()){
            System.out.println("Não há testes associados a este cliente.");
        }else {
            for (Test t : lista) {
                System.out.println(t.toStringIdTest());
            }
            System.out.println("Escolha o teste que quer visualizar:");
            int option = sc.nextInt();
            System.out.println(lista.get(option-1));
        }
    }
}
