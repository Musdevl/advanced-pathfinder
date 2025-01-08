package fr.mus.graph;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int width = 1920;
        int height = 1080;

        Graph graph = new Graph();
        graph.initGraph();


        JFrame frame = new JFrame("Graph Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);

        // Créer une instance de Visual et l'ajouter à la fenêtre
        Visual visual = new Visual(graph, width, height);
        frame.add(visual);

        frame.setVisible(true);
    }
}
