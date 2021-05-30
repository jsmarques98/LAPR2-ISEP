package app.ui.console;

import app.controller.App;
import app.controller.RecordTestResultsController;
import app.domain.model.Company;
import app.domain.model.Test;
import app.ui.console.utils.Utils;
import com.example1.ExternalModule3API;

import java.util.ArrayList;
import java.util.Scanner;

public class RecordTestResultsUI implements Runnable {

    private RecordTestResultsController controller;
    private ExternalModule3API apiBlood;

    private Company company;

    public RecordTestResultsUI() {
        controller = new RecordTestResultsController();
        company = App.getInstance().getCompany();
        apiBlood = new ExternalModule3API();
    }

    public void run() {
        String id = null;
        System.out.println(company.getTests().get(0).getSamples());

        Scanner sc = new Scanner(System.in);
        String option = "";


        int i = 1;
        for (Test t : company.getTests()) {
            System.out.printf("[%d] - %s\n", i, t.getTestID());
            i++;
        }

        ArrayList lista = new ArrayList();

        boolean flag = false;

        while (!flag) {

            id = Utils.readLineFromConsole("Escolha o teste desejado: ");
            for (Test t : company.getTests()) {
                if (t.getTestID().equals(id)) {
                    lista = t.getListParameterTestCode();
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("O ID é inválido.");
            }
        }
            System.out.println(lista);


        int acessKey = 12345;
        double min, max, registeredValue;
        String medida;


        for (int j = 0; j < lista.size(); j++) {

            min = apiBlood.getMinReferenceValue(String.valueOf(lista.get(j)), acessKey);
            max = apiBlood.getMaxReferenceValue(String.valueOf(lista.get(j)), acessKey);
            medida = apiBlood.usedMetric(String.valueOf(lista.get(j)), acessKey);

            registeredValue = Utils.readDoubleFromConsole("Insert the result of " + lista.get(j) + ": ");

            if (Utils.confirm()) {

                if (controller.createValueRecords(id, min, max, registeredValue)) {
                    System.out.println("Value Records successfully created with metrics: " + medida);
                    controller.saveValueRecords();
                } else {
                    System.out.println("Value Records not created");
                }
            } else {
                System.out.println("Operation canceled");
            }
        }
    }
}





