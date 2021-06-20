package app.Adapter;

import app.controller.App;
import app.controller.RegisterTestToClientController;
import app.domain.model.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ImportTestsCSV {

    public ImportTestsCSV(String path) throws FileNotFoundException {
        String str = null;
        File fc = new File(path);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fc));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found! File "+path+" not found!");
        }


        boolean title = true; //first line of the file are the names of the columns
        while (true) { //true until the last line of the file
            try {
                if (!((str = br.readLine()) != null)) break;
            } catch (IOException e) {
                System.out.println("End of File!");
            }
            if(!title) {
                createTest(str.split(";"));
            }
            title = false;
        }
    }

    public boolean createTest(String ... args){
            final int Test_Code = 0;
            final int NHS_Code = 1;
            //not client
            final int Lab_ID = 2;

            //client
            final int CitizenCard_Number = 3;
            final int NHS_Number = 4;
            final int TIN = 5;
            final int BirthDay = 6;
            final int PhoneNumber = 7;
            final int Name = 8;
            final int Email = 9; //to note that text representation differs from csv to csv
            final int Address = 10;


            //test
            final int TestType = 11;
            final int Category1 = 12;
            final int HB000 = 13;
            final int WBC00 = 14;
            final int PLT00 = 15;
            final int RBC00 = 16;
            final int Category2 = 17;
            final int HDL00 = 18;
            final int Category3 = 19;
            final int IgGAN = 20;
            final int Test_Reg_DateHour = 21;
            final int Test_Chemical_DateHour = 22;
            final int Test_Doctor_DateHour = 23;
            final int Test_Validation_DateHour = 24;

        String clientCitizenCard_Number = args[CitizenCard_Number];
        String clientNHS_Number = args[NHS_Number];
        String clientTIN = args[TIN];
        String clientBirthDay = args[BirthDay];
        String clientPhoneNumber = args[PhoneNumber];
        String clientName = args[Name];
        String clientEmail = args[Email];
        String clientAddress = args[Address];


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String nhsCode = args[NHS_Code];


        String testTestType = args[TestType];
        String testCategory1 = args[Category1];
        String testHB00 = args[HB000];
        String testWBC00 = args[WBC00];
        String testPLT00 = args[PLT00];
        String testRBC00 = args[RBC00];
        String testCategory2 = args[Category2];
        String testHDL00 = args[HDL00];
        String testCategory3 = args[Category3];
        String testIgGAN = args[IgGAN];

        String testCode = args[Test_Code];

        App app = App.getInstance();

        Company company = app.getCompany();

        if(company.getClient(clientEmail)!=null)
            return false;
            //throw new InvalidParameterException("Client with email " + clientEmail + " already exists!");

        if(company.getTest(testCode)!=null)
            return false;
            //throw new InvalidParameterException("Test with " + testCode + " already exists!");


        ArrayList<Category> testCategories = new ArrayList<>();

        if(!testCategory1.equals("NA"))
            testCategories.add(new Category(testCategory1,testCategory1));
        if(!testCategory2.equals("NA"))
            testCategories.add(new Category(testCategory2,testCategory2));
        if(!testCategory3.equals("NA"))
            testCategories.add(new Category(testCategory3,testCategory3));


        ArrayList<ParameterTest> parameterTests = new ArrayList<>();

        ArrayList<ValueRecords> valueRecordsList = new ArrayList<>();

        if(!testHB00.equals("NA")) {
            parameterTests.add(company.getParameterTest("HB00"));
            ValueRecords valueRecords = new ValueRecords();
            valueRecords.setId(testCode);
            valueRecords.setParameter("HB00");
            valueRecords.setRegisteredValue(Double.parseDouble(testHB00.replace(',','.')));
            valueRecordsList.add(valueRecords);
        }
        if(!testWBC00.equals("NA")) {
            parameterTests.add(company.getParameterTest("WBC00"));
            ValueRecords valueRecords = new ValueRecords();
            valueRecords.setId(testCode);
            valueRecords.setParameter("WBC00");
            valueRecords.setRegisteredValue(Double.parseDouble(testWBC00.replace(',','.')));
            valueRecordsList.add(valueRecords);
        }
        if(!testPLT00.equals("NA")) {
            parameterTests.add(company.getParameterTest("PLT00"));
            ValueRecords valueRecords = new ValueRecords();
            valueRecords.setId(testCode);
            valueRecords.setParameter("PLT00");
            valueRecords.setRegisteredValue(Double.parseDouble(testPLT00.replace(',','.')));
            valueRecordsList.add(valueRecords);
        }
        if(!testRBC00.equals("NA")) {
            parameterTests.add(company.getParameterTest("RBC00"));
            ValueRecords valueRecords = new ValueRecords();
            valueRecords.setId(testCode);
            valueRecords.setParameter("RBC00");
            valueRecords.setRegisteredValue(Double.parseDouble(testRBC00.replace(',','.')));
            valueRecordsList.add(valueRecords);
        }
        if(!testHDL00.equals("NA")) {
            parameterTests.add(company.getParameterTest("HDL00"));
            ValueRecords valueRecords = new ValueRecords();
            valueRecords.setId(testCode);
            valueRecords.setParameter("HDL00");
            valueRecords.setRegisteredValue(Double.parseDouble(testHDL00.replace(',','.')));
            valueRecordsList.add(valueRecords);
        }
        if(!testIgGAN.equals("NA")) {
            parameterTests.add(company.getParameterTest("IgGAN"));
            ValueRecords valueRecords = new ValueRecords();
            valueRecords.setId(testCode);
            valueRecords.setParameter("IgGAN");
            valueRecords.setRegisteredValue(Double.parseDouble(testIgGAN.replace(',','.')));
            valueRecordsList.add(valueRecords);
        }

        //1. RegisterClientController
        //2. RegisterTestToClientController
        //3. RegisterLabController
        //4. CreateSamplesController
        //5. RecordTestResultsController
        //6. CreateReportController
        //7. ValidationController

        Client client = new Client(clientName,clientTIN, clientAddress, "NA" ,clientCitizenCard_Number,clientNHS_Number,clientBirthDay,clientPhoneNumber,clientEmail);

        TestType testType = company.getTestType(testTestType);

        RegisterTestToClientController registerTestToClientController = new RegisterTestToClientController();

        //for(Category category : categories)
          //  if(category.getCode().equals(testCategory1) || category.getCode().equals(testCategory2) || category.getCode().equals(testCategory3))
            //    testCategories.add(category);

        registerTestToClientController.createTest(client.getTINNumber(), nhsCode, "", testType.getId(), testCategories , parameterTests);

        Test test = registerTestToClientController.test;

        try {
            test.setTestID(args[Test_Code]);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
            
        //reading the dates
        String Reg_DateHour = args[Test_Reg_DateHour];
        String Chemical_DateHour = args[Test_Chemical_DateHour];
        String Doctor_DateHour = args[Test_Doctor_DateHour];
        String Validation_DateHour = args[Test_Validation_DateHour];

        Date date = null;
        try {
            if(!Chemical_DateHour.equals("NA")) {
                test.getSamples().add(new Sample());
                test.setTest_Chemical_DateHour(sdf.parse(Chemical_DateHour));
            }

            if(!Reg_DateHour.equals("NA"))
                test.setTest_Reg_DateHour(sdf.parse(Reg_DateHour));

            if(!Doctor_DateHour.equals("NA"))
                test.setTest_Doctor_DateHour(sdf.parse(Doctor_DateHour));

            if(!Validation_DateHour.equals("NA")) {
                test.setTest_Validation_DateHour(sdf.parse(Validation_DateHour));
                for(ValueRecords valueRecord : valueRecordsList)
                    valueRecord.setDate(sdf.parse(Validation_DateHour));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            company.saveClient(client);
        }
        catch(IllegalArgumentException e){
            System.out.println("Client already exists!");
        }
        System.out.println(client);

        company.save(test);
        System.out.println(test);

        for (ValueRecords valueRecords : valueRecordsList)
            company.saveValueRecords(valueRecords);

        //Utils.showList(Company.getValueRecords(testCode), "Registered Records");
        //System.out.println(Arrays.toString(Company.getValueRecords(testCode).toArray()));
        return true;

    }


}
