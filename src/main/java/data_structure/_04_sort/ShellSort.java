package src.main.java.data_structure._04_sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前:" + Arrays.toString(arr));
        changeShellSort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
        System.out.println("******************");
        int[] arr1 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前:" + Arrays.toString(arr1));
        shiftShellSort(arr1);
        System.out.println("排序后:" + Arrays.toString(arr1));
    }

    // 交换法
    private static void changeShellSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return;
        }
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap 组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        swap(arr, j, j + gap);
                    }
                }
            }
            gap /= 2;
        }
    }

    // 移位法----->交换法，交换代价很高
    public static void shiftShellSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return;
        }
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                // 从第gap个元素，逐个对其所在的组进行直接插入排序
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    // 移动
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // 当退出while 后，就给temp 找到插入的位置
                    arr[j] = temp;
                }
            }
            gap /= 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
 *  插入排序的一种改进，利用gap 减少了计算
 */
