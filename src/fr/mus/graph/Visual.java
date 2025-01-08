package fr.mus.graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Visual extends JPanel {

    private Graph graph;
    private HashMap<Node, Point> nodePositions;
    private int width, height;
    private Physic physic;
    private Timer timer;

    public Visual(Graph graph, int width, int height) {

        this.graph = graph;
        this.nodePositions = new HashMap<>();
        this.physic = new Physic(width, height, graph.getNodes());
        layoutGraph();

        timer = new Timer(50, e -> {
            applyForces();
            repaint();
        });
        timer.start();
    }

    public void applyForces(){
        System.out.println("Applying forces");
        double forceFactor = 0.1;
        // Forces
        for(Node node : graph.getNodes()){
            Point posNode = nodePositions.get(node);
            Point attraction = physic.attractionForce(nodePositions, node);
            Point repuslsion = physic.repulsionForce(nodePositions, node);
            posNode.translate(attraction.x + repuslsion.x, attraction.y + repuslsion.y);
            this.nodePositions.put(node, posNode);
        }
    }



    private void layoutGraph() {
        int gridSize = (int) Math.ceil(Math.sqrt(graph.getNodes().size()));
        int cellSize = 100;
        int startX = 50;
        int startY = 50;

        int index = 0;
        for (Node node : graph.getNodes()) {
            int x = startX + (index % gridSize) * cellSize;
            int y = startY + (index / gridSize) * cellSize;
            nodePositions.put(node, new Point(x, y));
            index++;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dessiner les arêtes
        g2d.setColor(Color.GRAY);
        for (Node node : graph.getNodes()) {
            for (Edge edge : node.getNeighbors()) {
                Point from = nodePositions.get(edge.getFrom());
                Point to = nodePositions.get(edge.getTo());
                g2d.drawLine(from.x, from.y, to.x, to.y);
                g2d.drawString(String.valueOf(edge.getWeight()), (from.x + to.x) / 2, (from.y + to.y) / 2);
            }
        }

        // Dessiner les nœuds
        g2d.setColor(Color.BLUE);
        for (Node node : graph.getNodes()) {
            Point point = nodePositions.get(node);
            g2d.fillOval(point.x - 15, point.y - 15, 30, 30);
            g2d.setColor(Color.WHITE);
            g2d.drawString(node.getData(), point.x - 10, point.y - 20);
        }
    }

}
