package src.main.java.data_structure.test;

import src.main.java.data_structure._09_graph.DepthFirstSearch;
import src.main.java.data_structure._09_graph.Graph;

public class GraphDemo {
    public static void main(String[] args) {
        Graph g =new Graph(10);
        g.addEdge(1,2);
        g.addEdge(3,2);
        g.addEdge(1,4);
        g.addEdge(5,4);
        g.addEdge(8,9);
        g.addEdge(8,9);
        System.out.println("边数="+g.E());
        System.out.println(g.adj(4));

        DepthFirstSearch dfs =new DepthFirstSearch(g, 4);
        System.out.println("与s相通的顶点总="+(dfs.count()-1));
    }
}
