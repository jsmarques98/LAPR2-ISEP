package app.controller;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.Lab;

import java.util.ArrayList;

public class RegisterEmployeeController{

    private Company company;
    private Employee employee;

    public RegisterEmployeeController() {
        company = App.getInstance().getCompany();
    }

    public boolean createEmloyee(String roleId, String name, String address, String phoneNumber, String email, String socCode, Lab lab) {
        this.employee = this.company.createEmloyee(roleId, name, address, phoneNumber, email, socCode, lab);
        return this.company.validateEmployee(employee);
    }

    public boolean createSpecialistDoctor(String roleId, String name, String address, String phoneNumber, String email, String socCode, Lab lab, String indxNumber) {
        this.employee = this.company.createSpecialistDoctor(roleId, name, address, phoneNumber, email, socCode, lab, indxNumber);
        return this.company.validateEmployee(employee);
    }

    public boolean saveEmployee() {
        return this.company.saveEmployee(employee);
    }

}
