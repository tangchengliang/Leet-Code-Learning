package src.main.java.sword_offer._12_sort;

public class _76_findKthLargest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int result = findKthLargest(arr, 3);
        System.out.println(result);
    }

    private static int findKthLargest(int[] arr, int k) {
        // 使用快速排序中的  partition 来做
        // 第k大的数：index = arr.length-k;
        int target = arr.length-k;
        int left = 0;
        int right = arr.length-1;
        int index = partition(arr, left, right);
        while (index!=target){
            if(index<target){
                left = index +1;
            }else {
                right = index-1;
            }
            index = partition(arr, left, right);
        }
        return arr[index];
    }

    private static int partition(int[] arr, int left, int right) {
        // 默认最后一个是中间值
        // 定义两个指针
        int start = left-1;
        int end = left;
        for (;end<right;end++){
            if(arr[end]<arr[right]){
                start++;
                swap(arr, start, end);
            }
        }
        // 最后交换start right
        start++;
        swap(arr, start, right);
        return start;

    }
    public static void swap(int[] arr, int i, int j){
        if(i==j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
