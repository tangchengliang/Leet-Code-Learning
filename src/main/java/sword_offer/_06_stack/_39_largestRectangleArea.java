package src.main.java.sword_offer._06_stack;

import java.util.Stack;

/*
    求最大矩形面积：难
    (1)分治法---->超时
    (2)单调栈
 */
public class _39_largestRectangleArea {
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        int maxArea = largestRectangleArea(arr);
        int maxArea1 = largestRectangleArea1(arr);
        System.out.println(maxArea);
        System.out.println(maxArea1);
    }

    private static int largestRectangleArea1(int[] arr) {
        // 单调栈的解法
        int len = arr.length;
        if(len==0){
            return 0;
        }
        if(len==1){
            return arr[0];
        }
        // 为方便计算，在数组的前后增加一个0
        int[] newArr = new int[len+2];
        System.arraycopy(arr,0,newArr,1,len);
        // 创建一个栈，并初始化0，
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxArea = 0;

        // 这里遍历从1开始
        for (int i = 1; i < len + 2; i++) {
            while (newArr[i]<newArr[stack.peek()]){
                // 当当前值小于栈顶时，则进入循环
                int height = newArr[stack.pop()];
                // 因为是单调增排序，故找到目前栈顶的位置，并-1（计算i之前的一个值）
                int width = i-stack.peek()-1;
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        // 注意，当遍历到最后为0时，while循环会一直进行，直到0
        return maxArea;
    }

    private static int largestRectangleArea(int[] arr) {
        return helperArea(arr, 0, arr.length);
    }

    private static int helperArea(int[] arr, int start, int end) {
        if(start==end){
            return 0;
        }
        if(start+1==end){
            return arr[start];
        }
        int minIndex = start;
        // 找到最低的值
        for (int i = start+1; i < end; i++) {
            if(arr[i]<arr[minIndex]){
                minIndex = i;
            }
        }
        int area = (end-start)*arr[minIndex]; //求取面积
        int left = helperArea(arr, start, minIndex);
        int right = helperArea(arr,minIndex+1, end);

        area = Math.max(area, left);
        return Math.max(area, right);
    }
}
