package app.controller;
import app.domain.model.Company;
import app.domain.model.Lab;


public class RegisterLabController {
/**
 * The company of RegisterLabController
 */
    private Company company;

    /**
     * The lab of RegisterLabController
     */
    private Lab lab;


    /**
     *
     */

    public RegisterLabController() {
        this(App.getInstance().getCompany());
    }

    /**
     *Builds an instance of RegisterLabController receiving the company, the lab and the test.
     *
     * @param company the name of the company.
     */
    public RegisterLabController(Company company) {
        this.company = company;
        this.lab = null;
    }

    /**
     * Builds an instance of a lab receiving the labID, name, address, phoneNr and TINnr
     * @param labId the id of the lab to register.
     * @param name the name of the lab to register.
     * @param address the address of the lab to register.
     * @param phoneNr the phone number of the lab to register.
     * @param tin the TIN number of the lab to register.
     * @return
     */
    public boolean registerLab(String labId, String name, String address, String phoneNr, String tin){
        this.lab = this.company.registerLab(labId, name, address, phoneNr, tin);
        return this.company.validateLab(lab);
    }


    /**
     * Saves the instance of the lab created in the registerLab
     * @return
     */
    public boolean saveLab(){
        return this.company.saveLab(lab);
    }

}
