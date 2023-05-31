import java.util.List;

// This is a class that represents a Restaurant, which extends from the Location class
public class Restaurant extends Location {
    // These are the private fields of the Restaurant class
    private String name; // The name of the restaurant
    private int phoneNum; // The phone number of the restaurant
    private Address addres; // The address of the restaurant

    // This is the constructor for the Restaurant class
    public Restaurant(int id, LocationType type, List<Location> ptr, String name, int phoneNum, Address addres) {
        // This calls the constructor of the Location class with the specified parameters
        super(id, type, ptr);
        // These set the private fields of the Restaurant class with the specified parameters
        this.name = name;
        this.phoneNum = phoneNum;
        this.addres = addres;
    }

    // This is a getter method that returns the name of the restaurant
    public String getName() {
        return name;
    }

    // This is a setter method that sets the name of the restaurant to the specified parameter
    public void setName(String name) {
        this.name = name;
    }

    // This is a getter method that returns the phone number of the restaurant
    public int getPhoneNum() {
        return phoneNum;
    }

    // This is a setter method that sets the phone number of the restaurant to the specified parameter
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    // This is a getter method that returns the address of the restaurant
    public Address getAddres() {
        return addres;
    }

    // This is a setter method that sets the address of the restaurant to the specified parameter
    public void setAddres(Address addres) {
        this.addres = addres;
    }
}



