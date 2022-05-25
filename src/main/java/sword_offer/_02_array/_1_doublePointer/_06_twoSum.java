package src.main.java.sword_offer._02_array._1_doublePointer;

import java.util.Arrays;
import java.util.HashMap;

public class _06_twoSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 10};
        int target = 8;
        int[] result = twoSum_0(arr, target);
        System.out.println("暴力枚举 = " + Arrays.toString(result));
        result = twoSum_1(arr, target);
        System.out.println("HashMap = " + Arrays.toString(result));
        result = twoSum_2(arr, target);
        System.out.println("HashMap优化 = " + Arrays.toString(result));
    }


    // 解法1 暴力枚举
    private static int[] twoSum_0(int[] arr, int target) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // 解法2，用 hashMap，键值对,存放数据，再遍历
    private static int[] twoSum_1(int[] arr, int target) {
        // 先将数据存入hashmap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // 值作为key， 索引作为value
            hm.put(arr[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(target - arr[i])) {
                result[0] = i;
                result[1] = hm.get(target - arr[i]);
                break;
            }
        }
        return result;
    }

    // 解法3， hashmap的优化，边存放数据，边检查
    private static int[] twoSum_2(int[] arr, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(hm.containsKey(target-arr[i])){
                // 注意这里，哪一个是第一个数
                result[0] = hm.get(target - arr[i]);   // 是往前找的数，所有，小的数为hm中找到的那个索引
                result[1] = i;
                break;
            }
            hm.put(arr[i], i);
        }
        return result;
    }
}
