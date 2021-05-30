package app.ui.console;

import app.controller.App;
import app.controller.SpecifyTypeTestController;
import app.domain.model.Category;
import app.domain.model.Company;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class SpecifyTypeTestUI implements Runnable {
    private final SpecifyTypeTestController controller;
    private Company company;

    public SpecifyTypeTestUI() {
        controller = new SpecifyTypeTestController();
        company = App.getInstance().getCompany();
    }

    public void run() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o id do tipo de teste:");
        String id = sc.nextLine();
        System.out.println("Insira a descrição:");
        String desc = sc.nextLine();
        System.out.println("Insira o modo de coleta:");
        String coll = sc.nextLine();
        System.out.println("Lista de categorias:");
        //List<Category> lst = company.getCategories();
        List<Category> lst = new ArrayList<>();
        lst.add(new Category("categoria1","codigo1"));
        lst.add(new Category("categoria2","codigo2"));
        lst.add(new Category("categoria3","codigo3"));
        Set<Category> listCat = new TreeSet<Category>();
        String option = "";
        while (true) {

            int i = 1;
            for (Category c : lst) {
                System.out.printf("[%d] - %s\n", i, c.getName());
                i++;
            }
            System.out.println("Escolha a categoria desejada:\nNota: Escreva 0 para terminar.");
            Category c = null;
            option = sc.nextLine();
            if (!option.equals("0")) {
                c = lst.get(Integer.parseInt(option)-1);
                lst.remove(c);
                listCat.add(c);
            } else {
                break;
            }
        }
        System.out.println("A sua informação: ");
        System.out.printf(" ID = %s | Description = %s | Collection method = %s | Categories List = %s\n "
                , id, desc, coll, listCat);
        System.out.println("Confirma a informação? (Y/N)");
        String f = sc.nextLine();
        if (f.equalsIgnoreCase("Y")){
            controller.specifyTypeOfTest(id,desc,coll,listCat);
            System.out.println("Tipo de teste criado.");
        }else{
            System.out.println("O tipo de teste não foi criado.");
        }
        System.out.println(company.getTestTypes().getRecord());
    }
}
