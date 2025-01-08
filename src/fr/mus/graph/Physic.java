package fr.mus.graph;

import java.awt.geom.Point2D;
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

        this.C = 0.55;
        this.k = C * Math.sqrt((double) (width * height) / nodes.size()) * 0.05;  // Plus petit facteur k
    }

    public Point2D.Double repulsionForce(HashMap<Node, Point2D.Double> dictPos, Node node1) {
        Point2D.Double displacement = new Point2D.Double();
        Point2D.Double posA = dictPos.get(node1);
        for (Node node2 : nodes) {
            if (node1 != node2) {  // Ne pas calculer la répulsion entre le nœud et lui-même
                Point2D.Double posB = dictPos.get(node2);
                double distance = posA.distance(posB);
                double dx = posB.x - posA.x;
                double dy = posB.y - posA.y;
                if (distance > 2) {
                    // Limiter la répulsion en fonction de la distance
                    double force = -k * k / distance;
                    force = Math.max(-5, Math.min(force, 5));

                    displacement.x += dx / distance * force;
                    displacement.y += dy / distance * force;
                }
            }
        }
        System.out.println("Repulsion : " + displacement);
        return displacement;
    }

    public Point2D.Double attractionForce(HashMap<Node, Point2D.Double> dictPos, Node node1) {
        Point2D.Double displacement = new Point2D.Double();
        System.out.println(k);
        for (Edge edge : node1.getNeighbors()) {
            Point2D.Double A = dictPos.get(edge.getFrom());
            Point2D.Double B = dictPos.get(edge.getTo());
            double distance = A.distance(B);
            double dx = B.getX() - A.getX();
            double dy = B.getY() - A.getY();
            if (distance > 0) {
                // Limiter la force d'attraction
                double force = distance * distance / k;
                force = Math.max(-5, Math.min(force, 5));  // Limiter la force d'attraction
                displacement.x += dx / distance * force;
                displacement.y += dy / distance * force;
            }
        }
        System.out.println("Attraction : " + displacement);
        return displacement;
    }
}