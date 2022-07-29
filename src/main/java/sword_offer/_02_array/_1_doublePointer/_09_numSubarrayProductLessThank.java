package src.main.java.sword_offer._02_array._1_doublePointer;

public class _09_numSubarrayProductLessThank {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 6};
        int k = 100;
        int count = numSubarrayProductLessThank(arr, k);
        System.out.println(count);
    }

    private static int numSubarrayProductLessThank(int[] arr, int k) {
        int count = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (left <= right && product >= k) {
                product /= arr[left++];
            }
            // 难点在于此
            count += right >= left ? right - left + 1 : 0;
        }
        return count;
    }
}
/*
    注意： 题中是求 连续子组
        和第8题很像，但需要考虑count该如何计数
        相当于，每增加一个数，就往回增加 例如 10 5 1  k=100
                                        在 10 5 的组合有 {5}， {5，10}
                                        那么+1后 组合有 {1}，{1,5}，{1，5,10} = 2-0+1=3
                                    10 5 1 2
                                    + 2 的组合有: {2},{2,1},{2,1,5},{2,1,5,10} = 3-0+1=4
        count = right - left + 1，可以草稿模拟一下******
 */
