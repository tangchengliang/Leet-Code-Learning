package src.main.java.data_structure._09_graph;

import java.util.Stack;

public class TopoLogical {
    private Stack<Integer> order;  // 创建一个栈存放拓扑

    public TopoLogical(DiGraph g){
        // 判断是否有环
        DirectCycle dc = new DirectCycle(g);
        if(!dc.hasCycle()){
            DepthFirstOrder dfs_oder = new DepthFirstOrder(g);
            order = dfs_oder.getReversePost();
        }
    }

    public Stack<Integer> order(){
        return order;
    }

    // 判断是否有环
    public boolean hasCycle(){
        return order==null;
    }
}
