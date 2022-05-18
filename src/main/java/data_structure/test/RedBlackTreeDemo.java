package src.main.java.data_structure.test;

import src.main.java.data_structure._05_tree.RedBlackTree;

public class RedBlackTreeDemo {
    public static void main(String[] args) {
        RedBlackTree<Integer, String> bt = new RedBlackTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1,"老三");
        System.out.println(bt.getValue(1));
        System.out.println(bt.size());

    }
}
