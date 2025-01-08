package fr.mus.graph;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;

public class Visual extends JPanel {

    private Graph graph;
    private HashMap<Node, Point2D.Double> nodePositions;
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
            Point2D.Double posNode = nodePositions.get(node);
            Point2D.Double attraction = physic.attractionForce(nodePositions, node);
            Point2D.Double repulsion = physic.repulsionForce(nodePositions, node);

            double newX = posNode.x + attraction.x + repulsion.x;
            double newY = posNode.y + attraction.y + repulsion.y;

            nodePositions.put(node, new Point2D.Double(newX, newY));
        }
    }

    private void layoutGraph() {
        int gridSize = (int) Math.ceil(Math.sqrt(graph.getNodes().size()));
        int cellSize = 10;
        double startX = 900.0;
        double startY = 500;

        int index = 0;
        for (Node node : graph.getNodes()) {
            double x = startX + (index % gridSize) * cellSize;
            double y = startY + (index / gridSize) * cellSize;
            nodePositions.put(node, new Point2D.Double(x, y));
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

        g2d.scale(zoomFactor, zoomFactor);

        // Fond noir
        setBackground(Color.BLACK);

        // Dessiner les arêtes
        g2d.setColor(Color.WHITE);
        for (Node node : graph.getNodes()) {
            for (Edge edge : node.getNeighbors()) {
                Point2D.Double from = nodePositions.get(edge.getFrom());
                Point2D.Double to = nodePositions.get(edge.getTo());
                g2d.drawLine((int) from.x, (int) from.y, (int) to.x, (int) to.y);
            }
        }

        // Dessiner les nœuds
        g2d.setColor(Color.GREEN);
        for (Node node : graph.getNodes()) {
            Point2D.Double point = nodePositions.get(node);
            g2d.fillOval((int) point.x - 15, (int) point.y - 15, 30, 30);
            g2d.setColor(Color.WHITE);
            g2d.drawString(node.getData(), (int) point.x - 10, (int) point.y - 20);
        }
    }
}
