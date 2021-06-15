package app.Adapter;

import app.controller.App;
import app.controller.RegisterClientController;
import app.controller.RegisterTestToClientController;
import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportTestsCSV {

    public ImportTestsCSV(String path) {
        String str = null;
        File fc = new File(path);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fc));
        } catch (FileNotFoundException e) {
            System.out.println("File not found! File "+path+" not found!");
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
            final int Category = 12;
            final int HB000 = 13;
            final int WBC00 = 14;
            final int PLT00 = 15;
            final int RBC00 = 16;
            //final int Category = 17;
            final int HDL00 = 18;
            //final int Category = 19;
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


        //not a client address, lab address maybe
        String clientAddress = args[Address];

        RegisterClientController registerClientController = new RegisterClientController();
        Client client = registerClientController.createClient(clientName,clientTIN, clientCitizenCard_Number,clientNHS_Number,clientBirthDay,clientPhoneNumber,clientEmail);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        String nhsCode = args[NHS_Code];
        //assuming that address is the description of the lab
        String description = args[Address];

        Test test = new Test(clientTIN, nhsCode, description, null, null, null);
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
            test.setTest_Reg_DateHour(sdf.parse(Reg_DateHour));
            test.setTest_Doctor_DateHour(sdf.parse(Doctor_DateHour));
            test.setTest_Chemical_DateHour(sdf.parse(Chemical_DateHour));
            test.setTest_Validation_DateHour(sdf.parse(Validation_DateHour));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean success;

        Company company = App.getInstance().getCompany();
        success = company.save(client);
        if(!success) throw new UnsupportedOperationException();
        System.out.println(client);

        RegisterTestToClientController registerTestToClientController = new RegisterTestToClientController();
        success = registerTestToClientController.saveTest(test);
        if(!success) throw new UnsupportedOperationException();
        System.out.println(test);

        return success;

    }



}
