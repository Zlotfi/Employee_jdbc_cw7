package entity;

public class Employees {
    private String employee_Number;
    private String firstName;
    private String lastName;
    private int officeCode;
    private int address_Id;

    public Employees(String employee_Number, String firstName, String lastName, int officeCode, int address_Id) {
        this.employee_Number = employee_Number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeCode = officeCode;
        this.address_Id = address_Id;
    }

    public String getEmployee_Number() {
        return employee_Number;
    }

    public void setEmployee_Number(String employee_Number) {
        this.employee_Number = employee_Number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(int officeCode) {
        this.officeCode = officeCode;
    }

    public int getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(int address_Id) {
        this.address_Id = address_Id;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employee_Number=" + employee_Number +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", officeCode=" + officeCode +
                ", address_Id=" + address_Id +
                '}';
    }
}
