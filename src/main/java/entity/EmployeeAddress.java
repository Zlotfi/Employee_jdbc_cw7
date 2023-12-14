package entity;

public class EmployeeAddress {
    private int address_Id;
    private String city;
    private String street;
    private String postalCode;

    public EmployeeAddress(int address_Id, String city, String street, String postalCode) {
        this.address_Id = address_Id;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public int getAddress_Id() {
        return address_Id;
    }

    public void setAddress_Id(int address_Id) {
        this.address_Id = address_Id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "address_Id=" + address_Id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
