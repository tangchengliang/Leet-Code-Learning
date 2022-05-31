package src.main.java.sword_offer._02_array._2_arraySum;

import java.util.HashMap;
import java.util.Map;

/*
    寻找只包含0,1且，0和1个数相等的最大连续数组
 */
public class _11_findMaxLength {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1};
        int result = findMaxLength(arr);
        System.out.println(result);
    }

    private static int findMaxLength(int[] arr) {
        int max = 0;
        int sum = 0;
        // key=sum, value=i
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        // 初始sumToIndex
        sumToIndex.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return max;

    }
}
/*
    总结: 和第10题一样，可用累加求和解决，但是需要将0换成-1-------->题目变成，求和为0的最长连续子数组的长度
            同时，用一个hash表来记录
            (1) 前i个数字和为m，前j（j>i）个数字和也为m，则j-i之间数字和为0，长度为j-i
            (2) 同理，当扫描到前j个和为m，需要判断前i(i<j)中是否有和为m的i，
            --->hash表记录从第一位加到当前位key=sum, value=i（当前索引）
 */
