package src.main.java.data_structure._09_graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BreadthFirstSearch {
    private int count;                      // 记录与s节点相通节点的个数
    private Queue<Integer> waitSearch;      //用来存储待搜索邻接表的点
    private boolean[] marked;               // 用来标记，当前元素是否被搜索

    public BreadthFirstSearch(Graph G, int s){
        // 创建一个和G一样大小的布尔数组, 并填充false
        marked = new boolean[G.V()];
        Arrays.fill(marked, false);
        waitSearch = new ArrayDeque<Integer>();
        // 广度优先搜索
        bfs(G,s);
    }

    // 使用广度优先搜索，找出图G中与v顶点相邻的所有顶点
    private void bfs(Graph G, int v){
        // 先把当前节点置为已搜索
        marked[v] = true;
        // 将节点放入辅助队列
        waitSearch.offer(v);
        // 当辅助队列不为空时，遍历
        while (!waitSearch.isEmpty()){
            // 从辅助队列弹出一个数，count+1
            Integer wait = waitSearch.poll();
            // 接着将key下的，没有被访问的领接表放入辅助队列
            for(Integer adj: G.adj(wait)){
                if(!marked[adj]){
                    bfs(G,adj);
                }
            }
        }
//        相通的点+1
        count++;
    }

    // 判断 k 是否被搜索
    public boolean marked(int k){
        return marked[k];
    }

    // 获取与顶点s相通的所有顶点的总数
    public int getCount(){
        return count;
    }

}
