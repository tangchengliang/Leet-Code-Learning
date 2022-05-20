package src.main.java.data_structure._09_graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {
    private final int V; //记录顶点数量
    private int E;       // 记录边数
    private ArrayDeque[] adj; // 领接表

    public Graph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new ArrayDeque[v];
        // 初始化领接表中的空队列
        for (int i=0;i<adj.length;i++){
            adj[i] = new ArrayDeque<Integer>();
        }
    }

    // 获取图中顶点的数量
    public int V(){
        return V;
    }

    // 获取图中边的数量
    public int E(){
        return E;
    }

    // 向图中增加一条边 v-w
    public void addEdge(int v, int w){
        //把w添加到v的链表中，这样顶点v就多了一个相邻点w
        adj[v].offer(w);
        //把v添加到w的链表中，这样顶点w就多了一个相邻点v
        adj[w].offer(v);
        // 边数+1
        E++;
    }

//    获取和顶点v相邻的所有顶点
    public ArrayDeque<Integer> adj(int v){
        return adj[v];
    }
}
