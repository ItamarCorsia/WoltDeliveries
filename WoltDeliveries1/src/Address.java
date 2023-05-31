public class Address {
    // Class fields to store the address details
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private int houseNumber;
    private int streetNum;


    // Constructor to create a new Address object with all details
    public Address(String street, String city, String state, String country, String postalCode, int houseNumber, int streetNum) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.streetNum = streetNum;
    }

    // Getter method for the street field
    public String getStreet() {
        return street;
    }

    // Getter method for the house number
    public int getHouseNumber() {
        return houseNumber;
    }

    // Setter method for the house number
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    // Getter method for the street number
    public int getStreetNum() {
        return streetNum;
    }

    // setter method for the street number
    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    // Setter method for the street field
    public void setStreet(String street) {
        this.street = street;
    }

    // Getter method for the city field
    public String getCity() {
        return city;
    }

    // Setter method for the city field
    public void setCity(String city) {
        this.city = city;
    }

    // Getter method for the state field
    public String getState() {
        return state;
    }

    // Setter method for the state field
    public void setState(String state) {
        this.state = state;
    }

    // Getter method for the country field
    public String getCountry() {
        return country;
    }

    // Setter method for the country field
    public void setCountry(String country) {
        this.country = country;
    }

    // Getter method for the postalCode field
    public String getPostalCode() {
        return postalCode;
    }

    // Setter method for the postalCode field
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
