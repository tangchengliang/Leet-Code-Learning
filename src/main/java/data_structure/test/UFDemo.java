package src.main.java.data_structure.test;

import src.main.java.data_structure._08_uf.UF;
import src.main.java.data_structure._08_uf.UF_tree;
import src.main.java.data_structure._08_uf.UF_tree_weighted;
import src.main.java.data_structure._09_graph.DepthFirstSearch;

import java.util.Scanner;

public class UFDemo {
    public static void main(String[] args) {
//        UF uf = new UF(5);  // 可以同时实验三个
//        UF_tree uf = new UF_tree(5);
        UF_tree_weighted uf = new UF_tree_weighted(5);
        System.out.println("初始默认组数="+uf.count());
        Scanner sc = new Scanner(System.in);

        // 一个死循环，来完成合并操作，并检验组数的变化
        boolean UF_flag = false;
        while (UF_flag){
            System.out.print("请输入p:");
            int p = sc.nextInt();
            System.out.print("请输入q:");
            int q = sc.nextInt();
            // 判断是否在同一个组
            if(uf.connected(p,q)){
                System.out.println(p+" "+q+" 已经在同一组了~~");
                continue;
            }
            uf.union(p,q);
            System.out.println("count = "+uf.count());
        }

        System.out.println("道路连通测试");
/*
 *   总共有20个城市，目前已经修改好了7条道路，问还需要修建多少条道路，才能让这20个城市之间全部相通？
20
7
0 1
6 9
3 8
5 11
2 12
6 10
4 8
*   20: 城市个数，7：已经修好的道路数，接下来每一行，表示道路连通数据
*
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
        System.out.println("还需要修建"+(utw.count()-1)+"道路");
    }
}
