import java.util.List;

// This is a class that represents a Customer, which extends from the Location class
public class Customer extends Location {
    // These are the private fields of the Customer class
    private String firstName; // The first name of the customer
    private String lastName; // The last name of the customer
    private int phoneNum; // The phone number of the customer
    private Address addres; // The address of the customer

    public Customer(int id, LocationType type, List<Location> ptr, String firstName,String lastName, int phoneNum){
        super(id, type, ptr);
        this.firstName = firstName;// The first name of the customer
        this.lastName = lastName; // The last name of the customer
        this.phoneNum = phoneNum; // The phone number of the customer
    }

    // This is a getter method that returns the first name of the customer
    public String getFirstName() {
        return firstName;
    }

    // This is a setter method that sets the first name of the customer to the specified parameter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // This is a getter method that returns the last name of the customer
    public String getLastName() {
        return lastName;
    }

    // This is a setter method that sets the last name of the customer to the specified parameter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // This is a getter method that returns the phone number of the customer
    public int getPhoneNum() {
        return phoneNum;
    }

    // This is a setter method that sets the phone number of the customer to the specified parameter
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    // This is a getter method that returns the address of the customer
    public Address getAddres() {
        return addres;
    }

    // This is a setter method that sets the address of the customer to the specified parameter
    public void setAddres(Address addres) {
        this.addres = addres;
    }
}