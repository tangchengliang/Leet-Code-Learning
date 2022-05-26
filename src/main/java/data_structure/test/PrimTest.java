package src.main.java.data_structure.test;

import src.main.java.data_structure._09_graph.Edge;
import src.main.java.data_structure._09_graph.EdgeWeightedGraph;
import src.main.java.data_structure._09_graph.PrimMST;

import java.io.*;
import java.util.Queue;

public class PrimTest {
    public static void main(String[] args) throws IOException {
        String filePath = "C:/java_test/Leet-Code-Learning/src/main/java/data_structure/test/grath_data";
        FileInputStream fin = new FileInputStream(filePath);        // 读取到的是int型
        InputStreamReader reader = new InputStreamReader(fin);      // 字节流--->字符流
        BufferedReader buffReader = new BufferedReader(reader);     // 有一个readLine的方法，可以读取一整行的文本，作为字符串返回，
        // 读取节点个数
        int V = Integer.parseInt(buffReader.readLine());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(V);
        // 读取边的个数
        int edgeNumber = Integer.parseInt(buffReader.readLine());
        //循环读取每一条边，并调用addEdge方法
        for (int i = 0; i < edgeNumber; i++) {
            String line = buffReader.readLine();
            int v = Integer.parseInt(line.split(" ")[0]);
            int w = Integer.parseInt(line.split(" ")[1]);
            double weight = Double.parseDouble(line.split(" ")[2]);
            ewg.addEdge(new Edge(v,w,weight));
        }

        //构建PrimMST对象
        PrimMST mst = new PrimMST(ewg);
        //获取最小生成树的边
        Queue<Edge> edges = mst.edges();
        //打印输出
        for (Edge edge : edges) {
            if (edge!=null){
                System.out.println(edge.either() + "-" + edge.other(edge.either()) + "::" +
                        edge.get_weight());
            }
        }
    }
}
