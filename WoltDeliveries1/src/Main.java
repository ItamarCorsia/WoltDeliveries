import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Location s = new Location(1,LocationType.RESTURANT,null);
        Location t = new Location(2,LocationType.CUSTOMER,null);
        Location x = new Location(3,LocationType.CUSTOMER,null);
        Location y = new Location(4,LocationType.CUSTOMER,null);
        Location z = new Location(5,LocationType.CUSTOMER,null);

        s.setAdjacencies( new DistanceTo[]{new DistanceTo(t,10),new DistanceTo(y,5)});
        t.setAdjacencies(new DistanceTo[]{new DistanceTo(x,1) ,new DistanceTo(y,2)});
        x.setAdjacencies( new DistanceTo[]{new DistanceTo(z,4)});
        y.setAdjacencies (new DistanceTo[]{new DistanceTo(t,3),new DistanceTo(x,9),new DistanceTo(z,2)});
        z.setAdjacencies ( new DistanceTo[]{new DistanceTo(x,6),new DistanceTo(s,7)});
        List<Location> graph = new ArrayList<>();
        graph.add(s);
        graph.add(t);
        graph.add(x);
        graph.add(y);
        graph.add(z);

      // WoltDeliveries woltDeliveries = new WoltDeliveries(graph);
       // woltDeliveries.createShortestPathFromRestaurantToEveryCustomer(graph,s);
       //  List<Location> cus = new ArrayList<>();
       // cus.add(t);
       // cus.add(z);

      // List<Location> fpath = woltDeliveries.createTheShortestPathBetweenRestaurantToCustomers(graph,s,cus);

      //  for (Location v : graph) {
       //     List<Location> currentPath = new ArrayList<>();
       //     List<Location> path = woltDeliveries.addPath(graph, v, currentPath);
       //     System.out.println("Path: " + path);
       // }
    }
}
