package src.main.java.lanqiao.a_2014;

import java.util.Arrays;

/**
 * 由4个不同的数字，组成的一个乘法算式，它们的乘积仍然由这4个数字组成。
 * 比如：
 * 210 x 6 = 1260
 * 8 x 473 = 3784
 * 27 x 81 = 2187
 * 都符合要求。
 * 如果满足乘法交换律的算式算作同一种情况，那么，包含上边已列出的3种情况，一共有多少种满足要求的算式。
 * 请填写该数字，通过浏览器提交答案，不要填写多余内容（例如：列出所有算式）。
 */
public class test_03神奇算式 {
    static int count = 0;

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == j) continue;
                for (int k = 0; k <= 9; k++) {
                    if (i == k || j == k) continue;
                    for (int l = 0; l <= 9; l++) {
                        if (i != l && j != l && k != l) {
                            int src = i * 1000 + j * 100 + k * 10 + l;
                            int x1 = i * (j * 100 + k * 10 + l);
                            int x2 = 0;
                            if ((i * 10 + j) < (k * 10 + l)) {
                                x2 = (i * 10 + j) * (k * 10 + l);
                            }
                            check(src, x1);
                            check(src, x2);
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void check(int src, int x) {
        String s1=src+"";
        String s2=x+"";
        char[] char1=s1.toCharArray();
        char[] char2=s2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        if(new String(char1).equals(new String(char2))){
            count++;
        }
    }
}
