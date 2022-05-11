package src.main.java.data_structure._04_sort;

import java.util.Arrays;

public class MergeSort {
    private static int[] assist;

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前:" + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        //初始化辅助数组
        assist = new int[arr.length];
        // 定义两个变量，为数组最小，最大索引
        int lo = 0;
        int hi = arr.length - 1;
        // 调用重载方法，完成对lo到hi的排序
        mergeSort(arr, lo, hi);
    }

    /*
        对数组a中从lo到hi的元素进行排序
    */
    private static void mergeSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        // 先对lo到hi分成两个组
        int mid = lo+(hi-lo)/2; // 定义分组的中点
        // 分别对每一组进行排序
        mergeSort(arr,lo,mid);
        mergeSort(arr,mid+1,hi);
        // 再将两个数据合并
        merge(arr,lo,mid,hi);

    }

    /*
        对数组lo-mid为一组，mid+1-hi为一组，进行归并排序
    */
    private static void merge(int[] arr, int lo, int mid, int hi) {
        // 定义3个指针
        int p1 = lo;
        int p2 = mid + 1;
        int i = lo;
        // 遍历移动p1和p2指针，找到较小的那个数，依次填入辅助数组
        while (p1 <= mid && p2 <= hi) {
            if (arr[p1] < arr[p2]) {
                assist[i++] = arr[p1++];
            } else {
                assist[i++] = arr[p2++];
            }
        }
        // 如果p1还没走完，则直接依次放入p1后指针的数
        while (p1 <= mid) {
            assist[i++] = arr[p1++];
        }
        // 如果p2还没走完，则直接依次放入p2后指针的数
        while (p2 <= hi) {
            assist[i++] = arr[p2++];
        }
        // 最后将辅助数组中的元素，存放到原始数组中
        for (int index = lo; index <= hi; index++) {
            arr[index] = assist[index];
        }
    }
}

/*
    分治思想：
        1）尽可能的一组数据拆分成两个元素相等的子组，并对每一个子组继续拆分，直到拆分后的每个子组的元素个数是1为止。
        2）将相邻的两个子组进行合并成一个有序的大组；
        3）不断的重复步骤2，直到最终只有一个组为止。
 */