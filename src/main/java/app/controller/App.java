package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;

    private String barcodeAdapter;

    private App() {
        Properties props = getProperties();
        this.barcodeAdapter = props.getProperty("BarcodeAdapter");
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    public Company getCompany() {
        return this.company;
    }

    public String getBarcodeAdapter(){
            return barcodeAdapter;
    }

    public UserSession getCurrentUserSession() {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd) {
        return this.authFacade.doLogin(email, pwd).isLoggedIn();
    }

    public void doLogout() {
        this.authFacade.doLogout();
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {

        }
        return props;
    }


    private void bootstrap() {
        Employee.roles.add(Constants.ROLE_ADMIN);
        Employee.roles.add(Constants.ROLE_RECEPTIONIST);
        Employee.roles.add(Constants.ROLE_CLINCAL_CHEMISTRY_TECHNOLOGIST);
        Employee.roles.add(Constants.ROLE_LABORATORY_COORDINATOR);
        Employee.roles.add(Constants.ROLE_MEDICAL_LAB_TECHNICIAN);
        Employee.roles.add(Constants.ROLE_SEPECIALIST_DOCTOR);

        this.authFacade.addUserRole(Constants.ROLE_ADMIN, Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST, Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_CLINCAL_CHEMISTRY_TECHNOLOGIST, Constants.ROLE_CLINCAL_CHEMISTRY_TECHNOLOGIST);
        this.authFacade.addUserRole(Constants.ROLE_LABORATORY_COORDINATOR, Constants.ROLE_LABORATORY_COORDINATOR);
        this.authFacade.addUserRole(Constants.ROLE_MEDICAL_LAB_TECHNICIAN, Constants.ROLE_MEDICAL_LAB_TECHNICIAN);
        this.authFacade.addUserRole(Constants.ROLE_SEPECIALIST_DOCTOR, Constants.ROLE_SEPECIALIST_DOCTOR);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456", Constants.ROLE_ADMIN);

        //Apenas para testar
        this.authFacade.addUserWithRole("Maria", "maria@gmail.com", "123456", Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserWithRole("specialist doctor", "specdoc@lei.sem2.pt", "123456", Constants.ROLE_SEPECIALIST_DOCTOR);
        this.authFacade.addUserWithRole("mlt", "mlt@lei.sem2.pt", "123456", Constants.ROLE_MEDICAL_LAB_TECHNICIAN);

        Client c1 = new Client("Manuel","5555555555","5555555555555555","555555555555","03/05/2021","55555555555","manel@gmail.com","123456");
        Client c2 = new Client("Joao","9999999999","9999999999999999","555555555555","03/05/2021","55555555555","manel@gmail.com","123456");
        Client c3 = new Client("Rui","0000000000","0000000000000000","555555555555","03/05/2021","55555555555","manel@gmail.com","123456");
        Company.clientsList.add(c1);
        Company.clientsList.add(c2);
        Company.clientsList.add(c3);

        Set<Category> listCat1 = new TreeSet<Category>();
        Set<Category> listCat2 = new TreeSet<Category>();
        listCat1.add(new Category("categoria1","codigo1"));
        listCat1.add(new Category("categoria2","codigo2"));
        listCat2.add(new Category("categoria3","codigo3"));
        listCat2.add(new Category("categoria4","codigo4"));
        TestType t1 = new TestType("99999","desc1", "colect1", listCat1);
        TestType t2 = new TestType("00000","desc2", "colect2", listCat2);
        Company.testList.add(t1);
        Company.testList.add(t2);

    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;

    public static App getInstance() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
            }
        }
        return singleton;
    }

}
