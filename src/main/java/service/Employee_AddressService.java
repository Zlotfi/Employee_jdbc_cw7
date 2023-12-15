package service;

import entity.EmployeeAddress;
import entity.Employees;
import repository.Employee_AddressRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Employee_AddressService {
    Scanner scanner = new Scanner(System.in);
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

    public void load(int employee_Number) throws SQLException {
        System.out.println("employee Number: ");
        int employeeNumber = scanner.nextInt();
        employeeAddressRepository.getEmployeeAddress(employee_Number);
    }

    public void changeEmployee(int address_Id) throws SQLException {
        System.out.println("please enter your new office code: ");
        int officeCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("please enter your new city: ");
        String city = scanner.nextLine();


        System.out.println("please enter your new street: ");
        String street = scanner.nextLine();

        System.out.println("please enter your new postal code: ");
        String postalCode = scanner.nextLine();

        int result = employeeAddressRepository.updateEmployee(address_Id,officeCode,city,street,postalCode);
        if (result != 0)
            System.out.println("successfully update to database");
        else
            System.out.println("OOps!:(");
    }
}
