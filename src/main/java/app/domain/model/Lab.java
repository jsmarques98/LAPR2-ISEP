package app.domain.model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Lab {

    /**
     * The id of the lab to be registered
     */
    private String labId;

    /**
     * The name of the lab to be registered
     */
    private String name;

    /**
     * The address of the lab to be registered
     */
    private String address;

    /**
     * The phone number of the lab to be registered
     */
    private String phoneNr;

    /**
     * The TIN number of the lab to be registered
     */
    private String TINnr;


    /**
     * Builds an instance of the lab that is being created
     * @param labId The id of the lab to be registered
     * @param name The name of the lab to be registered
     * @param address The address of the lab to be registered
     * @param phoneNr The phone number of the lab to be registered
     * @param TINnr The TIN number of the lab to be registered
     */
    public Lab(String labId, String name, String address, String phoneNr, String TINnr) {
        checkLabID(labId);
        checkName(name);
        checkAdress(address);
        checkPhoneNr(phoneNr);
        checkTinNr(TINnr);

        this.labId = labId;
        this.name = name;
        this.address = address;
        this.phoneNr = phoneNr;
        this.TINnr = TINnr;

    }

    /**
     * Checks if the id of the lab is correctly given with the constraints
     * @param labId The id of the lab to be registered
     */
    private void checkLabID(String labId){
            if (labId == null){
                throw new IllegalArgumentException("The labId can´t be null, you have to enter a number");
            }

            if (labId.length() != 5){
                throw new IllegalArgumentException("The labId must be a 5 alphanumerical characters code");
            }
    }


    /**
     * Checks if the name of the lab is correctly given with the constraints
     * @param name The name of the lab to be registered
     */
    private void checkName(String name){
        if (name == null){
            throw new IllegalArgumentException("The name can´t be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The lab name can't be empty");
        }
        if (name.length() > 20){
            throw new IllegalArgumentException("The name of the lab can contain a maximum of 20 characters");
        }
    }

    /**
     * Checks if the address of the lab is correctly given with the constraints
     * @param address The address of the lab to be registered
     */
    private void checkAdress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("The address can´t be null, you have to enter an address");
        }

        if (address.length() > 30) {
            throw new IllegalArgumentException("The address of the lab can contain a maximum of 30 characters");
        }
    }

    /**
     * Checks if the phone number of the lab is correctly given with the constraints
     * @param phoneNr The phone number of the lab to be registered
     */
    private void checkPhoneNr (String phoneNr){

        String phoneNrRegex = "^[0-9]{11}$";
        Pattern pat = Pattern.compile(phoneNrRegex);

        if (!pat.matcher(phoneNr).matches())
            throw new IllegalArgumentException("Invalid Phone number");

    }

    /**
     * Checks if the TIN number of the lab is correctly given with the constraints
     * @param TINnr The TIN number of the lab to be registered
     */
    private void checkTinNr(String TINnr) {

        String TINnrRegex = "^[0-9]{10}$";

        Pattern pat = Pattern.compile(TINnrRegex);

        if (!pat.matcher(TINnrRegex).matches()) {
            throw new IllegalArgumentException("Invalid TIN.");
        }
    }

    /**
     * Get the id of the lab
     * @return the id of the lab
     */
    public String getLabId() {
        return labId;
    }

    /**
     * Get the name of the lab
     * @return the name of the lab
     */
    public String getName() {
        return name;
    }

    /**
     * Get the address of the lab
     * @return the address of the lab
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the phone number of the lab
     * @return the phone number of the lab
     */
    public String getPhoneNr() {
        return phoneNr;
    }

    /**
     * Get the TIN number of the lab
     * @return the TIN number of the lab
     */
    public String getTINnr() {
        return TINnr;
    }

    /**
     * Sets the id of the lab
     * @param labId is the id of the lab
     */
    public void setLabId(String labId) {
        checkLabID(labId);
        this.labId = labId;
    }

    /**
     * Sets the name of the lab
     * @param name is the name of the lab
     */
    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    /**
     * Sets the address of the lab
     * @param address is the address of the lab
     */
    public void setAddress(String address) {
        checkAdress(address);
        this.address = address;
    }

    /**
     * Sets the phone number of the Lab
     * @param phoneNr is the TIN number of the lab
     */
    public void setPhoneNr(String phoneNr) {
        checkPhoneNr(phoneNr);
        this.phoneNr = phoneNr;
    }

    /**
     * Sets the TIN number of the lab
     * @param TINnr is the phone number of the lab
     */
    public void setTINnr(String TINnr) {
        checkTinNr(TINnr);
        this.TINnr = TINnr;
    }

    public static ArrayList<String> labs = new ArrayList<>(5);

    @Override
    public String toString() {
        return String.format("LabID: %s%nName: %s%nAddress: %s%nPhoneNumberr: %s%nTIN: %s",
                this.labId, this.name, this.address, this.phoneNr, this.TINnr);
    }
}


