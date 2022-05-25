package src.main.java.data_structure._09_graph;

import java.util.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Stack<Integer> reversePost;   //使用栈，存储顶点序列

    public DepthFirstOrder(DiGraph g){
        this.marked = new boolean[g.getV()];
        this.reversePost = new Stack<Integer>();

        // 依次遍历每个顶点
        for (int v = 0; v < g.getV(); v++) {
            if(!marked[v]){
                dfs(g, v);
            }
        }
    }

    private void dfs(DiGraph g, int v) {
        // 标记该节点，已被搜索
        marked[v] = true;
        // 遍历该节点的领节点
        for(Integer w: g.get_adj(v)){
            if(!marked[w]){
                dfs(g, w);
            }
        }
        // 当前节点搜索完毕，当前节点进栈
        reversePost.push(v);
    }

    // 获取当前节点的排序
    public Stack<Integer> getReversePost(){
        return reversePost;
    }
}
