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
    }
}
