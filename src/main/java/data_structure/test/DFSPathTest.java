package src.main.java.data_structure.test;

import src.main.java.data_structure._09_graph.DFSPaths;
import src.main.java.data_structure._09_graph.Graph;

public class DFSPathTest {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0,2);
        g.addEdge(0,1);
        g.addEdge(2,1);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(3,4);
        g.addEdge(0,5);

        int s = 0;
        int d = 4;
        DFSPaths dfsPaths = new DFSPaths(g,s);
        System.out.println(s+"与"+d+"相通吗："+dfsPaths.hasPathTo(d));
        // 遍历打印
        StringBuilder sb = new StringBuilder();
        if(dfsPaths.hasPathTo(d)) {
            for (Integer path : dfsPaths.pathTo(d)) {
                sb.append(path).append("-->");
            }
        }
        sb.delete(sb.length()-3,sb.length());
        System.out.println(s+"到"+d+"的dfs路径为："+sb);
    }
}
