package src.main.java.data_structure._04_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {0,-1,2,0,3};
        System.out.println("排序前:" + Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("排序后:" + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi){
            return;
        }
        // 对arr数组，从lo到hi进行切分
        int partition_index = quickPartition(arr,lo,hi);
        // 左递归
        quickSort(arr, lo, partition_index-1);
        // 右递归
        quickSort(arr, partition_index+1, hi);
    }

    private static int quickPartition(int[] arr, int lo, int hi) {
        int left =lo;
        int right =hi+1;  // 之后的代码有[--r],使它们运行时才可以停留在最后一索引处进行比较，不然会漏掉最后一个
        int pivot = arr[left]; // 选取最左边的值，作为中间值

        while (true) {
            // 开始遍历，右向左，找到一个比pivot 小的值
            while (arr[--right] > pivot) {
                if (right == lo) {  // 如果移动到最左边，还没找到，要退出循环{6，7，8，9，10}
                    break;
                }
            }
            // 再左向右，找到一个比pivot 大的值
            while (arr[++left] < pivot) {
                if (left == hi) {  // 如果移动到最右边，还没找到，要退出循环{6，5，4，3，2}
                    break;
                }
            }
            if (left >= right) {
                // 扫描完所有的元素，结束循环
                // 可能存在的情况: l>r {6，1，2，7，8，9}，也扫描完了，之后交换边界元素即可; l=r,也扫描完毕
                // 扫描完毕，结束循环，之后交换边界值元素
                break;
            } else {
                // 交换索引位置元素
                swap(arr, left, right);
            }
        }
        // 交换分界值元素
        swap(arr,lo,right);
        // 返回边界值
        return right;
        // todo 分界值存在相同元素怎么办，思考一下为什么依旧能排序, debug

    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
 * 快速排序
     * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
     * 则分别对这两部分继续进行排序，直到整个序列有序。
 */