package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.Test;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
        this.authFacade.addUserWithRole("specialist doctor", "specdoc@lei.sem2.pt", "123456", Constants.ROLE_SEPECIALIST_DOCTOR);
        this.authFacade.addUserWithRole("mlt", "mlt@lei.sem2.pt", "123456", Constants.ROLE_MEDICAL_LAB_TECHNICIAN);

    /*    this.company.save(new Test());
        this.company.save(new Test());
        this.company.save(new Test());
        this.company.save(new Test());
        this.company.save(new Test());
        this.company.save(new Test());*/
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
