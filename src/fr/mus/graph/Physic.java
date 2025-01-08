package fr.mus.graph;

import java.awt.*;
import java.lang.reflect.Array;
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
        System.out.println(nodes);

        this.C = 0.1;
        this.k = C*Math.sqrt((double) (width * height) /nodes.size());

    }



    public Point repulsionForce(HashMap<Node, Point> dictPos, Node node1){
        Point displacement = new Point();
        Point posA = dictPos.get(node1);
        for(Node node2 : nodes) {
            Point posB = dictPos.get(node2);
            double distance = posA.distance(posB);
            double dx = posB.x - posA.x;
            double dy = posB.y - posA.y;
            if(distance > 0){
                double force = -k*k / distance;
                displacement.x += (int) (dx/distance*force);
                displacement.y += (int) (dy/distance*force);
            }
        }
        return displacement;
    }

    public Point attractionForce(HashMap<Node, Point> dictPos, Node node1){
        Point displacement = new Point();
        for (Edge edge : node1.getNeighbors()) {
            Point A = dictPos.get(edge.getFrom());
            Point B = dictPos.get(edge.getTo());
            double distance = A.distance(B);
            double dx = B.x - A.x;
            double dy = B.y - A.y;
            if(distance > 0) {
                double force = distance * distance / k;
                displacement.x += (int) (dx/distance*force);
                displacement.y += (int) (dy/distance*force);
            }
        }
        return displacement;
    }
}
