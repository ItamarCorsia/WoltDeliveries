import java.util.*;
import java.util.List;

// Define a public Java class named "Location"
public class Location implements Comparable<Location> {
    // Define a private instance variable of type "int" called "id"
    private int id;
    // Define a private instance variable of type "LocationType" called "type"
    private LocationType type;
    // Define a private instance variable of type "List<Location>" called "ptr"
    private List<Location> ptr;
    // Define a private instance variable of type "DistanceTo[]" called "adjacencies"
    private DistanceTo[] adjacencies;
    // Define a private instance variable of type "Location" called "parent"
    private Location parent;
    // Define a private instance variable of type "int" called "distance"
    private int distance;


    // Define a constructor for the Location class that takes in values for all instance variables
    public Location(int id, LocationType type, List<Location> ptr) {

        // Set the private instance variable "id" to the input "id" value
        this.id = id;
        // Set the private instance variable "type" to the input "type" value
        this.type = type;
        // Set the private instance variable "ptr" to the input "ptr" value
        this.ptr = ptr;
        // Set the private instance variable "adjacencies" to the input "adjacencies" value
        this.adjacencies = adjacencies;
        // Set the private instance variable "parent" to the input "parent" value
        this.parent = null;
        // Set the private instance variable "distance" to the input "distance" value
        this.distance = Integer.MAX_VALUE;
    }

    // Define a method called "getId" that returns the private instance variable "id"
    public int getId() {
        return id;
    }

    // Define a method called "setId" that takes in an "id" value and sets the private instance variable "id" to it
    public void setId(int id) {
        this.id = id;
    }

    // Define a method called "getType" that returns the private instance variable "type"
    public LocationType getType() {
        return type;
    }

    // Define a method called "setType" that takes in a "type" value and sets the private instance variable "type" to it
    public void setType(LocationType type) {
        this.type = type;
    }

    // Define a method called "getPtr" that returns the private instance variable "ptr"
    public List<Location> getPtr() {
        return ptr;
    }

    // Define a method called "setPtr" that takes in a "ptr" value and sets the private instance variable "ptr" to it
    public void setPtr(List<Location> ptr) {
        this.ptr = ptr;
    }

    // Define a method called "getAdjacencies" that returns the private instance variable "adjacencies"
    public DistanceTo[] getAdjacencies() {
        return adjacencies;
    }

    // Define a method called "setAdjacencies" that takes in an "adjacencies" value and sets the private instance variable "adjacencies" to it
    public void setAdjacencies(DistanceTo[] adjacencies) {
        this.adjacencies = adjacencies;
    }

    // Define a method called "getParent" that returns the private instance variable "parent"
    public Location getParent() {
        return parent;
    }

    // Define a method called "setParent" that takes in a "parent" value and sets the private instance variable "parent"
    public void setParent(Location parent) {
        this.parent = parent;
    }

    // This code defines a getter method called "getDistance" which returns the value of the private instance variable "distance".
    public int getDistance() {
        return distance;
    }

    // This code defines a setter method called "setDistance" which takes in an integer value "distance" and assigns it to the private
    // instance variable "distance".
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Location o) {
        return (distance - o.distance);
    }

    @Override
    public String toString() {
        return "" + type +
                " " + id +
                "  type=" + type +
                ", ptr=" + ptr +
                ", adjacencies=" + Arrays.toString(adjacencies) +
                ", parent=" + parent +
                ", distance=" + distance +
                '}';
    }
}

