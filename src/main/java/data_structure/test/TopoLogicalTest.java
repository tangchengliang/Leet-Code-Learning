package src.main.java.data_structure.test;

import src.main.java.data_structure._09_graph.DiGraph;
import src.main.java.data_structure._09_graph.TopoLogical;

import java.util.Stack;

public class TopoLogicalTest {
    public static void main(String[] args) {
        DiGraph g = new DiGraph(6);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(3,4);
        g.addEdge(1,3);

        TopoLogical tl = new TopoLogical(g);
        Stack<Integer> order = tl.order();
        StringBuilder sb = new StringBuilder();
        while (!order.isEmpty()){
            sb.append(order.pop()).append("->");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
