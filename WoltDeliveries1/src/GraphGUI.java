import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GraphGUI extends JFrame implements ActionListener
{
    private JPanel panel; // declare a private JPanel variable
    List<JButton> buttonsForLocations; // declare a List of JButtons
    JPanel panelForDistanceTo; // declare a JPanel variable
    List<Edge> linesForDistanceTo; // declare a List of Edge objects
    WoltDeliveries woltDeliveries;
    private JButton previousButton = null; // declare a private JButton variable initialized to null
    List <JLabel> labels;

    public GraphGUI(WoltDeliveries woltDeliveries) {
        this.woltDeliveries = woltDeliveries;

        initializeFrame();
        drawNodes();
        drawEdges();
        addSetDeliveryPersonButton();
        addResturanName();
        ShowDest();
        ShowPath();
    }

    private void initializeFrame() {
        panel = new JPanel(); // initialize a new JPanel object
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1900, 1000);
        setTitle("City");
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1800, 1000));
        getContentPane().add(panel);
        panel.setBackground(Color.lightGray);
    }

    private void drawNodes()
    {
        buttonsForLocations = new ArrayList<>(); // initialize a new ArrayList of JButtons

        // Draw the nodes on the panel
        for (Location location : woltDeliveries.getCity().getLocations()) { // loop through each Location object in the locations List
            int x = (int) (Math.random() * 800) + 500; // generate a random x coordinate
            int y = (int) (Math.random() * 700) + 1; // generate a random y coordinate

            JButton node = new JButton(location.toString()); // create a new JButton with the name of the Location
            node.addActionListener(this); // add an ActionListener to the JButton
            buttonsForLocations.add(node); // add the JButton to the buttonsForLocations List
            node.setBackground(Color.gray); // set the background color of the JButton
            node.setForeground(Color.black);
            node.setFont(new Font("Arial", Font.BOLD, 14));
            node.setBounds(x, y, 144, 43); // set the bounds of the JButton
            panel.add(node); // add the JButton to the panel

            StringBuilder tooltip = new StringBuilder("<html><b>Adjacencies:</b><br>"); // create a StringBuilder object
            for (DistanceTo adjacency : location.getAdjacencies()) { // loop through each DistanceTo object in the Location's adjacencies List
                tooltip.append(adjacency.getSuccessor().toString()).append(" (").append(adjacency.getWeight()).append(")<br>"); // add the successor's name and weight to the StringBuilder object
            }
            tooltip.append("</html>"); // append the closing HTML tag to the StringBuilder object
            node.setToolTipText(tooltip.toString()); // set the tooltip of the JButton to the StringBuilder object
        }
        buttonsForLocations.get(0).setBackground(Color.red); // set the background color of the first JButton to red
    }
        private void drawEdges()
        {
            labels = new ArrayList<>();
            linesForDistanceTo = new ArrayList<>(); // initialize a new ArrayList of Edge objects
            panelForDistanceTo = new JPanel(); // initialize a new JPanel object
            int edgeId = 0;
            panelForDistanceTo.setBackground(Color.gray); // set the background color of the panelForDistanceTo JPanel object
            panelForDistanceTo.add(Box.createVerticalStrut(10)); // Add a fixed vertical gap of 5 pixels

            for (Location location : woltDeliveries.getCity().getLocations()) { // Loop through each locatio
              for (DistanceTo adjacency : location.getAdjacencies()) { // Loop through each adjacency of the location
                    Location successor = adjacency.getSuccessor(); // Get the successor location of the adjacency
                    JButton startNode = getNodeButton(location.toString()); // Get the button for the start location
                    JButton endNode = getNodeButton(successor.toString()); // Get the button for the end location
                    Edge current = new Edge(edgeId,startNode, endNode, adjacency.getWeight()); // Create an edge between the start and end nodes with the weight of the adjacency
                    linesForDistanceTo.add(current); // Add the edge to a list of edges
                    panel.add(current); // Add the edge to the panel
                    JLabel jLabel = new JLabel(); // Create a new label for displaying the distance
                    jLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font and size of the label
                    jLabel.setText("  Distance from Location " + location.getId() + " to Location " + (adjacency.getSuccessor().getId()) + " is " + adjacency.getWeight() + "  "); // Set the text of the label
                    jLabel.setForeground(Color.black);
                    labels.add(jLabel);
                    panelForDistanceTo.add(jLabel); // Add the label to the panel for distances
                    panelForDistanceTo.add(Box.createVerticalStrut(20)); // Add a fixed vertical gap of 5 pixels
                    edgeId++;
              }
            }

            panelForDistanceTo.setBounds(10, 210, 444, 570); // set the bounds of the panelForDistanceTo JPanel object
            BoxLayout layout = new BoxLayout(panelForDistanceTo, BoxLayout.Y_AXIS); // Create a vertical box layout for the panel of distances
            panelForDistanceTo.setLayout(layout); // Set the layout of the panel for distances
            panelForDistanceTo.setVisible(true); // Make the panel for distances visible
            panel.add(panelForDistanceTo); // Add the panel for distances to the main panel.
        }

        private void addSetDeliveryPersonButton() {
            JButton setDelPer = new JButton("Set Delivery Person");
            setDelPer.setBounds(10, 160, 444, 40);
            setDelPer.setBackground(Color.darkGray);
            setDelPer.setFont(new Font("Arial", Font.BOLD, 20));
            setDelPer.setForeground(Color.black);
            setDelPer.addActionListener(this);
            panel.add(setDelPer);
        }
        private void addResturanName() {
            JLabel setDelPer = new JLabel("Resturant name : " + woltDeliveries.getRestaurants().get(0).getName());
            setDelPer.setBounds(10, 60, 444, 40);
            setDelPer.setBackground(Color.gray);
            setDelPer.setOpaque(true); // Set the opaque property to true to make the background color visible
            setDelPer.setFont(new Font("Arial", Font.BOLD, 20));
            setDelPer.setForeground(Color.black);
            setDelPer.setBorder(new EmptyBorder(0, 10, 0, 0)); // Top, Left, Bottom, Right
            panel.add(setDelPer);
        }

        // This method shows the destinations of the customers on a JLabel
        public void ShowDest()
        {
            String string = " "; // Initialize a string variable
            JLabel jLabel2 = new JLabel(); // Create a new JLabel object
            jLabel2.setBounds(10,10,444,40); // Set the bounds of the label
            jLabel2.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font of the label
            jLabel2.setAlignmentX(0); // Align the label

            // Iterate through the list of locations and append their IDs to the string
            for (Location location:woltDeliveries.getDestCustomers()){
            string += " " + (location.getId());
            }

            // Set the text of the label to display the destination customers
            jLabel2.setText("Customers list :" + string );
            jLabel2.setForeground(Color.black);
            jLabel2.setBackground(Color.gray); // Set the background color to yellow
            jLabel2.setOpaque(true); // Set the opaque property to true to make the background color visible
            jLabel2.setBorder(new EmptyBorder(0, 10, 0, 0)); // Top, Left, Bottom, Right

            // Add the label to the panel
            panel.add(jLabel2);
        }

        // This method shows the shortest path on a JLabel
        public void ShowPath( )
        {
            woltDeliveries.setMainPath(new ArrayList<>());
            woltDeliveries.createTheShortestPathBetweenRestaurantToCustomers(woltDeliveries.getRestaurants().get(0));
            String string = " "; // Initialize a string variable
            JLabel jLabel2 = new JLabel(); // Create a new JLabel object

            jLabel2.setBounds(10,110,444,40); // Set the bounds of the label
            jLabel2.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font of the label
            jLabel2.setAlignmentX(0); // Align the label

            // Iterate through the list of locations and append their IDs to the string
            for (Location location:woltDeliveries.getMainPath()){
                string += " " + (location.getId());
            }

            // Set the text of the label to display the shortest path
            jLabel2.setText("Shortest path :" + string );
            jLabel2.setForeground(Color.black);
            jLabel2.setBackground(Color.darkGray); // Set the background color to yellow
            jLabel2.setOpaque(true); // Set the opaque property to true to make the background color visible
            jLabel2.setBorder(new EmptyBorder(0, 10, 0, 0)); // Top, Left, Bottom, Right

            // Add the label to the panel
            panel.add(jLabel2);

            // Add a fixed vertical gap of 10 pixels
            panel.add(Box.createVerticalStrut(10));
        }

        // This method returns a JButton object with a specified name
        private JButton getNodeButton(String name) {
            // Get all the components of the panel
            Component[] components = panel.getComponents();

            // Iterate through the components and find the button with the specified name
            for (Component component : components) {
                if (component instanceof JButton && ((JButton) component).getText().equals(name)) {
                    return (JButton) component;
                }
            }

            // Return null if the button is not found
            return null;
        }

        // This method is called when a button is clicked
    public void actionPerformed(ActionEvent e) {
        JButton currentButton = (JButton) e.getSource(); // Get the button that was clicked

           if (currentButton.getText() == "Set Delivery Person") {
               DeliveryPerson nearestDeliveryPerson = (DeliveryPerson) woltDeliveries.getNearestLocation(woltDeliveries.getDeliveryPersons());
               nearestDeliveryPerson.setShortestPath(woltDeliveries.getMainPath());
               JOptionPane.showMessageDialog(null, "The nearest delivery Person have id : [" + nearestDeliveryPerson.getId() + "] he got your path!");
           }
           else {
               // Reset the color of the previous button's edges (if there was a previous button)
               if (previousButton != null) {
                   resetEdges(previousButton);
               }
               buttonsForLocations.get(0).setBackground(Color.red);

               // Change the color of the current button's edges
               changeEdges(currentButton);

               // Update the previous button to the current button
               previousButton = currentButton;
           }
    }

        // This method resets the color of the edges of a button
        private void resetEdges(JButton button) {
            // Iterate through the edges and set the background color of the end node to gray
            for (Edge adjacency : linesForDistanceTo) {
                if (adjacency.getStartNode() == button) {
                    adjacency.getEndNode().setBackground(Color.gray);
                    labels.get(adjacency.getId()).setForeground(Color.black);
                }
            }

        }

        // Method to change the background color of all edges that start from a specified button to the given color
        private void changeEdges(JButton button) {

            // Loop through all the edges in the linesForDistanceTo list
            for (Edge adjacency : linesForDistanceTo) {

                // Check if the current edge starts from the specified button
                if (adjacency.getStartNode() == button) {

                    // If it does, set the background color of the end node of the edge to the given color
                    adjacency.getEndNode().setBackground(Color.blue);
                    labels.get(adjacency.getId()).setForeground(Color.blue);
                }
            }
        }

        public static void main(String[] args) {
            // Create some sample data for the graph
            List<Location> locations = new ArrayList<>();
            List<Customer> customers = new ArrayList<>();
            List<Restaurant> restaurants = new ArrayList<>();
            List<DeliveryPerson> deliveryPersons = new ArrayList<>();

            Location location1 = new Restaurant(0, LocationType.RESTURANT, null,"Papa john",02,null);
            locations.add(location1);
            restaurants.add((Restaurant) location1);

            Location location2 = new Customer(1,LocationType.CUSTOMER,null,"second","s",03);
            locations.add(location2);
            customers.add((Customer) location2);

            Location location3 = new Customer(2,LocationType.CUSTOMER,null,"second","s",03);
            locations.add(location3);
            customers.add((Customer) location3);

            Location location4 = new Customer(3,LocationType.CUSTOMER,null,"second","s",03);
            locations.add(location4);
            customers.add((Customer) location4);

            Location location5 = new Customer(4,LocationType.CUSTOMER,null,"second","s",03);
            locations.add(location5);
            customers.add((Customer) location5);

            location1.setAdjacencies(new DistanceTo[]{new DistanceTo(location2, 10),new DistanceTo(location4, 5)});
            location2.setAdjacencies(new DistanceTo[]{new DistanceTo(location3, 1),new DistanceTo(location4, 2)});
            location3.setAdjacencies(new DistanceTo[]{new DistanceTo(location5, 4)});
            location4.setAdjacencies(new DistanceTo[]{new DistanceTo(location2, 3),new DistanceTo(location3, 9),new DistanceTo(location5, 2)});
            location5.setAdjacencies(new DistanceTo[]{new DistanceTo(location3, 6),new DistanceTo(location1, 7)});

            Location deliveryPerson1 = new DeliveryPerson(0,LocationType.DELIVERYPERSON,null,"dsa","as",02,null);
            deliveryPerson1.setDistance(10);
            deliveryPersons.add((DeliveryPerson) deliveryPerson1);

            Location deliveryPerson2 = new DeliveryPerson(1,LocationType.DELIVERYPERSON,null,"dsa","as",02,null);
            deliveryPerson2.setDistance(3);
            deliveryPersons.add((DeliveryPerson) deliveryPerson2);

            City city = new City(locations,6);

            WoltDeliveries woltDeliveries = new WoltDeliveries(city,deliveryPersons,customers,restaurants);

            GraphGUI gui = new GraphGUI(woltDeliveries);
            gui.pack();
            gui.setVisible(true);
        }
}
