import entity.EmployeeAddress;
import entity.Employees;
import repository.Employee_AddressRepository;
import service.Employee_AddressService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Employee_AddressRepository employeeAddressRepository = new Employee_AddressRepository();
//        Employees employees = new Employees(126,"zahra","lotfi",206,1);
//        EmployeeAddress employeeAddress = new EmployeeAddress(1,"esfahan","naghsh","225543");
        Employees employees = new Employees(127,"naser","naseri",206,1);
        Employees employees1 = new Employees(128,"zahra","lotfi",206,2);
        Employees employees2 = new Employees(129,"asghar","asghari",206,3);
        Employees employees3 = new Employees(130,"sahar","sahari",206,4);
        Employees employees4 = new Employees(131,"sama","samaei",206,5);
        Employees employees5 = new Employees(132,"saba","saboori",206,6);
        EmployeeAddress employeeAddress = new EmployeeAddress(1,"karaj","sahel","222222");
        EmployeeAddress employeeAddress1 = new EmployeeAddress(2,"tehran","bahar","554414");
        EmployeeAddress employeeAddress2 = new EmployeeAddress(3,"rasht","golha","121413");
        EmployeeAddress employeeAddress3 = new EmployeeAddress(4,"mazandaran","eshragh","144532");
        EmployeeAddress employeeAddress4 = new EmployeeAddress(5,"ghods","babooneh","552544");
        EmployeeAddress employeeAddress5 = new EmployeeAddress(6,"tehran","azadi","551404");
        Employee_AddressService employeeAddressService = new Employee_AddressService();
//        employeeAddressService.registerEmployee(employees5);
//        employeeAddressService.registerAddress(employeeAddress5);
//        employeeAddressRepository.getEmployeeAddress(125);
//        employeeAddressService.load(125);
//        employeeAddressService.changeEmployee(1);

//        employeeAddressRepository.deleteEmployee(2);
        employeeAddressService.delete(6);
    }
}
