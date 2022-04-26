package src.main.java.leet_code.easy;

import java.util.HashMap;
import java.util.Map;

public class test_0001_两数之和 {
    public static void main(String[] args) {
        int arr[] = {7, 2, 3, 5};
        int target = 9;
        // 方法一
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            // 可以用是否包含这个key来输出
            if(hm.containsKey(target-arr[i])) {
                System.out.println("[" + i + "," + (hm.get(target - arr[i])) + "]");
                break;
            }
        }

        // 方法二
        HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; ++i) {
           if(hm2.containsKey(target-arr[i])){
               System.out.println("["+hm2.get(target-arr[i])+","+i+"]");
               break;
           }
           hm2.put(arr[i],i);
        }

    }
}
/*
    总结：Hash map 的使用
        用key来存值，value来代表索引
 */
