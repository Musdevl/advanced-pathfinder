package fr.mus.graph;

import java.util.ArrayList;

public class Node {

    private String data;
    private ArrayList<Edge> neighbors;

    public Node(String data){
        this.data = data;
        this.neighbors = new ArrayList<>();
    }

    public void addLink(Edge n){
        neighbors.add(n);
    }

    public String getData(){
        return data;
    }

    public void linkToNode(Node node, int weight){
        this.neighbors.add(new Edge(this, node, weight));
    }

    public boolean removeEdge(Node node){
        return this.neighbors.removeIf(edge -> edge.getTo().equals(node));
    }

    public ArrayList<Edge> getNeighbors(){
        return neighbors;
    }

    @Override
    public String toString(){
        return data;
    }

}
