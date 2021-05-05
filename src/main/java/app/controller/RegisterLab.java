package app.controller;

public class RegisterLab {

    private String labId;
    private String name;
    private String address;
    private String phoneNr;
    private int TINnr;
    private String testName;
    private String sample;

    public RegisterLab(String labId, String name, String address, String phoneNr, int TINnr, String testName, String sample ) {
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

            if (labId.length() < 0 || labId.length() > 20){
                throw new IllegalArgumentException("The labId should be a 5 number code");
            }
    }
}
