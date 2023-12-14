package entity;

public class EmployeeAddress {
    private int addressId;
    private String city;
    private String street;
    private String postalCode;

    public EmployeeAddress(int addressId, String city, String street, String postalCode) {
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
}
