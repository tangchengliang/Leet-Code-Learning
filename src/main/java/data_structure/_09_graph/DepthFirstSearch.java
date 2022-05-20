package src.main.java.data_structure._09_graph;

public class DepthFirstSearch {
    private boolean[] marked;    // 标记当前顶点，是否被搜索
    private int count;          // 记录右多少个顶点与s顶点相同
    
    public DepthFirstSearch(Graph G, int s){
        // 创建一个与图顶点数量一样大小的布尔数组
        this.marked = new boolean[G.V()];
        // 搜索G图中与s顶点想通的所有顶点
        dfs(G,s);
    }

    //使用深度优先搜索找出G图中v顶点的所有相邻顶点
    private void dfs(Graph G, int v) {
        // 把当前顶点标记为已搜索
        marked[v] = true;
        // 遍历v的领接表，得到每一个顶点w
        for (Integer w: G.adj(v)){
            // 如果当前节点未被搜索，则递归
            if(!marked[w]){
                dfs(G,w);
            }
        }
        // 想通数量+1
        count++;
    }

    // 判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }

    // 获取与顶点s相通的所有顶点的总数
    public int count(){
        return count;
    }
}
