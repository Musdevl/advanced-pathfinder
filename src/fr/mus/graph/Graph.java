package fr.mus.graph;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(Node n){
        nodes.add(n);
    }

    public void addEdge(Node from, Node to, int weight) {
        Edge e = new Edge(from, to, weight);
        edges.add(e);
        from.linkToNode(to, weight);
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void initGraph() {
        Node KIEL = new Node("Kiel");
        this.addNode(KIEL);
        Node DANEMARK = new Node("Danemark");
        this.addNode(DANEMARK);
        this.addEdge(KIEL, DANEMARK, 2);
        Node ROSTOCK = new Node("Rostock");
        this.addNode(ROSTOCK);
        this.addEdge(KIEL, ROSTOCK, 4);
        Node SCHWERIN = new Node("Schwerin");
        this.addNode(SCHWERIN);
        this.addEdge(KIEL, SCHWERIN, 3);
        Node HAMBURG = new Node("Hamburg");
        this.addNode(HAMBURG);
        this.addEdge(KIEL, HAMBURG, 2);
        Node BREMERHAVEN = new Node("Bremerhaven");
        this.addNode(BREMERHAVEN);
        this.addEdge(KIEL, BREMERHAVEN, 3);
        this.addEdge(DANEMARK, BREMERHAVEN, 5);
        this.addEdge(HAMBURG, SCHWERIN, 2);
        this.addEdge(HAMBURG, BREMERHAVEN, 3);
        Node BREMEN = new Node("Bremen");
        this.addNode(BREMEN);
        this.addEdge(HAMBURG, BREMEN, 3);
        Node HANNOVER = new Node("Hannover");
        this.addNode(HANNOVER);
        this.addEdge(HAMBURG, HANNOVER, 4);
        Node BERLIN = new Node("Berlin");
        this.addNode(BERLIN);
        this.addEdge(HAMBURG, BERLIN, 7);
        Node EMDEN = new Node("Emden");
        this.addNode(EMDEN);
        this.addEdge(BREMERHAVEN, EMDEN, 3);
        this.addEdge(BREMERHAVEN, BREMEN, 1);
        Node NIEDERLANDE = new Node("Niederlande");
        this.addNode(NIEDERLANDE);
        this.addEdge(EMDEN, NIEDERLANDE, 2);
        this.addEdge(EMDEN, BREMEN, 3);
        Node MUNSTER = new Node("Munster");
        this.addNode(MUNSTER);
        this.addEdge(EMDEN, MUNSTER, 4);
        this.addEdge(BREMEN, MUNSTER, 3);
        this.addEdge(BREMEN, HANNOVER, 3);
        this.addEdge(ROSTOCK, SCHWERIN, 2);
        this.addEdge(ROSTOCK, BERLIN, 6);
        this.addEdge(SCHWERIN, BERLIN, 5);
        Node DRESDEN = new Node("Dresden");
        this.addNode(DRESDEN);
        this.addEdge(BERLIN, DRESDEN, 5);
        this.addEdge(BERLIN, HANNOVER, 7);
        Node MAGDEBURG = new Node("Magdeburg");
        this.addNode(MAGDEBURG);
        this.addEdge(BERLIN, MAGDEBURG, 3);
        Node LEIPZIG = new Node("Leipzig");
        this.addNode(LEIPZIG);
        this.addEdge(BERLIN, LEIPZIG, 4);
        this.addEdge(MAGDEBURG, HANNOVER, 4);
        this.addEdge(MAGDEBURG, LEIPZIG, 2);
        this.addEdge(LEIPZIG, DRESDEN, 3);
        Node CHEMNITZ = new Node("Chemnitz");
        this.addNode(CHEMNITZ);
        this.addEdge(LEIPZIG, CHEMNITZ, 2);
        Node ERFURT = new Node("Erfurt");
        this.addNode(ERFURT);
        this.addEdge(LEIPZIG, ERFURT, 3);
        this.addEdge(ERFURT, HANNOVER, 5);
        Node KASSEL = new Node("Kassel");
        this.addNode(KASSEL);
        this.addEdge(ERFURT, KASSEL, 3);
        Node REGENSBURG = new Node("Regensburg");
        this.addNode(REGENSBURG);
        this.addEdge(ERFURT, REGENSBURG, 7);
        Node NURNBERG = new Node("Nurnberg");
        this.addNode(NURNBERG);
        this.addEdge(ERFURT, NURNBERG, 4);
        this.addEdge(DRESDEN, CHEMNITZ, 1);
        this.addEdge(DRESDEN, REGENSBURG, 7);
        this.addEdge(CHEMNITZ, REGENSBURG, 6);
        this.addEdge(KASSEL, HANNOVER, 3);
        Node DORTMUND = new Node("Dortmund");
        this.addNode(DORTMUND);
        this.addEdge(KASSEL, DORTMUND, 4);
        Node FRANKFURT = new Node("Frankfurt");
        this.addNode(FRANKFURT);
        this.addEdge(KASSEL, FRANKFURT, 4);
        this.addEdge(MUNSTER, HANNOVER, 4);
        this.addEdge(MUNSTER, NIEDERLANDE, 2);
        this.addEdge(MUNSTER, DORTMUND, 1);
        Node DUSSELDORF = new Node("Dusseldorf");
        this.addNode(DUSSELDORF);
        this.addEdge(DORTMUND, DUSSELDORF, 1);
        this.addEdge(DUSSELDORF, NIEDERLANDE, 3);
        Node KOLN = new Node("Koln");
        this.addNode(KOLN);
        this.addEdge(DUSSELDORF, KOLN, 1);
        this.addEdge(KOLN, FRANKFURT, 4);
        Node KOBLENZ = new Node("Koblenz");
        this.addNode(KOBLENZ);
        this.addEdge(KOBLENZ, KOLN, 1);
        Node MAINZ = new Node("Mainz");
        this.addNode(MAINZ);
        this.addEdge(KOBLENZ, MAINZ, 2);
        Node SAARBRUCKEN = new Node("Saarbrucken");
        this.addNode(SAARBRUCKEN);
        this.addEdge(SAARBRUCKEN, KOBLENZ, 3);
        this.addEdge(SAARBRUCKEN, MAINZ, 3);
        Node MANNHEIM = new Node("Mannheim");
        this.addNode(MANNHEIM);
        this.addEdge(SAARBRUCKEN, MANNHEIM, 3);
        Node KARLSRUHE = new Node("Karlsruhe");
        this.addNode(KARLSRUHE);
        this.addEdge(SAARBRUCKEN, KARLSRUHE, 3);
        Node FRANKREICH = new Node("Frankreich");
        this.addNode(FRANKREICH);
        this.addEdge(SAARBRUCKEN, FRANKREICH, 1);
        this.addEdge(FRANKFURT, MAINZ, 1);
        Node WURZBURG = new Node("Wurzburg");
        this.addNode(WURZBURG);
        this.addEdge(FRANKFURT, WURZBURG, 2);
        this.addEdge(FRANKFURT, MANNHEIM, 2);
        this.addEdge(MANNHEIM, MAINZ, 1);
        this.addEdge(MANNHEIM, KARLSRUHE, 1);
        Node STUTTGART = new Node("Stuttgart");
        this.addNode(STUTTGART);
        this.addEdge(MANNHEIM, STUTTGART, 2);
        this.addEdge(KARLSRUHE, STUTTGART, 1);
        this.addEdge(KARLSRUHE, FRANKREICH, 2);
        Node FREIBURG = new Node("Freiburg");
        this.addNode(FREIBURG);
        this.addEdge(KARLSRUHE, FREIBURG, 3);
        this.addEdge(FREIBURG, STUTTGART, 3);
        Node KONSTANZ = new Node("Konstanz");
        this.addNode(KONSTANZ);
        this.addEdge(FREIBURG, KONSTANZ, 2);
        Node SCHWEIZ = new Node("Schweiz");
        this.addNode(SCHWEIZ);
        this.addEdge(FREIBURG, SCHWEIZ, 2);
        this.addEdge(KONSTANZ, STUTTGART, 3);
        Node LINDAU = new Node("Lindau");
        this.addNode(LINDAU);
        this.addEdge(KONSTANZ, LINDAU, 1);
        this.addEdge(KONSTANZ, SCHWEIZ, 1);
        Node ULM = new Node("Ulm");
        this.addNode(ULM);
        this.addEdge(ULM, STUTTGART, 2);
        this.addEdge(ULM, LINDAU, 2);
        Node AUGSBURG = new Node("Augsburg");
        this.addNode(AUGSBURG);
        this.addEdge(ULM, AUGSBURG, 1);
        this.addEdge(LINDAU, SCHWEIZ, 2);
        Node OSTEREICH = new Node("Ostereich");
        this.addNode(OSTEREICH);
        this.addEdge(LINDAU, OSTEREICH, 2);
        Node MUNCHEN = new Node("Munchen");
        this.addNode(MUNCHEN);
        this.addEdge(LINDAU, MUNCHEN, 5);
        this.addEdge(NURNBERG, WURZBURG, 2);
        this.addEdge(NURNBERG, REGENSBURG, 3);
        this.addEdge(NURNBERG, MUNCHEN, 5);
        this.addEdge(NURNBERG, AUGSBURG, 4);
        this.addEdge(MUNCHEN, AUGSBURG, 2);
        this.addEdge(MUNCHEN, OSTEREICH, 3);
        this.addEdge(MUNCHEN, REGENSBURG, 3);
        this.addEdge(REGENSBURG, OSTEREICH, 4);
    }

}
