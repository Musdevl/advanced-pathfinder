package fr.mus.graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Physic {

    private int width, height;
    private ArrayList<Node> nodes;
    private double C;
    private double k;

    public Physic(int width, int height, ArrayList<Node> nodelist) {
        this.width = width;
        this.height = height;
        this.nodes = nodelist;

        this.C = 0.1;
        this.k = C * Math.sqrt((double) (width * height) / nodes.size()) * 0.05;  // Plus petit facteur k
    }

    public Point repulsionForce(HashMap<Node, Point> dictPos, Node node1) {
        Point displacement = new Point();
        Point posA = dictPos.get(node1);
        for (Node node2 : nodes) {
            if (node1 != node2) {  // Ne pas calculer la répulsion entre le nœud et lui-même
                Point posB = dictPos.get(node2);
                double distance = posA.distance(posB);
                double dx = posB.x - posA.x;
                double dy = posB.y - posA.y;
                if (distance > 0) {
                    // Limiter la répulsion en fonction de la distance
                    double force = -k * k / distance;
                    force = Math.max(-5, Math.min(force, 5));  // Limiter la force de répulsion

                    displacement.x += (int) (dx / distance * force);
                    displacement.y += (int) (dy / distance * force);
                }
            }
        }
        return displacement;
    }

    public Point attractionForce(HashMap<Node, Point> dictPos, Node node1) {
        Point displacement = new Point();
        for (Edge edge : node1.getNeighbors()) {
            Point A = dictPos.get(edge.getFrom());
            Point B = dictPos.get(edge.getTo());
            double distance = A.distance(B);
            double dx = B.x - A.x;
            double dy = B.y - A.y;
            if (distance > 0) {
                // Limiter la force d'attraction
                double force = distance * distance / k;
                force = Math.max(-5, Math.min(force, 5));  // Limiter la force d'attraction

                displacement.x += (int) (dx / distance * force);
                displacement.y += (int) (dy / distance * force);
            }
        }
        return displacement;
    }
}
