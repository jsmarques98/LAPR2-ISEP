package app.controller;
import app.domain.model.Company;
import app.domain.model.Employee;

public class RegisterEmployeeController implements Runnable{

    private Company company;
    private Employee employee;

    public RegisterEmployeeController() {
        this(App.getInstance().getCompany());
    }

    public RegisterEmployeeController(Company company) {
        this.company = company;
        this.employee = null;
    }

    public boolean createEmloyee(String role, String name, String address, String phoneNumber, String email, String socCode) {
        this.employee = this.company.createEmloyee(role, name, address, phoneNumber, email, socCode);
        return this.company.validateEmployee(employee);
    }

    public boolean saveEmployee() {
        return this.company.saveEmployee(employee);
    }

    @Override
    public void run() {
        Employee.roles.add("recepcionist");
        Employee.roles.add("clincal chemestry technologist");
        Employee.roles.add("laboratory coordinator");
        Employee.roles.add("medical lab technician");
        Employee.roles.add("specialist doctor");
        Employee.roles.add("administrator");

        Employee e1 = new Employee("JO1","administrator", "Joao Oliveira", "address", "99999999999", "email", "1254","qwertyuiop");
        Employee e2 = new Employee("clincal chemestry technologist", "Manel Jorge", "address", "99999999999", "email", "1254");
        Employee e3 = new Employee("specialist doctor", "Palhaço Luis", "address", "99999999999", "email", "1254");

        Company.employeeList.add(e1);
        Company.employeeList.add(e2);
        Company.employeeList.add(e3);

        for(int i=0;i<Company.employeeList.size();i++){
            System.out.println(Company.employeeList.get(i));
        }
    }
}
