package app.controller;
import app.domain.model.Company;


public class RegisterLabController {
/**
 * The company of RegisterLabController
 */
    private Company company;

    /**
     * The lab of RegisterLabController
     */
    private RegisterLab lab;

    /**
     * The test of RegisterLabController
     */
    private RegisterTest test;

    /**
     *
     */

    public RegisterLabController() {
    }

    /**
     *Builds an instance of RegisterLabController receiving the company, the lab and the test.
     *
     * @param company the name of the company.
     * @param lab  the name of the lab to register.
     * @param test the type of test to tegister.
     */
    public RegisterLabController(Company company, RegisterLab lab, RegisterTest test) {
        this.company = company;
        this.lab = null;
        this.test = null;
    }

    /**
     * Builds an instance of a lab receiving the labID, name, address, phoneNr and TINnr
     * @param labId the id of the lab to register.
     * @param name the name of the lab to register.
     * @param address the address of the lab to register.
     * @param phoneNr the phone number of the lab to register.
     * @param TINnr the TIN number of the lab to register.
     * @return
     */
    public boolean registerLab(String labId, String name, String address, int phoneNr, int TINnr){
        this.lab = this.company.registerLab(labId, name, address, phoneNr, TINnr);
        return this.company.validateLab(lab);
    }

    /**
     * Builds an instance of a test receiving the testName and sample
     * @param testName
     * @param sample
     * @return
     */

    public boolean registerTest(String testName, String sample){
        this.test = this.company.registerTest(testName, sample);
        return this.company.validateTest(test);
    }

    /**
     * Saves the instance of the lab created in the registerLab
     * @return
     */
    public boolean saveLab(){
        return this.company.saveLab(lab);
    }

    /**
     * Saves the instance of the test created in the registerTest
     * @return
     */

    public boolean saveTest(){
        return this.company.saveTest(test);
    }
}
