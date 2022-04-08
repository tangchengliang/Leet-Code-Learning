package src.main.java.lanqiao.a_2013;

import java.util.Scanner;

/**
 * 100 可以表示为带分数的形式：100 = 3 + 69258 / 714还可以表示为：100 = 82 + 3546 / 197注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。类似这样的带分数，100 有 11 种表示法。题目要求：
 * 从标准输入读入一个正整数N (N<1000*1000)
 * 程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
 * 注意：不要求输出每个表示，只统计有多少表示法！
 * 例如：
 * 用户输入：100
 * 程序输出：11
 * <p>
 * 用户输入：105
 * 程序输出：6

    总结：
        注意 count++的位置，在check里面，因为一种排列，可能有多个解
 */
public class test_08带分数_全排列 {
    static int arr[] = {1, 2, 3,4,5,6,7,8,9};
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] path = new int[9];
        f(0, arr, N);
        System.out.println(count);
    }

    private static void f(int k, int[] arr, int N) {
        if (k == arr.length) {
           check(arr,N);  // 当排列完成，就进行检查
            return;
        }
        for (int i = k; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            f(k + 1, arr, N);
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    private static void check(int[] arr, int N) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int x1=toInt(arr,0,i);
            if (x1<=N){     // 当x1> N时，就没有计算的必要了
                for (int j = i+1; j < arr.length - 1; j++) {
                    int x2 = toInt(arr, i + 1, j);
                    int x3 = toInt(arr, j + 1, 8);
                    if (N == (x1 + x2 / x3) && x2 % x3 == 0) {
                        count++;  //在这里满足条件就++，不能return，因为一种排列组合可能有多个解
                    }
                }
            }
        }
    }

    public static int toInt(int[] arr, int start, int end) {
        int num = 0;
        int t = 1;
        for (int i = end; i >= start; i--) {
            num = num + arr[i] * t;
            t *= 10;
        }
        return num;
    }
}
