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

//    public int updateEmployee(int officeCode, String city, String street, String postalCode, int address_Id) throws SQLException {
//        String query = "UPDATE employee" +
//                "LEFT JOIN employeeAddress ON (employeeAddress.address_Id = employee.address_Id)" +
//                " SET officeCode = ?, city = ?, street = ?, postalCode = ? WHERE address_Id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setInt(1, officeCode);
//        preparedStatement.setString(2,city);
//        preparedStatement.setString(3, street);
//        preparedStatement.setString(4, postalCode);
//        preparedStatement.setInt(5,address_Id);
//        int result = preparedStatement.executeUpdate();
//        return result;
//    }
public int updateEmployee(int address_Id, int officeCode, String city, String street, String postalCode) {
    try {
        // بروزرسانی officeCode در جدول employees
        String updateOfficeCodeQuery = "UPDATE employee SET officeCode = ? WHERE address_Id = ?";
        PreparedStatement officeCodeStatement = connection.prepareStatement(updateOfficeCodeQuery);
        officeCodeStatement.setInt(1, officeCode);
        officeCodeStatement.setInt(2, address_Id);
        int officeCodeResult = officeCodeStatement.executeUpdate();

        // بروزرسانی آدرس در جدول employeeAddress
        String updateAddressQuery = "UPDATE employeeAddress SET city = ?, street = ?, postalCode = ? WHERE address_Id = ?";
        PreparedStatement addressStatement = connection.prepareStatement(updateAddressQuery);
        addressStatement.setString(1, city);
        addressStatement.setString(2, street);
        addressStatement.setString(3, postalCode);
        addressStatement.setInt(4, address_Id);
        int addressResult = addressStatement.executeUpdate();

        if (officeCodeResult > 0 && addressResult > 0) {
            System.out.println("اطلاعات کارمند با موفقیت به‌روزرسانی شد.");
        } else {
            System.out.println("کارمند با شماره پرسنلی " + address_Id + " یافت نشد.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;
}

    public void deleteEmployee(int address_Id) {
        try {
            // حذف آدرس کارمند
            String deleteAddressQuery = "DELETE FROM employeeAddress WHERE address_Id = ?";
            PreparedStatement addressStatement = connection.prepareStatement(deleteAddressQuery);
            addressStatement.setInt(1, address_Id);

            // حذف رکورد کارمند
            String deleteEmployeeQuery = "DELETE FROM employee WHERE address_Id = ?";
            PreparedStatement employeeStatement = connection.prepareStatement(deleteEmployeeQuery);
            employeeStatement.setInt(1, address_Id);

            if (addressStatement.executeUpdate() > 0 || employeeStatement.executeUpdate() > 0) {
                System.out.println("اطلاعات کارمند با موفقیت حذف شد.");
            } else {
                System.out.println("کارمند با شناسه آدرس " + address_Id + " یافت نشد.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

