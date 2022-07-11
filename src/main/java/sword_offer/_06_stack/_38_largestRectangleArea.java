package src.main.java.sword_offer._06_stack;

public class _38_largestRectangleArea {
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        int maxArea = largestRectangleArea(arr);
        System.out.println(maxArea);
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
