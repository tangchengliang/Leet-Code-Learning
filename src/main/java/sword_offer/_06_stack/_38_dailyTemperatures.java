package src.main.java.sword_offer._06_stack;

import java.util.Arrays;
import java.util.Stack;

/*
    请根据每日 气温 列表 temperatures ，重新生成一个列表，
    要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
    如果气温在这之后都不会升高，请在该位置用 0 来代替。

 */
public class _38_dailyTemperatures {
    public static void main(String[] args) {
        int[] arr = {35,31,33,36,34};
        int[] result = dailyTemperatures(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] dailyTemperatures(int[] arr) {
        // 栈中存放，元素的索引，
        // 新加入的元素大于栈顶，则（索引）入栈，并将低温pop出来，索引之差，即天数之差
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i]>arr[stack.peek()]) {
                // 如果当前温度大于栈顶温度，则低温出栈，高温入栈
                int lowIndex = stack.pop();
                // 低温的索引，与当前索引之差，即相隔天数
                result[lowIndex] = i-lowIndex;
                }
            stack.push(i);
            }
        return result;
    }
}
