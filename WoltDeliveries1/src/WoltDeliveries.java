import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// This is a public class named WoltDeliveries
public class WoltDeliveries {
    // This is the graph that represent  city
    private City city;
    // This is a private List of DeliveryPerson objects named deliveryPersons
    private List<DeliveryPerson> deliveryPersons;
    // This is a private List of Customer objects named customers
    private List<Customer> destCustomers;
    // This is a private List of Restaurant objects named restaurants
    private List<Restaurant> restaurants;
    // This is the shortest path from the resturant to the customers
    private List<Location> mainPath;

    // This is a constructor for the WoltDeliveries class, which initializes all the Lists to empty Lists
    public WoltDeliveries(City city, List<DeliveryPerson> deliveryPersons, List<Customer> destCustomers,List<Restaurant> restaurants) {
        this.city = city;
        this.deliveryPersons = deliveryPersons;
        this.destCustomers = destCustomers;
        this.restaurants = restaurants;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<DeliveryPerson> getDeliveryPersons() {
        return deliveryPersons;
    }

    public void setDeliveryPersons(List<DeliveryPerson> deliveryPersons) {
        this.deliveryPersons = deliveryPersons;
    }

    public List<Customer> getDestCustomers() {
        return destCustomers;
    }

    public void setDestCustomers(List<Customer> destCustomers) {
        this.destCustomers = destCustomers;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

     public List<Location> getMainPath() {
        return mainPath;
    }

    public void setMainPath(List<Location> mainPath) {
        this.mainPath = mainPath;
    }
    public void createShortestPathFromRestaurantToEveryCustomer(Location restaurant) {
        // Initialize Empty priority queue by minimal distance
        PriorityQueue<Location> priorityQueue = new PriorityQueue<Location>();
        // insert the restaurant location to the queue
        priorityQueue.add(restaurant);

        // Initialize the distances and parent for all customers
        for (Location currentLocation : city.getLocations()) {
            currentLocation.setDistance(Integer.MAX_VALUE);
            currentLocation.setParent(null);
        }
        // Set the distance to the restaurant to 0
        restaurant.setDistance(0);

        while (!priorityQueue.isEmpty()) {
            // Get the Customer with the smallest distance from the restaurant
                Location currentCustomer = priorityQueue.poll();
            //for every neighbor of the Customer with the smallest distance
            for (DistanceTo currentDistanceTo : currentCustomer.getAdjacencies()) {

                Location CurrentNeighbor = currentDistanceTo.getSuccessor();
                //check if the customer with the smallest distance + the distance between the current customer to neighbor customer is smaller then the distance to neighbor customer
                int newDistance = currentCustomer.getDistance() + currentDistanceTo.getWeight();

                if (newDistance < CurrentNeighbor.getDistance()) {
                    // Calculate the new distance of the neighbor, by adding the current customer distance with the distance between the current customer to the neighbor customer
                    CurrentNeighbor.setDistance(newDistance);
                    //update neighbor customer parent
                    CurrentNeighbor.setParent(currentCustomer);
                    // removes neighbor customer from priorityQueue to avoid duplications
                    priorityQueue.remove(CurrentNeighbor);
                    // adds to priorityQueue updated neighbor customer
                    priorityQueue.add(CurrentNeighbor);
                }
            }
        }

    }

    public List<Location> addPath(Location destCustomer) {
        List<Location> currentPath = new ArrayList<>();

        //the for loop starts at the destination customer and iterate through each customer or restaurant parent until it reach to the start
        for (Location currentLocation = destCustomer.getParent(); currentLocation != null;
             currentLocation = currentLocation.getParent()) {
            //The current restaurant or customer is added to the path
            currentPath.add(currentLocation);
        }
        //The path is reversed since it was constructed in reverse order.
        Collections.reverse(currentPath);
        //add the current path to main path
        mainPath.addAll(currentPath);
        return mainPath;

    }

    public List<Location> createTheShortestPathBetweenRestaurantToCustomers( Location restaurant) {
        Location minCustomer;
        List<Location> path = new ArrayList<>();
        Location lastCustomer = null;


        // Create the Shortest Path from restaurant to every destCustomers in city
        createShortestPathFromRestaurantToEveryCustomer(restaurant);
        // save the dest customer that have the min distance from restaurant
        minCustomer = getNearestLocation(destCustomers);
        // add the minCustomer path to main path
        path = addPath( minCustomer);
        // delete the dest min customer from the list of the destCustomers
        destCustomers.remove(minCustomer);

         for (Location destCustomer = destCustomers.get(0) ; destCustomers.size() != 0;) {
            // Create the Shortest Path from last dest customer to every destCustomers in city
            createShortestPathFromRestaurantToEveryCustomer( minCustomer);
            // save the dest customer that have the min distance from last dest customer
            minCustomer = getNearestLocation( destCustomers);
            // add the minCustomer path to main path
            path = addPath( minCustomer);
            // delete the dest min customer from the list of the destCustomers
            destCustomers.remove(minCustomer);
            // save the last destCustomer so we can add it in the end
            lastCustomer = destCustomer;
        }
        path.add(lastCustomer);
        return path;
    }

    public <T extends Location> Location getNearestLocation(List<T> locations) {
    Location nearestLocation = null;
    int minDistance = Integer.MAX_VALUE;

    for (Location currentLocation : locations) {
        if (currentLocation.getDistance() < minDistance) {
            nearestLocation = currentLocation;
            minDistance = currentLocation.getDistance();
        }
    }

    return nearestLocation;
    }
}