// Define a public Java class named "DistanceTo"
public class DistanceTo  {
    // Define a private instance variable of type "Location" called "successor"
    private Location successor;
    // Define a private instance variable of type "int" called "weight"
    private int weight;

    // Define a constructor for the DistanceTo class, which takes in a "successor" Location and a "weight" value
    public DistanceTo(Location successor, int weight) {
        this.successor = successor;
        this.weight = weight;
    }

    // Define a method called "getSuccessor" that returns the private instance variable "successor"
    public Location getSuccessor() {
        return successor;
    }

    // Define a method called "setSuccessor" that takes in a "successor" Location and sets the private instance variable "successor" to it
    public void setSuccessor(Location successor) {
        this.successor = successor;
    }

    // Define a method called "getWeight" that returns the private instance variable "weight"
    public int getWeight() {
        return weight;
    }

    // Define a method called "setWeight" that takes in a "weight" value and sets the private instance variable "weight" to it
    public void setWeight(int weight) {
        this.weight = weight;
    }

}








