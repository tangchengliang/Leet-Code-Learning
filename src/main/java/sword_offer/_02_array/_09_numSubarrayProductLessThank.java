package src.main.java.sword_offer._02_array;

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
        count = right - left + 1，可以草稿模拟一下******
 */
