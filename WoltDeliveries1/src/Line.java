import javax.swing.*;
import java.awt.*;

class Edge extends JComponent {
   private JButton startNode, endNode;
    private int weight;

    private int lineX; // X coordinate of the moving line

    private int lineY; // Y coordinate of the moving line

    private boolean isLineMoving; // Flag indicating whether the line is currently moving

    private int id;
    public Edge(int id,JButton startNode, JButton endNode, int weight) {
        this.id = id;
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
        setBounds(0, 0, 1700, 1200);
    }


   @Override
        public void paint(Graphics g) {
        Point startPoint = SwingUtilities.convertPoint(startNode, startNode.getWidth() / 2, startNode.getHeight() / 2, this);
       Point endPoint = SwingUtilities.convertPoint(endNode, endNode.getWidth() / 2, endNode.getHeight() / 2, this);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(weight));
        g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
}

    public JButton getStartNode() {
        return startNode;
    }

    public void setStartNode(JButton startNode) {
        this.startNode = startNode;
    }

    public JButton getEndNode() {
        return endNode;
    }

    public void setEndNode(JButton endNode) {
        this.endNode = endNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
