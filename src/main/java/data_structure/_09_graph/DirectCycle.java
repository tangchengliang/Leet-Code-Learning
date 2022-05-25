package src.main.java.data_structure._09_graph;

/*
    判断图中是否形成环
 */
public class DirectCycle {
    private boolean[] marked;
    private boolean hasCycle;
    private boolean[] onStack;   // 使用栈的思想来模拟，当前顶点是否处于正在搜索的路径上，判断完一个顶点之后，要恢复为原值

    public DirectCycle(DiGraph g){
        this.marked = new boolean[g.getV()];
        this.hasCycle = false;
        this.onStack = new boolean[g.getV()];

        // 对 G 中的每个顶点都要执行递归操作
        for (int v = 0; v < g.getV(); v++) {
            if(!marked[v]){
                dfs(g, v);
            }
        }
    }

    private void dfs(DiGraph g, int v) {
        // 将顶点标记为已扫描
        marked[v] = true;
        // 将该点入栈
        onStack[v] = true;
        // 扫描 v 指向的领接点
        for(Integer w: g.get_adj(v)){
            if(!marked[w]){
                dfs(g, w);
            }
            //如果顶点w已经被搜索过，则查看顶点w是否在栈中，
            //如果在，则证明图中有环，修改hasCycle标记，结束循环
            if(onStack[w]){
                hasCycle = true;
                return;
            }
        }
        //当前顶点已经搜索完毕，让当前顶点出栈
        onStack[v] = false;
    }

    // 判断是否有环
    public boolean hasCycle(){
        return hasCycle;
    }
}

/*
    在API中添加了onStack[] 布尔数组，索引为图的顶点，当我们深度搜索时：
        1. 在如果当前顶点正在搜索，则把对应的onStack数组中的值改为true，标识进栈；
        2. 如果当前顶点搜索完毕，则把对应的onStack数组中的值改为false，标识出栈；
        3. 如果即将要搜索某个顶点，但该顶点已经在栈中，则图中有环；
 */
