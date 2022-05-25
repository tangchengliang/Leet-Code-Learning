package src.main.java.data_structure.test;

import src.main.java.data_structure._09_graph.Edge;
import src.main.java.data_structure._09_graph.EdgeWeightedGraph;

import java.util.ArrayDeque;

public class EdgeWeightedGraphTest {
    public static void main(String[] args) {
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(5);
        Edge edge = new Edge(0,1,1);
        Edge edge2 = new Edge(0,2,2);
        Edge edge3 = new Edge(0,3,3);
        ewg.addEdge(edge);
        ewg.addEdge(edge2);
        ewg.addEdge(edge3);
        ArrayDeque<Edge> all = ewg.get_edges();
        System.out.println(all);
    }
}
