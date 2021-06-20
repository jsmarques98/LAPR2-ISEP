package app.ui.console;

import app.controller.ViewTestResultsController;
import app.domain.model.Test;
import app.domain.model.ValueRecords;

import java.util.*;

public class ViewTestResultsUI implements Runnable {

    private final ViewTestResultsController controller;

    public ViewTestResultsUI() {
        controller = new ViewTestResultsController();
    }


    @Override
    public void run() {

        Scanner sc = new Scanner(System.in);
        List<Test> lista = new ArrayList<>();
        List<ValueRecords> listaValueRecords= new ArrayList<>();
        lista = controller.clientTests();
        Collections.sort(lista, Collections.reverseOrder(Comparator.comparing(Test::getTest_Reg_DateHour)));
        if (lista.isEmpty()) {
            System.out.println("Não há testes associados a este cliente.");
        } else {
            for (Test t : lista) {
                System.out.println(t.toStringIdTest());
            }
            System.out.println("\nEscolha o teste que quer visualizar:");
            int option = sc.nextInt();
            Test t = lista.get(option - 1);
            listaValueRecords = controller.valueRecords(t);
            System.out.println(t);
            for (ValueRecords v : listaValueRecords ) {
                System.out.println(v);
            }
        }
    }
}
