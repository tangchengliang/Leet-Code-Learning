package src.main.java.data_structure._09_graph;

import java.util.ArrayDeque;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private ArrayDeque<Edge>[] adj;    // 注意记录边，不再是Integer，而是Edge

    // 创建一个含有v个节点的加权无向图
    public EdgeWeightedGraph(int v){
        this.V = v;
        this.E = 0;
        this.adj = new ArrayDeque[v];
        for (int i=0;i<v;i++){
            adj[i] = new ArrayDeque<Edge>();
        }
    }

    public int getV(){
        return V;
    }

    public int getE(){
        return E;
    }

    public void addEdge(Edge e){
        // 获取边中的一个顶点
        int v = e.either();
        // 获取边中另外一个顶点
        int w = e.other(v);
        // 无向图，所以边 e 需要同时出现在两个顶点的领接表中
        adj[v].offer(e);  // 注意  这里添加的是边
        adj[w].offer(e);
        // 边数+1
        E++;
    }

    public ArrayDeque<Edge> get_adj(int v){
        // 获取边v的所有领点
        return adj[v];
    }

    // 获取图中所有带权的边
    public ArrayDeque<Edge> get_edges(){
        // 创建一个队列  存放所有的边
        ArrayDeque<Edge> all_edges = new ArrayDeque<>();
        // 遍历顶点，拿到每个顶点的领接表
        for(int v=0;v<this.V;v++){
            for(Edge e: get_adj(v)){
                // 因为无向图，每个节点都存储了边，为防止生成重复的边，故做判断
                if(e.other(v)<v){
                    all_edges.offer(e);
                }
            }
        }
        return all_edges;
    }
}
