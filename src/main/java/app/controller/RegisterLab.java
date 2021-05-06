package app.controller;

public class RegisterLab {

    private String labId;
    private String name;
    private String address;
    private int phoneNr;
    private int TINnr;
    private String testName;
    private String sample;

    public RegisterLab(String labId, String name, String address, int phoneNr, int TINnr, String testName, String sample ) {
        this.labId = labId;
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.TINnr = TINnr;
        this.testName = testName;
        this.sample = sample;
    }

    private void checkLabID(String labId){
            if (labId.length() == 0){
                throw new IllegalArgumentException("The labId can´t be blank, you have to enter a number");
            }

            if (labId.length() < 0 || labId.length() > 5){
                throw new IllegalArgumentException("The labId should be a 5 number code");
            }
    }


    private void checkName(String name){
        if (name.length() == 0){
            throw new IllegalArgumentException("The name can´t be blank, you have to enter a name");
        }

        if (name.length() < 0 || name.length() > 20){
            throw new IllegalArgumentException("The name of the lab can contain a maximum of 20 characters");
        }
    }


    private void checkAdress(String address) {
        if (address.length() == 0) {
            throw new IllegalArgumentException("The address can´t be blank, you have to enter an address");
        }

        if (address.length() < 0 || address.length() > 30) {
            throw new IllegalArgumentException("The address of the lab can contain a maximum of 30 characters");
        }
    }


    private void checkPhoneNr (int phoneNr){
        String phoneNumber = Integer.toString(phoneNr);

        if (phoneNumber.length() == 0) {
            throw new IllegalArgumentException("The phone number can´t be blank, you have to enter a phone number");
        }

        if (phoneNumber.length() < 0 || phoneNumber.length() < 11) {
            throw new IllegalArgumentException("The phone number of the lab has to be a 11 digit number");
        }

        if (phoneNumber.length() > 11){
            throw new IllegalArgumentException("The phone number can´t have more than 10 digits");
        }

    }

    private void checkTinNr (int TINnr){
        String Tin = Integer.toString(TINnr);

        if (Tin.length() == 0) {
            throw new IllegalArgumentException("The TIN number can´t be blank, you have to enter a TIN number");
        }

        if (Tin.length() < 0 || Tin.length() < 10) {
            throw new IllegalArgumentException("The TIN number of the lab has to be a 10 digit number");
        }

        if (Tin.length() > 10){
            throw new IllegalArgumentException("The TIN number can´t have more than 10 digits");
        }

    }


}


