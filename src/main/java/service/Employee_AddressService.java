package service;

import entity.EmployeeAddress;
import entity.Employees;
import repository.Employee_AddressRepository;

import java.sql.SQLException;

public class Employee_AddressService {

    private final Employee_AddressRepository employeeAddressRepository = new Employee_AddressRepository();

    public Employee_AddressService() throws SQLException {
    }

    public void registerEmployee(Employees employees) throws SQLException {
        int result = employeeAddressRepository.saveEmployee(employees);
        if (result != 0)
            System.out.println(employees.getFirstName() + " successfully added to database");
        else
            System.out.println("ERROR!!");
    }

    public void registerAddress(EmployeeAddress employeeAddress) throws SQLException {
        int result = employeeAddressRepository.saveAddress(employeeAddress);
        if (result != 0)
            System.out.println(employeeAddress.getAddress_Id() + " successfully added to database");
        else
            System.out.println("ERROR!!");
    }
}
