package src.main.java.data_structure._09_graph;

import java.util.Stack;

public class DFSPaths {
    private boolean[] marked;
    private int s;          // 起点
    private int[] edgeTo;   // 索引代表当前顶点，值代表从s到当前顶点的上一个顶点

    public DFSPaths(Graph G, int s){
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        dfs_paths(G,s);
    }

    // 使用深度优先搜索找出G图中v顶点的所有相邻顶点
    private void dfs_paths(Graph g, int v) {
        marked[v] = true;
        for(Integer w: g.adj(v)){
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs_paths(g, w);
            }
        }
    }

    // 判断v顶点与s顶点是否存在路径
    public boolean hasPathTo(int v){
        // 如果到达了v点，说明，该点被搜索
        return marked[v];
    }

    // 找出从起点s到顶点v的路径(就是该路径经过的顶点)
    public Stack<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        // 放入栈中，依次弹出
        Stack<Integer> path = new Stack<>();
        // 第一次把当前顶点存进去，然后将x变换为到达当前顶点的前一个顶点edgeTo[x],在把前一个顶点存进
            //去，继续将x变化为到达前一个顶点的前一个顶点，继续存，一直到x的值为s为止，相当于逆推法，最后把s放进去
        for(int x=v; x!=s; x=edgeTo[x]){
            path.push(x);  //把当前顶点放入容器
        }
        // 最后把s节点放入
        path.push(s);
        return path;
    }
}
