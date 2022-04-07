package src.main.java.lanqiao.a_2013;

import java.math.BigInteger;

/**
 *   2^11213 - 1 这个数字已经很大(有3000多位)，请你编程求出这个素数的十进制表示的最后100位。
 *   BigInteger
 *   字符串切割 substring
 */
public class test_03大数处理 {
    public static void main(String[] args) {
        BigInteger big = BigInteger.valueOf(2).pow(11213).subtract(BigInteger.ONE);
        String s= big.toString();
        System.out.println(s.length());
        String result = s.substring(s.length()-100);
        System.out.println(result.length());
        System.out.println(result);
    }
}
