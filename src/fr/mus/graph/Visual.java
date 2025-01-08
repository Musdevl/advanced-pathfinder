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
    private double zoomFactor = 1.0;

    public Visual(Graph graph, int width, int height) {
        this.graph = graph;
        this.nodePositions = new HashMap<>();
        this.physic = new Physic(width, height, graph.getNodes());
        layoutGraph();

        this.addMouseWheelListener(e -> {
            int rotation = e.getWheelRotation();
            if (rotation < 0) {
                zoomIn();
            } else {
                zoomOut();
            }
        });

        timer = new Timer(1, e -> {
            applyForces();
            repaint();
        });
        timer.start();
    }

    public void applyForces() {
        for (Node node : graph.getNodes()) {
            Point posNode = nodePositions.get(node);
            Point attraction = physic.attractionForce(nodePositions, node);
            Point repulsion = physic.repulsionForce(nodePositions, node);
            posNode.translate(attraction.x + repulsion.x, attraction.y + repulsion.y);
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

    private void zoomIn() {
        if (zoomFactor < 2.0) {
            zoomFactor += 0.1;
        }
        setZoomFactor(zoomFactor);
    }

    private void zoomOut() {
        if (zoomFactor > 0.5) {
            zoomFactor -= 0.1;
        }
        setZoomFactor(zoomFactor);
    }

    public void setZoomFactor(double zoomFactor) {
        this.zoomFactor = zoomFactor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.scale(zoomFactor, zoomFactor);  // Appliquer le facteur de zoom global

        // Fond noir
        setBackground(Color.BLACK);

        // Dessiner les arêtes
        g2d.setColor(Color.WHITE);
        for (Node node : graph.getNodes()) {
            for (Edge edge : node.getNeighbors()) {
                Point from = nodePositions.get(edge.getFrom());
                Point to = nodePositions.get(edge.getTo());
                g2d.drawLine(from.x, from.y, to.x, to.y);
            }
        }

        // Dessiner les nœuds
        g2d.setColor(Color.GREEN);
        for (Node node : graph.getNodes()) {
            Point point = nodePositions.get(node);
            g2d.fillOval(point.x - 15, point.y - 15, 30, 30);
            g2d.setColor(Color.WHITE);
            g2d.drawString(node.getData(), point.x - 10, point.y - 20);
        }
    }
}
