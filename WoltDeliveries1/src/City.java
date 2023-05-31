import java.util.List;

public class City {

    // Private instance variables
    private List<Location> locations;
    private int numOfLocations;

    // Constructor
    public City(List<Location> locations, int numOfLocations) {
        this.locations = locations;
        this.numOfLocations = numOfLocations;
    }

    // Getter method for "locations"
    public List<Location> getLocations() {
        return locations;
    }

    // Setter method for "locations"
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    // Getter method for "numOfLocations"
    public int getNumOfLocations() {
        return numOfLocations;
    }

    // Setter method for "numOfLocations"
    public void setNumOfLocations(int numOfLocations) {
        this.numOfLocations = numOfLocations;
    }

}
