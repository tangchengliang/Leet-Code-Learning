package src.main.java.data_structure._09_graph;

import src.main.java.data_structure._07_priority_queue.IndexMinPriorityQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class PrimMST {
    private Edge[] edgeTo;          // 索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private double[] distTo;        // 索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private boolean[] marked;
    private IndexMinPriorityQueue<Double> pq;  // 存放树中顶点与非树中顶点之间的有效横切边

    // 构造方法, 根据一副加权无向图，创建最小生成树计算对象；
    public PrimMST(EdgeWeightedGraph G){
        //创建一个和图的顶点数一样大小的Edge数组，表示边
        this.edgeTo = new Edge[G.getV()];
        //创建一个和图的顶点数一样大小的double数组，表示权重，并且初始化数组中的内容为无穷大，无穷大即表示不存在这样的边
        this.distTo = new double[G.getV()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        //创建一个和图的顶点数一样大小的boolean数组，表示当前顶点是否已经在树中
        this.marked = new boolean[G.getV()];
        //创建一个和图的顶点数一样大小的索引优先队列，存储有效横切边
        this.pq = new IndexMinPriorityQueue<>(G.getV());

        //默认让顶点0进入树中，但0顶点目前没有与树中其他的顶点相连接，因此初始化distTo[0]=0.0
        distTo[0] = 0.0;
        // 使用顶点0和权重0初始化pq
        pq.insert(0,0.0);
        // 遍历有效边队列
        while (!pq.isEmpty()){
            // 找到权重最小的横切边对应的顶点，加入到最小生成树中
            visit(G, pq.delMin());
        }
    }

    // 将顶点v添加到最小生成树中，并且更新数据
    private void visit(EdgeWeightedGraph G, int v){
        //把顶点v添加到树中
        marked[v] =true;
        //遍历顶点v的邻接表,得到每一条边Edge e,
        for(Edge e: G.get_adj(v)){
            //边e的一个顶点是v，找到另外一个顶点w
            int w = e.other(v);
            //检测是否已经在树中，如果在，则继续下一次循环，
            // 如果不在，则需要修正当前顶点w距离最小生成树的最小边edgeTo[w]以及它的权重distTo[w]，还有有效横切边也需要修正
            if(marked[w]){
                continue;
            }

            //如果v-w边e的权重比目前distTo[w]权重小，则需要修正数据
            if(e.get_weight()<distTo[w]){
                //把顶点w距离最小生成树的边修改为e
                edgeTo[w] = e;
                //把顶点w距离最小生成树的边的权重修改为e.weight()
                distTo[w] = e.get_weight();
                //如果pq中存储的有效横切边已经包含了w顶点，则需要修正最小索引优先队列w索引关联的权重值
                if(pq.contains(w)){
                    pq.changeItem(w, (double) e.get_weight());
                }else{
                    //如果pq中存储的有效横切边不包含w顶点，则需要向最小索引优先队列中添加v-w和其权重值
                    pq.insert(w, (double) e.get_weight());
                }
            }
        }
    }

    // 获取最小生成树的所有边
    public Queue<Edge> edges(){
        //创建队列
        Queue<Edge> edges = new ArrayDeque<>();
        //遍历edgeTo数组，找到每一条边，添加到队列中
        for (int i = 0; i < marked.length; i++) {
            if(edgeTo[i]!=null){
                edges.offer(edgeTo[i]);
            }
        }
        return edges;
    }
}
