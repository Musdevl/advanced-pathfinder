package fr.mus.graph;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Visual extends JPanel {

    private Graph graph;
    private HashMap<Node, Point> nodePositions;

    public Visual(Graph graph){
        this.graph = graph;
        this.nodePositions = new HashMap<>();
        layoutGraph();
    }


    private void layoutGraph() {
        int radius = 100;
        int centerX = 250;
        int centerY = 250;
        double angle = 0;
        double angleIncrement = 2 * Math.PI / graph.getNodes().size();

        for (Node node : graph.getNodes()) {
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));
            nodePositions.put(node, new Point(x, y));
            angle += angleIncrement;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dessiner les arêtes
        for (Node node : graph.getNodes()) {
            for (Edge edge : node.getEdges()) {
                Point from = nodePositions.get(edge.getFrom());
                Point to = nodePositions.get(edge.getTo());
                g2d.drawLine(from.x, from.y, to.x, to.y);
                g2d.drawString(String.valueOf(edge.getWeight()), (from.x + to.x) / 2, (from.y + to.y) / 2);
            }
        }

        // Dessiner les nœuds
        for (Node node : graph.getNodes()) {
            Point point = nodePositions.get(node);
            g2d.fillOval(point.x - 10, point.y - 10, 20, 20);
            g2d.drawString(node.getName(), point.x - 10, point.y - 20);
        }
    }

}
