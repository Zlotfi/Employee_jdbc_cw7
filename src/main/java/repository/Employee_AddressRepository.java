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

    public static void addEmployee(Connection connection, String firstName, String lastName, int employeeNumber, String city, String postalCode) throws SQLException {
        String insertEmployeeQuery = "INSERT INTO employees (employeeNumber, lastName, firstName) VALUES (?, ?, ?)";
        PreparedStatement insertEmployeeStmt = connection.prepareStatement(insertEmployeeQuery);
        insertEmployeeStmt.setInt(1, employeeNumber);
        insertEmployeeStmt.setString(2, lastName);
        insertEmployeeStmt.setString(3, firstName);
        insertEmployeeStmt.executeUpdate();

        String insertAddressQuery = "INSERT INTO employeeAddress (addressId, city, postalCode) VALUES (?, ?, ?)";
        PreparedStatement insertAddressStmt = connection.prepareStatement(insertAddressQuery);
        insertAddressStmt.setInt(1, employeeNumber);
        insertAddressStmt.setString(2, city);
        insertAddressStmt.setString(3, postalCode);
        insertAddressStmt.executeUpdate();
    }
}
