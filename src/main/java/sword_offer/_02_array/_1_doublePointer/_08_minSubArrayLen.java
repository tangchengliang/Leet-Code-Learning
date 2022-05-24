package src.main.java.sword_offer._02_array._1_doublePointer;

/*
    求解：最短 区间 之和 <= 给定值
 */
public class _08_minSubArrayLen {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 7};
        int k = 7;
        int min = minSubArrayLen(arr, k);
        System.out.println(min);
    }

    // 双指针
    private static int minSubArrayLen(int[] arr, int k) {
        int left = 0;     //左指针
        int sum = 0;      // right——left之间的值
        int min = Integer.MAX_VALUE;
        // 右指针依次遍历数组，递增
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (left <= right && sum >= k) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            }
        }
        // 使用条件表达式优化代码
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
/*
    注意：
        （1）还要考虑不存在时，返回0的情况
        （2）条件表达式，优化代码；还可以检验是否有改动的情况
        （3）双指针循环遍历时，可用一个指针（左指针）充当遍历的i
 */
