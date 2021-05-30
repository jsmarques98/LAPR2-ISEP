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
        System.out.println("Enter the test type id: ");
        String id = sc.nextLine();
        System.out.println("Enter the description: ");
        String desc = sc.nextLine();
        System.out.println("Enter the collection method: ");
        String coll = sc.nextLine();
        System.out.println("Categories list: ");
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
            System.out.println("Choose the desired category:\nNote: Type 0 to finish.");
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
        System.out.println("Your information: ");
        System.out.printf(" ID = %s | Description = %s | Collection method = %s | Categories List = %s\n "
                , id, desc, coll, listCat);
        System.out.println("Do you confirm the information? (Y/N)");
        String f = sc.nextLine();
        if (f.equalsIgnoreCase("Y")){
            controller.specifyTypeOfTest(id,desc,coll,listCat);
            System.out.println("Test type created.");
        }else{
            System.out.println("The test type was not created.");
        }
        System.out.println(company.getTestTypes().getRecord());
    }
}
