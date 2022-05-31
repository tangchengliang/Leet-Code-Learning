package src.main.java.sword_offer._02_array._2_arraySum;

import java.util.HashMap;
import java.util.Map;

/*
    对于双指针，无法处理含有负数、零的数组，
    因此--->利用前缀和求解
 */
public class _10_subarraySum {
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int k=2;
        int count = subarraySum(arr, k);
        System.out.println(count);
    }

    private static int subarraySum(int[] arr, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        // 默认初始和为0，出现次数记为1
        sumToCount.put(0,1);
        int sum=0;
        int count=0;
        for(int num: arr){
            sum+=num;
            count += sumToCount.getOrDefault(sum-k,0);
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
/*
    思想：当扫描到数组的第i个数字，并求得前i个数字之和是x时，
        需要知道在i之前存在多少个j，并且目前j个数字之和等于x-k
        因此，对于每个i，纪要保存前i个数字之和，还要保存每个和出现的次数

     总结：要求某个区间的和的时候，就可以用末尾的前缀和减去区间开始位置的前缀和即可。
            count加上，之前和中可能存在的结果
            hash表：key=sum, value=count
 */
