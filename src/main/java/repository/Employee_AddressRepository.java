package repository;

import connection.JdbcConnection;
import entity.EmployeeAddress;
import entity.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee_AddressRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public Employee_AddressRepository() throws SQLException {
    }

    public int saveEmployee(Employees employees) throws SQLException {
        String add1 = "INSERT INTO employee (employee_Number, firstName, lastName, officeCode) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add1);
        preparedStatement.setInt(1,employees.getEmployee_Number());
        preparedStatement.setString(2,employees.getFirstName());
        preparedStatement.setString(3,employees.getLastName());
        preparedStatement.setInt(4,employees.getOfficeCode());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int saveAddress(EmployeeAddress employeeAddress) throws SQLException {
        String add = "INSERT INTO employeeAddress (address_Id, city, street, postalCode) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setInt(1,employeeAddress.getAddress_Id());
        preparedStatement.setString(2,employeeAddress.getCity());
        preparedStatement.setString(3,employeeAddress.getStreet());
        preparedStatement.setString(4,employeeAddress.getPostalCode());
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
