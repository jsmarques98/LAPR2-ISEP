package app.ui.console;
//package auth.domain.model;

//import app.adapter.MailAdapter;
import app.controller.RegisterClientController;
import app.domain.model.Category;
import app.domain.model.Client;
import app.dto.ClientDTO;
import app.ui.console.utils.Utils;

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
        //run the controller here

        System.out.println("\n");

        String name = Askname();

        String number = Asknumber();

        String CCard = AskCCard();

        String NHS = AskNHS();

        String Date = AskDate();

        String PhoneNumber = AskPhoneNumber();

        String Email = AskEmail();

        String Password = RandomPassword(10);




//        MailAdapter mailAdapter = new MailAdapter("1200614", "tua passe aqui");

        String args[] = {name, number, CCard, NHS, Date, PhoneNumber, Email, Password};

        ClientDTO ClientDTO = controller.createClientDTO(args);

        show(ClientDTO);





    }



    public void show(ClientDTO C){

        System.out.println(C.toString());


        String confirm = Utils.readLineFromConsole("Confirm client?(Yes or No)");

        if(confirm.equalsIgnoreCase("Yes")){

            controller.registerClient(C);
            System.out.println("Account successfully created \n");
        }
        if(confirm.equalsIgnoreCase("No")){

            this.run();
        }

    }

    private String RandomPassword(int lenght){
        String regex = "ABCDEFGHIJKLMNOPQRSTUVXYWZÇ"+"abcedfghijklmnopqrstuvxywzç"+"0123456789";

        StringBuilder password = new StringBuilder(lenght) ;

        for(int i = 0; i<lenght;i++){
            int index = (int)(regex.length() * Math.random());
            password.append(regex.charAt(index));

        }

        System.out.println("Password randomly created \n");

        return password.toString();
    }

    public String Askname () {

        String name = Utils.readLineFromConsole("Enter a name: ");

        if (name.length() <= 35){
            return name;
        }

        System.out.println("Name too long (<35)");
        return Askname();

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

    public String AskNHS(){

        String NHS = Utils.readLineFromConsole("Enter a NHS number: ");

        String regex = "\\d{10}";

        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(NHS);
        boolean matchFound = matcher.find();

        if(matchFound){

            return NHS;
        }

        System.out.println("Enter a 10 NHS number");
        return AskNHS();


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

        String PhoneNumber = Utils.readLineFromConsole("Enter a phone number: ");

        String regex = "\\d{11}";


        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(PhoneNumber);
        boolean matchFound = matcher.find();


        if(matchFound){
            return PhoneNumber;
        }
        System.out.println("Enter a 11 digit phone number");
        return AskPhoneNumber();
    }

    public String AskEmail(){
        String email = Utils.readLineFromConsole("Enter an Email: ");



        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();

        if (matchFound){

            return email;

       }


        System.out.println("Enter an valid Email \n");
        return AskEmail();

    }

}
