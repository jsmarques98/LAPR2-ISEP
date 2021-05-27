package app.ui.console;

import app.controller.App;
import app.controller.RecordTestResultsController;
import app.controller.SpecifyTypeTestController;
import app.domain.model.*;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.xml.bind.ValidationEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecordTestResultsUI implements Runnable {

    private RecordTestResultsController controller;

    private Company company;

    public RecordTestResultsUI() {
        controller = new RecordTestResultsController();
        company = App.getInstance().getCompany();
    }

    public void run() {
        System.out.println(company.getTests().get(0).getSamples());

        Scanner sc = new Scanner(System.in);
        String option = "";


        int i = 1;
        for (Test t : company.getTests()) {
            System.out.printf("[%d] - %s\n", i, t.getDescription());
            i++;
        }
        System.out.println("Escolha o teste desejado:");

        option = sc.nextLine();

        if(Integer.parseInt(option) <= 0 || Integer.parseInt(option) > company.getTests().size()){
            System.out.println("O valor introduzido é inválido.");
            return;
        }


        Test t = company.getTests().get(Integer.parseInt(option) - 1);
        controller.setTest(t);
        Map<String, ValueRecords> map = new HashMap<String, ValueRecords>() ;

        for(Sample s : t.getSamples()){
            System.out.println("Digite os valores da Hemoglobina");
            double hemo = Double.parseDouble(sc.nextLine());
            s.setHB000(hemo);
            controller.putRecord(s,"HB000", 0, 1, hemo);
            System.out.println("Digite os valores da Glóbulos Brancos");
            double globb = Double.parseDouble(sc.nextLine());
            s.setWBC00(globb);
            System.out.println("Digite os valores das Plaquetas");
            double plaq = Double.parseDouble(sc.nextLine());
            s.setPLT00(plaq);
            System.out.println("Digite os valores dos Glóbulos Vermelhos");
            double globv = Double.parseDouble(sc.nextLine());
            s.setRBC00(globv);
            System.out.println("Digite os valores do volume das Mean Cells");
            double meanc = Double.parseDouble(sc.nextLine());
            s.setMCV00(meanc);
            System.out.println("Digite os valores da Mean Cells de Hemoglobina");
            double meanch = Double.parseDouble(sc.nextLine());
            s.setMCH00(meanch);
            System.out.println("Digite os valores das Mean Cells da Concentração de Hemoglobina");
            double meanchcon = Double.parseDouble(sc.nextLine());
            s.setMCHC0(meanchcon);
            System.out.println("Digite os valores da Erythrocyte Sedimentation Rate");
            double erySedRate = Double.parseDouble(sc.nextLine());
            s.setESR00(erySedRate);

        }



    }

}





