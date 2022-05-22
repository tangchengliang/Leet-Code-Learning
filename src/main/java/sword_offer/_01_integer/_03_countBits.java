package src.main.java.sword_offer._01_integer;
/*
    问题转换成，如何求一个二进制新式中1的个数
    厉害的点：
        （1）i & (i-1): 将最右边的1变为0，即可统计次数
        （2）i中1的个数比i & (i-1)中多1，可优化计算
        （3）i为偶数，i/2 左移一位，得到i，1的个数不变
            i为奇数，i/2 左移一位，最右边设为1，得到1的个数+1
            注意：解答中，是将i右移>>
 */

import java.util.Arrays;

public class _03_countBits {
    public static void main(String[] args) {
        int num = 5;
        int[] arr = new int[num + 1];  // 记录结果的数组,(0——num, 所以num+1)
        arr = countBits(num);      // 调用计算方法
        System.out.println("方法1="+Arrays.toString(arr));
        arr = countBits2(num);
        System.out.println("方法2="+Arrays.toString(arr));
        arr = countBits3(num);
        System.out.println("方法3="+Arrays.toString(arr));

    }

    private static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);    // 将最右边的1变为0
            }
        }
        return result;
    }

    // 解法二
    private static int[] countBits2(int num) {
        int[] result = new int[num + 1];
        // 这里要从1开始
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;  //i中1的个数比i & (i-1)中多1，可优化计算
        }
        return result;
    }

    // 解法3
    private static int[] countBits3(int num){
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i>>1] + (i&1);
        }
        return result;
    }

}
