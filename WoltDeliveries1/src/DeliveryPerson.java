import java.util.ArrayList;
import java.util.List;

// Define a class called DeliveryPerson
public class DeliveryPerson extends Location{

    // Declare private member variables
    private String firstName; // stores the first name of the delivery person
    private String secondName; // stores the last name of the delivery person
    private int phone; // stores the phone number of the delivery person
    private List <Location> locations; // store the shortest list between list of customers for resturant

    // Define a constructor for the DeliveryPerson class
    public DeliveryPerson(int id, LocationType type, List<Location> ptr, String firstName, String secondName, int phone, ArrayList<Location> locations) {
        super(id,type,ptr);
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.locations = locations;
    }
    // Define a getter method for the firstName variable
    public String getFirstName() {
        return firstName;
    }
    // Define a setter method for the firstName variable
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // Define a getter method for the secondName variable
    public String getSecondName() {
        return secondName;
    }
    // Define a setter method for the secondName variable
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    // Define a getter method for the phone variable
    public int getPhone() {
        return phone;
    }
    // Define a setter method for the phone variable
    public void setPhone(int phone) {
        this.phone = phone;
    }
    // Define a getter method for the shortest list between list of customers for resturant
    public List<Location> getShortestPath() {
        return locations;
    }
    // Define a setter method for the shortest list between list of customers for resturant
    public void setShortestPath(List<Location> locations) {
        this.locations = locations;
    }
}



