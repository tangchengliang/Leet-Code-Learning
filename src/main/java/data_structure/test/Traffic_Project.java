package src.main.java.data_structure.test;

import src.main.java.data_structure._08_uf.UF_tree_weighted;
import src.main.java.data_structure._09_graph.BreadthFirstSearch;
import src.main.java.data_structure._09_graph.DepthFirstSearch;
import src.main.java.data_structure._09_graph.Graph;

public class Traffic_Project {
    public static void main(String[] args) {
        System.out.println("--------道路连通测试---------");
/*
 *   总共有20个城市，目前已经修改好了7条道路，问还需要修建多少条道路，才能让这20个城市之间全部相通？
20   7
0 1 ,6 9  ,3 8  ,5 11    ,2 12   ,6 10   ,4 8
*   20: 城市个数，7：已经修好的道路数，接下来每一行，表示道路连通数据
* 1.创建一个并查集UF_Tree_Weighted(20);
    2.分别调用union(0,1),union(6,9),union(3,8),union(5,11),union(2,12),union(6,10),union(4,8)，表示已经修建好的
    道路把对应的城市连接起来；
    3.如果城市全部连接起来，那么并查集中剩余的分组数目为1，所有的城市都在一个树中，所以，只需要获取当前并查集中剩余的数目，减去1，就是还需要修建的道路数目；
 */
        UF_tree_weighted utw = new UF_tree_weighted(20);
        utw.union(0,1);
        utw.union(6,9);
        utw.union(3,8);
        utw.union(5,11);
        utw.union(2,12);
        utw.union(6,10);
        utw.union(4,8);
        System.out.println("并查集-->还需要修建"+(utw.count()-1)+"道路");

/*
 *  2. 判断9号城市和10号城市是否相通？9号城市和8号城市是否相通？
 *      2.1.创建一个图Graph对象，表示城市；
        2.2.分别调用 addEdge(0,1),addEdge(6,9),addEdge(3,8),addEdge(5,11),addEdge(2,12),addEdge(6,10),addEdge(4,8)，表示已经修建好的道路把对应的城市连接起来；
        2.3.通过Graph对象和顶点9，构建DepthFirstSearch对象或BreadthFirstSearch对象；
        2.4.调用搜索对象的marked(10)方法和marked(8)方法，即可得到9和城市与10号城市以及9号城市与8号城市是否相通。
 */
        System.out.println("_____图解————————————————————");
        Graph g = new Graph(20);
        g.addEdge(0,1);
        g.addEdge(6,9);
        g.addEdge(3,8);
        g.addEdge(5,11);
        g.addEdge(2,12);
        g.addEdge(6,10);
        g.addEdge(4,8);

        DepthFirstSearch dfs = new DepthFirstSearch(g, 9);
        BreadthFirstSearch bfs = new BreadthFirstSearch(g, 9);
        System.out.println("dfs测9和10是否联通"+dfs.marked(10));
        System.out.println("bfs测9和8是否联通"+bfs.marked(8));
    }
}
