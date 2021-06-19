package app.ui.console;

import app.controller.ConsultTestsController;
import app.domain.model.Client;
import app.domain.model.Test;
import app.Adapter.SortClientsAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultTestsUI implements Runnable {

    private final ConsultTestsController controller;
    private final SortClientsAlgorithms algorithms;

    public ConsultTestsUI() {
        controller = new ConsultTestsController();
        algorithms = new SortClientsAlgorithms();
    }

    @Override
    public void run() {

        Scanner sc = new Scanner(System.in);
        List<Client> listaC = new ArrayList<>();
        listaC = controller.clientsList();
        System.out.println("How do you want to sort the clients list? (NAME or TIN)");
        String option = sc.nextLine();
        if (listaC.isEmpty()) {
            System.out.println("No clients registered in the system.");
        } else {
            if (option.equals("NAME")) {
                algorithms.showNameList(listaC);
            } else {
                if (option.equals("TIN")) {
                    algorithms.showTINList(listaC);
                }
            }
            System.out.println("\nChoose the client:");
            int option1 = sc.nextInt();
            Client c = listaC.get(option1 - 1);
            List<Test> lista = new ArrayList<>();
            lista = controller.clientTestsConsult(c);
            if (lista.isEmpty()) {
                System.out.println("There are no tests associated to that client.");
            } else {
                for (Test t : lista) {
                    System.out.println(t.toStringIdTest());
                }
                System.out.println("\n Choose the test you want to analyze: ");
                int option2 = sc.nextInt();
                Test t = lista.get(option2-1);
                System.out.println(t.toString());
            }
        }
    }
}
