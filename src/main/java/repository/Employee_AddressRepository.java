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


}
