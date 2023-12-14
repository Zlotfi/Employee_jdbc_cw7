package repository;

import connection.JdbcConnection;
import entity.EmployeeAddress;
import entity.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee_AddressRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public Employee_AddressRepository() throws SQLException {
    }

    public int saveEmployee(Employees employees) throws SQLException {
        String add = "INSERT INTO employee (employee_Number, firstName, lastName, officeCode) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setInt(1,employees.getEmployee_Number());
        preparedStatement.setString(2, employees.getFirstName());
        preparedStatement.setString(3, employees.getLastName());
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

    public void getEmployeeAddress(int employee_Number) throws SQLException {
        String selectQuery = "SELECT * " +
                "FROM employeeAddress " +
                "INNER JOIN employee ON (employeeAddress.address_Id = employee.address_Id) " +
                "WHERE employee_Number = ? " +
                "ORDER BY employeeAddress.address_Id";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setInt(1, employee_Number);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String city = resultSet.getString("city");
            String street = resultSet.getString("street");
            String postalCode = resultSet.getString("postalcode");

            System.out.println("Address for employee " + employee_Number + ":");
            System.out.println("City: " + city);
            System.out.println("Street: " + street);
            System.out.println("Postal code: " + postalCode);
        } else {
            System.out.println("Address not found for employee " + employee_Number);
        }
    }
}

