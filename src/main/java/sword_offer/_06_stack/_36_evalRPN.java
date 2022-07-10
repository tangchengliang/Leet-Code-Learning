package src.main.java.sword_offer._06_stack;

import java.util.Stack;
/*
    根据 逆波兰表示法，求该后缀表达式的计算结果。
    有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */
public class _36_evalRPN {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        int result = evalRPN(tokens);
        System.out.println(result);
    }

    private static int evalRPN(String[] tokens) {
        // 用栈来处理
        Stack<Integer> stack = new Stack<>();
        for (String token:tokens){
            if(isOperate(token)){
                int nums1 = stack.pop();
                int nums2 = stack.pop();
                int calculation = calculate(nums1, nums2, token);
                stack.push(calculation);
            }else {
                // 数字，则存入栈中
                stack.push(Integer.parseInt(token));
            }
        }
        //取出栈中最后一个元素，即为结果值
        return stack.pop();
    }

    private static int calculate(int nums1, int nums2, String token) {
        switch (token){
            case "+":
                return nums1+nums2;
            case "-":
                return nums2-nums1;
            case "*":
                return nums1*nums2;
            case "/":
                return nums2/nums1;
            default:
                return 0;
        }
    }

    private static boolean isOperate(String token) {
        return token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-");
    }
}
