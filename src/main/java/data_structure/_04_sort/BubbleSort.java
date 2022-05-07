package src.main.java.data_structure._04_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 2, 7, 5, 4};
        System.out.println("排序前:" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序前:" + Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        // 优化：如果一轮下来，一次都没有交换，则说明有序
        boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = true; //默认为true，代表有序，每轮排序，都又可能使其变为有序
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
/*
 * 总结：每一轮确定最后一个元素为最大值
 * 优化
 */
