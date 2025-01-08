package fr.mus.graph;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addEdge(Node from, Node to, int weight) {
        from.linkToNode(to, weight);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

}
