package src.main.java.sword_offer._09_heap;

import java.util.*;

public class _61_kSmallestPairs {
    public static void main(String[] args) {
        int[] nums1 = {1,5,13,21};
        int[] nums2 = {2,4,9,15};
        int k = 3;
        List<List<Integer>> result = kSmallestPairs(nums1, nums2, k);
        System.out.println(result);
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 最大堆来实现
        Queue<int[]> maxHeap = new PriorityQueue<>((p1,p2)->p2[0]+p2[1]-p1[0]-p1[1]);

        // 遍历两个数组，最多遍历k次
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if(maxHeap.size()<k){
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                }else {
                    int[] root = maxHeap.peek();
                    if(root[0]+root[1]>nums1[i]+nums2[j]){
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        while (!maxHeap.isEmpty()){
            int[] vals = maxHeap.poll();
            result.add(Arrays.asList(vals[0], vals[1]));
        }
        return result;
    }
}
