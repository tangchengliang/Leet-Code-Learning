package src.main.java.data_structure.test;

import src.main.java.data_structure._05_tree.BinaryTree;

import java.util.Queue;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        System.out.println("------------基本测试————————————————");
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        System.out.println("默认大小N="+bt.size());
        bt.put(4,"伽罗");
        bt.put(3,"小明");
        bt.put(5,"狼狗");
        bt.put(2,"后裔");
        bt.put(1,"卤蛋");
        bt.put(10,"虞姬");
        System.out.println("N="+bt.size());
        System.out.println("查询第3个的value="+bt.get(3));
        bt.put(3,"明世隐");
        System.out.println("修改第3个的value="+bt.get(3));
        bt.delete(3);
        System.out.println("删除3后，大小N="+bt.size());
        System.out.println("查询第3个的value="+bt.get(3));
        System.out.println("最大键="+bt.getMaxKey());
        System.out.println("最小键="+bt.getMinKey());

        System.out.println("------------遍历测试————————————————");
        BinaryTree<String, String> bt1 = new BinaryTree<>();
        bt1.put("E", "5");
        bt1.put("B", "2");
        bt1.put("G", "7");
        bt1.put("A", "1");
        bt1.put("D", "4");
        bt1.put("F", "6");
        bt1.put("H", "8");
        bt1.put("C", "3");
        Queue<String> pre = bt1.preErgodic();
        System.out.println("--------前序遍历：");
        for(String key: pre){
            System.out.print(key+"="+bt1.get(key)+" ");
        }
        System.out.println();
        System.out.println("--------中序遍历：");
        Queue<String> mid = bt1.midErgodic();
        for(String key: mid){
            System.out.print(key+"="+bt1.get(key)+" ");
        }

        System.out.println();
        System.out.println("--------后序遍历：");
        Queue<String> after = bt1.afterErgodic();
        for(String key: after){
            System.out.print(key+"="+bt1.get(key)+" ");
        }

        System.out.println();
        System.out.println("--------层序遍历：");
        Queue<String> layer = bt1.layerErgodic();
        for(String key: layer){
            System.out.print(key+"="+bt1.get(key)+" ");
        }

    }
}
