package app.controller;
import app.domain.model.Company;
import app.domain.model.Employee;

public class RegisterEmployeeController{

    private Company company;
    private Employee employee;

    public RegisterEmployeeController() {
        this(App.getInstance().getCompany());
    }

    public RegisterEmployeeController(Company company) {
        this.company = company;
        this.employee = null;
    }

    public boolean createEmloyee(String roleId, String name, String address, String phoneNumber, String email, String socCode) {
        this.employee = this.company.createEmloyee(roleId, name, address, phoneNumber, email, socCode);
        return this.company.validateEmployee(employee);
    }

    public boolean createSpecialistDoctor(String roleId, String name, String address, String phoneNumber, String email, String socCode, String indxNumber) {
        this.employee = this.company.createSpecialistDoctor(roleId, name, address, phoneNumber, email, socCode, indxNumber);
        return this.company.validateEmployee(employee);
    }

    public boolean saveEmployee() {
        return this.company.saveEmployee(employee);
    }

}
