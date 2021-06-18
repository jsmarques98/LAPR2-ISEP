package app.ui.console;

import app.controller.ConsultTestsController;
import app.domain.model.Client;
import app.domain.model.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultTestsUI implements Runnable{

    private final ConsultTestsController controller;

    public ConsultTestsUI() {
        controller = new ConsultTestsController();
    }

    @Override
    public void run() {

        Scanner sc = new Scanner(System.in);
        List<Client> listaC = new ArrayList<>();
        listaC = controller.clientsList();
        if(listaC.isEmpty()){
            System.out.println("Não há clientes registados.");
        }else{
            for (Client c : listaC ) {
                System.out.println(c.toString());
            }
            System.out.println("\nEscolha o cliente :");
            int option = sc.nextInt();
            Client c = listaC.get(option-1);
            List<Test> lista = new ArrayList<>();
            lista = controller.clientTestsConsult(c);
            if(lista.isEmpty()){
                System.out.println("Não existem testes associados a este cliente.");
            }else{
                for (Test t : lista ) {
                    System.out.println(t);
                }
            }

        }
    }
}
