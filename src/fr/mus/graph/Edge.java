package fr.mus.graph;

import java.util.ArrayList;

public class Edge {

    private Node from;
    private Node to;
    private int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Node getFrom() {
        return from;
    }
    public Node getTo(){
        return to;
    }
    public int getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return "Edge [from=" + from.getData() + ", to=" + to.getData() + ", weight=" + weight + "]";
    }
}
