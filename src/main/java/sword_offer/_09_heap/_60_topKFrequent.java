package src.main.java.sword_offer._09_heap;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个整数 k ，
 * 请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 */
public class _60_topKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> result = topKFrequent(nums, k);
        System.out.println(result);
    }

    private static List<Integer> topKFrequent(int[] nums, int k) {
        // 使用hash表先获取每个数出现的次数
        Map<Integer, Integer> numsToCount = new HashMap<>();
        for(int num: nums){
            numsToCount.put(num, numsToCount.getOrDefault(num, 0)+1);
        }

        // 遍历hashMap，用一个k大的·最小堆来存放>堆顶的元素
        // 注意修改排序规则comparator
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue()-e2.getValue());

        for(Map.Entry<Integer, Integer> entry: numsToCount.entrySet()){
            if(minHeap.size()<k){
                // 当数量小于k时，直接加入
                minHeap.offer(entry);
            }else {
                if(entry.getValue()>minHeap.peek().getValue()){
                    // 比堆顶大，则加入元素
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: minHeap){
            result.add(entry.getKey());
        }
        return result;
    }
}
