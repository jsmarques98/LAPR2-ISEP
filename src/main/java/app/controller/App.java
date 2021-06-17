package app.controller;

import app.Adapter.BarcodeAdapter;
import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;

    private String barcodeAdapter;

    private static Logger LOGGER;

    //change this to false in release version
    private static final boolean DEBUG_MODE = true;

    private App() {
        LOGGER = Logger.getLogger(App.class.getName());

        FileHandler fh;

        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("serializationLogger.log");
            LOGGER.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!DEBUG_MODE)
            LOGGER.setUseParentHandlers(false);


        Properties props = null;

        if(!load()) {
            props = getProperties();
            this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
            this.authFacade = this.company.getAuthFacade();
            bootstrap();
        }
        props = getProperties();
        barcodeAdapter = props.getProperty("BarcodeAdapter");
        this.authFacade = this.company.getAuthFacade();


    }

    public boolean save(Object o){
        String className = o.getClass().getName();
        int classHash = o.hashCode();
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("data/company.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(company);
            out.close();
            fileOut.close();
            LOGGER.info("Saving " + className + " with HashCode: " + classHash);
            LOGGER.info("Serialized data is saved in data/company.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
        return true;
    }

    public boolean load(){

        try {
            FileInputStream fileIn = new FileInputStream("data/company.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.company = (Company) in.readObject();
            in.close();
            fileIn.close();
            LOGGER.info("Serialized data is loaded from data/company.ser");
        } catch (IOException i) {
            LOGGER.warning("Company in data/company.ser not found! Running bootstrap!");
            return false;
        } catch (ClassNotFoundException c) {
            LOGGER.warning("Company class not found");
            return false;
        }
        return true;
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

        //Como não está implementado inserimos manualmente
        ParameterTest parameterTest1 = new ParameterTest("HB000", "Haemo", "Haemoglobin (HB)");
        ParameterTest parameterTest2 = new ParameterTest("WBC00", "White", "White Cell Count (WBC)");
        ParameterTest parameterTest3 = new ParameterTest("PLT00", "Platelet", "Platelet Count (PLT)");
        ParameterTest parameterTest4 = new ParameterTest("RBC00", "Red Blood", "Red Blood Count (RBC)");
        ParameterTest parameterTest5 = new ParameterTest("MCV00", "Mean Cell", "Mean Cell Volume (MCV)");
        ParameterTest parameterTest6 = new ParameterTest("MCH00", "Mean Haemo", "Mean Cell Haemoglobin (MCH)");
        ParameterTest parameterTest7 = new ParameterTest("MCHC0", "Mean Haemo Con.", "Mean Cell Haemoglobin Concentration (MCHC)");
        ParameterTest parameterTest8 = new ParameterTest("ESR00", "Eryth Sed. Rate", "Erythrocyte Sedimentation Rate (ESR)");
        ParameterTest parameterTest9 = new ParameterTest("IgGAN", "IgGAN", "IgGAN");
        Company.parameterList.add(parameterTest1);
        Company.parameterList.add(parameterTest2);
        Company.parameterList.add(parameterTest3);
        Company.parameterList.add(parameterTest4);
        Company.parameterList.add(parameterTest5);
        Company.parameterList.add(parameterTest6);
        Company.parameterList.add(parameterTest7);
        Company.parameterList.add(parameterTest8);
        Company.parameterList.add(parameterTest9);

        Category category1 = new Category("categoria1","codigo1");
        Category category2 = new Category("categoria2","codigo2");
        Category category3 = new Category("categoria3","codigo3");
        Category category4 = new Category("categoria4","codigo4");
        Category category5 = new Category("categoria5","codigo5");
        Company.categories.add(category1);
        Company.categories.add(category2);
        Company.categories.add(category3);
        Company.categories.add(category4);
        Company.categories.add(category5);



        Client c1 = new Client("Manuel","5555555555","5555555555555555","555555555555","03/05/2021","55555555555","manel@gmail.com");
        Client c2 = new Client("Joao","9999999999","9999999999999999","555555555555","03/05/2021","55555555555","manel@gmail.com");
        Client c3 = new Client("Rui","0000000000","0000000000000000","555555555555","03/05/2021","55555555555","manel@gmail.com");
        Company.clientsList.add(c1);
        Company.clientsList.add(c2);
        Company.clientsList.add(c3);

        //Apenas para testar
        this.authFacade.addUserWithRole("Maria", "maria@gmail.com", "123456", Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserWithRole("Jose", "jose@gmail.com", "123456", Constants.ROLE_CLINCAL_CHEMISTRY_TECHNOLOGIST);
        this.authFacade.addUserWithRole("specialist doctor", "specdoc@lei.sem2.pt", "123456", Constants.ROLE_SEPECIALIST_DOCTOR);
        this.authFacade.addUserWithRole("laboratory coordinator", "labcord@gmail.com", "123456", Constants.ROLE_LABORATORY_COORDINATOR);
        this.authFacade.addUserWithRole("mlt", "mlt@lei.sem2.pt", "123456", Constants.ROLE_MEDICAL_LAB_TECHNICIAN);



        ArrayList listCat;
        ArrayList listPara;
        listCat = new ArrayList<>();
        listPara = new ArrayList<>();
        listCat.add(category1);
        listCat.add(category2);
        listPara.add(parameterTest1);
        listPara.add(parameterTest2);

         Test test1 =  new Test("00000002880","0000","sad","sdsad1",  listCat, listPara);
        company.getTests().add(test1);
//        Test test2 =  new Test("0000000001","0001","sad1","sdsad2",  listCat, listPara);
//        Test test3 =  new Test("0000000002","0002","sad2","sdsad3",  listCat, listPara);
//        Test test4 =  new Test("0000000003","0003","sad3","sdsad4",  listCat, listPara);

//        String arg1 = "00000000001";
//        String arg2 = "00000000002";
//        String arg3 = "00000000003";
//        String arg4 = "00000000004";
//        test1.getSamples().add(new Sample(arg1, barcodeAdapter));
//        test1.getSamples().add(new Sample(arg2, barcodeAdapter));
//        test1.getSamples().add(new Sample(arg3, barcodeAdapter));
//        test1.setSampleLocalDate();
//        test1.setSampleLocalTime();
//        test2.getSamples().add(new Sample(arg4, barcodeAdapter));
//        test2.setSampleLocalDate();
//        test2.setSampleLocalTime();
//
//        company.getTests().add(test1);
//        company.getTests().add(test2);
//        company.getTests().add(test3);
//        company.getTests().add(test4);
//
//
//       Test test1 =  new Test("0000000000","0000","sad","sdsad1",  listCat, listPara);
//        Test test2 =  new Test("0000000001","0001","sad1","sdsad2",  listCat, listPara);
//        Test test3 =  new Test("0000000002","0002","sad2","sdsad3",  listCat, listPara);
//        Test test4 =  new Test("0000000003","0003","sad3","sdsad4",  listCat, listPara);
//
//        String arg1 = "00000000001";
//        String arg2 = "00000000002";
//        String arg3 = "00000000003";
//        String arg4 = "00000000004";
//        test1.getSamples().add(new Sample(arg1, barcodeAdapter));
//        test1.getSamples().add(new Sample(arg2, barcodeAdapter));
//        test1.getSamples().add(new Sample(arg3, barcodeAdapter));
//        test1.setSampleLocalDate();
//        test1.setSampleLocalTime();
//        test2.getSamples().add(new Sample(arg4, barcodeAdapter));
//        test2.setSampleLocalDate();
//        test2.setSampleLocalTime();
//
//        company.getTests().add(test1);
//        company.getTests().add(test2);
//        company.getTests().add(test3);
//        company.getTests().add(test4);


//        company.getTests().add(test1);
//        company.getTests().add(test2);
//        company.getTests().add(test3);
//        company.getTests().add(test4);
//
//        Set<Category> listCat1 = new TreeSet<Category>();
//        listCat1.add(category1);
//        listCat1.add(category2);
//        listCat1.add(category3);
//        Set<Category> listCat2 = new TreeSet<Category>();
//        listCat2.add(category4);
//        listCat2.add(category5);
//
//        TestType t1 = new TestType("12345","desc1","colect1",listCat1);
//        TestType t2 = new TestType("54321","desc2","colect2",listCat2);
//        Company.record.add(t1);
//        Company.record.add(t2);


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
