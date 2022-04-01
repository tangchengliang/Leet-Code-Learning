package src.main.java.lanqiao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
    /*
        依次加入砝码，与之前的所有值相加减
     */

public class test_12_weight_count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n个砝码

        HashSet<Integer> weight = new HashSet<>(); // 用HashSet来存放称重

        weight.add(sc.nextInt()); //记录添加第一个砝码的重量

        while (n>1){
            int add_weight = sc.nextInt();

            // 使用一个临时的HashSet存储，新增砝码可能的结果
            HashSet<Integer> temp = new HashSet<>();
            //遍历weight，并计算结果
            Iterator<Integer> iterator = weight.iterator();
            while (iterator.hasNext()){
                int t = iterator.next();
                // 两种情况，相加，相减
                temp.add(t+add_weight);
                temp.add(Math.abs(t-add_weight));
            }
            // 将新的重量，添加到weight
            weight.addAll(temp);
            weight.add(add_weight);
            n--;
        }
    // 除去为0的情况
        weight.remove(0);
        System.out.println(weight.size());
        System.out.println(weight);
    }
}
