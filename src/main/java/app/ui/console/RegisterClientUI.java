package app.ui.console;
//package auth.domain.model;

//import app.adapter.MailAdapter;
import app.controller.RegisterClientController;
import app.domain.model.Category;
import app.domain.model.Client;
import app.domain.model.Company;
import app.dto.ClientDTO;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;

import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterClientUI implements Runnable{

    public RegisterClientController controller;

    public RegisterClientUI(){
        controller = new RegisterClientController();
    }

    @Override
    public void run() {

        String name = Askname();
        String number = Asknumber();
        String CCard = AskCCard();
        String addres = AskAddres();
        String gender = AskGender();
        String NHS = AskNHS();
        String Date = AskDate();
        String PhoneNumber = AskPhoneNumber();
        String Email = AskEmail();
        String Password = "1234566789";

        if(Utils.confirm()){
            if (controller.createClient(name, number, addres, gender, CCard, NHS, Date, PhoneNumber, Email)){
                    System.out.println("Client successfully created");
                controller.saveClient();
            } else {
                System.out.println("Client not created");
            }
        }else{
            System.out.println("Operation canceld");
        }

        for (int i = 0; i < Company.clientsList.size(); i++) {
            System.out.println(Company.clientsList.get(i));
        }
    }



//    private String RandomPassword(int lenght){
//        String regex = "ABCDEFGHIJKLMNOPQRSTUVXYWZÇ"+"abcedfghijklmnopqrstuvxywzç"+"0123456789";
//
//        StringBuilder password = new StringBuilder(lenght) ;
//
//        for(int i = 0; i<lenght;i++){
//            int index = (int)(regex.length() * Math.random());
//            password.append(regex.charAt(index));
//
//        }
//
//        System.out.println("Password randomly created \n");
//
//        return password.toString();
//    }

    public String Askname () {
        String name = Utils.readLineFromConsole("Enter name: ");
        if (name.length() > 36 || name.length() == 0){
            System.out.println("Name must have less than 36 chars and can't null.");
            return Askname();
        }
        return name;

    }

    public String Asknumber (){

            String number = Utils.readLineFromConsole("Enter a TIN number: ");

        String regex = "\\d{10}";


        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(number);
        boolean matchFound = matcher.find();


            if(matchFound){
                return number;
            }
        System.out.println("Enter a 10 digit number");
        return Asknumber();


    }

    public String AskCCard(){

        String CCardNum = Utils.readLineFromConsole("Enter a Citizen Card number: ");

        String regex = "\\d{16}";

        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(CCardNum);
        boolean matchFound = matcher.find();

        if(matchFound){

            return CCardNum;
        }

        System.out.println("Enter a 16 Citizen Card number");
        return AskCCard();

    }

    public String AskAddres(){
        String addres = Utils.readLineFromConsole("Enter address: ");
        if (addres.length() > 31 || addres.length() == 0){
            System.out.println("Address must have less than 31 chars and can't null.");
            return AskAddres();
        }
        return addres;
    }

    public static String AskGender(){
        String gender = Utils.readLineFromConsole("Enter your gender:\nM(Masculin)\n" +
                "F(Feminine)\n" +   "O(Other)");
        if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("O")){
            return gender;
        }
    return AskGender();
    }


    public String AskNHS(){

        String nhscode = Utils.readLineFromConsole("Enter nhsCode: ");
        if (nhscode.length() > 10 || nhscode.length() == 0){
            System.out.println("nhsCode must have less than 12 chars and can't null.");
            return AskNHS();
        }
        return nhscode;


    }

    public String AskDate(){


        String Date = Utils.readLineFromConsole("Enter a Date DD/MM/YYYY: ");

        String regex = "^\\d{2}/\\d{2}/\\d{4}$";

        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(Date);
        boolean matchFound = matcher.find();

        if(matchFound){

            List<String> data = Arrays.asList(Date.split("/"));
            int dia = Integer.parseInt(data.get(0));
            int mes = Integer.parseInt(data.get(1));
            int ano = Integer.parseInt(data.get(2));
            if(dia <= 31 && mes <= 12 && ano > 1871 && ano <= 2021){

                return Date;
            }
        }

        System.out.println("Enter a valid date DD/MM/YYYY");
        return AskDate();



    }

    public String AskPhoneNumber(){
        String phoneNumber = Utils.readLineFromConsole("Enter phone number: ");
        if (!(phoneNumber.length() == 11)){
            System.out.println("Phone Number must have 11 chars.");
            return AskPhoneNumber();
        }
        return phoneNumber;
    }

    public String AskEmail(){
        String mail = Utils.readLineFromConsole("Enter Employee's email: ");
        if(!Email.checkFormat(mail)){
            System.out.println("Invalid Email.");
            return AskEmail();
        }
        return mail;

    }

}
