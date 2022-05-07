package src.main.java.data_structure._04_sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 2, 7, 5, 4};
        System.out.println("排序前:" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序前:" + Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        int min;
        int min_index;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i]; //假定当前位置为最小值
            min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];  // 找到另外的最小值
                    min_index = j;
                }
            }
            if(i != min_index) {  // 如果，下标改变，表示最小值改变，则交换
                swap(arr, i, min_index);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
/*
    选择最小值，依次放在左边
 */
