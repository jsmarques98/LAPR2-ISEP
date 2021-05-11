package app.domain.model;

public class Lab {
    /**
     * The identification code of the laboratory.
     */
    public static String labID;
    /**
     * The name of the laboratory.
     */
    public static String name;
    /**
     * The address of the laboratory.
     */
    public static String address;
    /**
     * The Tax Identification Number of the company.
     */
    public static String TINnr;
    /**
     * The phoneNumber of the laboratory.
     */
    public static String phoneNr;

    /**
     * Defines the lab
     * @param labId is the id of the lab
     * @param name is the name of the lab
     * @param address is the address of the lab
     * @param phoneNr is the phone number of the lab
     * @param TINnr is the TIN number of the lab
     */
    public Lab(String labId, String name, String address, int phoneNr, int TINnr) {
        if (labId == null){
            throw new IllegalArgumentException("The id of the lab cannot be empty, please fill it");
        }

        if (name == null){
            throw new IllegalArgumentException("The name of the lab cannot be empty, please fill it");
        }

        if (address == null){
            throw new IllegalArgumentException("The address of the lab cannot be empty, please fill it");
        }

        String phoneNumber = Integer.toString(phoneNr);
        if (phoneNumber == null){
            throw new IllegalArgumentException("The phone number of the lab cannot be empty, please fill it");
        }

        String TIN = Integer.toString(TINnr);
        if (TIN == null){
            throw new IllegalArgumentException("The TIN number of the lab cannot be empty, please fill it");
        }

        Lab.labID = labId;
        Lab.name = name;
        Lab.address = address;
        Lab.phoneNr = phoneNumber;
        Lab.TINnr = TIN;

    }

    /**
     * Get the id of the lab
     * @return the id of the lab
     */
    public static String getLabID() {
        return labID;
    }

    /**
     * Get the name of the lab
     * @return the name of the lab
     */
    public static String getName() {
        return name;
    }

    /**
     * Get the address of the lab
     * @return the address of the lab
     */
    public static String getAddress() {
        return address;
    }

    /**
     * Get the TIN number of the lab
     * @return the TIN number of the lab
     */
    public static String getTINnr() {
        return TINnr;
    }

    /**
     * Get the phone number of the lab
     * @return the phone number of the lab
     */
    public static String getPhoneNr() {
        return phoneNr;
    }


    /**
     * Sets the id of the lab
     * @param labID is the id of the lab
     */
    public static void setLabID(String labID) {
        Lab.labID = labID;
    }

    /**
     * Sets the name of the lab
     * @param name is the name of the lab
     */
    public static void setName(String name) {
        Lab.name = name;
    }

    /**
     * Sets the address of the lab
     * @param address is the address of the lab
     */
    public static void setAddress(String address) {
        Lab.address = address;
    }

    /**
     * Sets the TIN number of the Lab
     * @param TINnr is the TIN number of the lab
     */
    public static void setTINnr(String TINnr) {
        Lab.TINnr = TINnr;
    }

    /**
     * Sets the phone number of the lab
     * @param phoneNr is the phone number of the lab
     */
    public static void setPhoneNr(String phoneNr) {
        Lab.phoneNr = phoneNr;
    }
}
