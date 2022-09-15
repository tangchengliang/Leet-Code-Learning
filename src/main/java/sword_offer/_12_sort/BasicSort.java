package src.main.java.sword_offer._12_sort;

import java.util.Arrays;

public class BasicSort {
    public static void main(String[] args) {
        BasicSort basicSort = new BasicSort();
        int[] arr = {-1,4, -3, 4, 1, 2, 3};
//        basicSort.quickSort(arr, 0, arr.length-1);
//        basicSort.bubbleSort(arr);
//        basicSort.insertSort(arr);
//        basicSort.mergeSort(arr);
        basicSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 希尔排序
    public void shellSort(int[] arr){
        // 希尔排序 是插入排序的改进，也可用移位法，加入了gap，提高了效率
        int gap = arr.length/2;
        while (gap>0){
            for(int i=gap;i<arr.length;i++){
                int j = i-gap;
                int val = arr[i];
                // 对于每个i，相当于使用插入排序
                while (j>=0 && val<arr[j]){
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                // 最后，交换位置
                if(i!=j+gap){
                    arr[j+gap] = val;
                }
            }
            gap /= 2;
        }
    }

    // 归并排序: 分，治思想
    public void mergeSort(int[] arr){
        if(arr.length == 0){
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
    }

    public void mergeSort(int[] arr, int low, int high, int[] temp){
        if(high<=low){
            return;
        }
        // 分
        int mid = (low+high)/2;
        mergeSort(arr, low, mid, temp);
        mergeSort(arr, mid+1, high, temp);
        // 合
        merge(arr, low, mid, high, temp);

    }

    private void merge(int[] arr, int low, int mid, int high, int[] temp) {
        // 遍历 mid 左右的两个数组，依次放入temp，最后将temp中的数，取出来放在arr中
        int p1 = low;
        int p2 = mid+1; // 注意这里是 mid+1
        int i = low;
        while (p1<=low && p2<=high){
            if(arr[p1]<arr[p2]){
                temp[i++] = arr[p1++];
            }else {
                temp[i++] = arr[p2++];
            }
        }

        // 继续遍历完剩余的数字
        while (p1<=mid){
            temp[i++] = arr[p1++];
        }
        while (p2<=high){
            temp[i++] = arr[p2++];
        }
        // 最后将 temp中的数据移到arr上
        System.arraycopy(temp, low, arr, low, high-low+1);
//        for (int index = low; index <= high; index++) {
//            arr[index] = temp[index];
//        }
    }


    // 插入排序
    public void insertSort(int[] arr){
        /*
            左边有序，右边无序，依次从无序中取出元素插入到左边有序的数组中
            待插入的数 insertVal
            待插入的位置 insertIndex
           不能直接用交换来做，需要向右移动
         */
        for (int i = 1; i < arr.length; i++) {
           int insertVal = arr[i];
           int insertIndex = i-1;

           // 找到待插入位置
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            // 给插入位置赋值
            if(insertIndex+1!=i){
                arr[insertIndex+1] = insertVal;
            }
        }
    }

    // 冒泡排序
    public void bubbleSort(int[] arr){
        /*
            外层循环，每一次确定一个最大数并移到最后面
         */
        // 优化
        boolean flag;
        for(int i=0;i<arr.length-1;i++){
            flag = true;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j+1, j);
                    flag = false;
                }
            }
            if(flag){
                // 如果没有交换，说明有序
                break;
            }
        }
    }

    // 快速排序
    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // 先选取中间值，并分区,并返回中间值最后的索引
            int pivot = quickPartition(arr, start, end);
            // 最后在递归
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private int quickPartition(int[] arr, int start, int end) {
        // 默认选取最后一个值作为中间值
        /*
            使用双指针遍历arr，中间值pivot
            left初始为start-1，用来记录靠右小于pivot的数
            right初始为start，用于记录右边比pivot大的数，找到小于pivot的数将其移到左边，就和++p1交换
                注意：如果第一个就是小于pivot的数，一样交换，不过在swap中，遇到相同索引就不交换
            当p2指向为end时，就用p1+1和end交换
         */
        int left = start - 1;
        for (int right = start; right < end; right++) {
            if (arr[right] < arr[end]) {
                left++;
                swap(arr, left, right);
            }
        }
        // 最后将 left++ 和 end 交换
        left++;
        swap(arr, left, end);
        return left;
    }

    public void swap(int[] arr,int i, int j){
        if(i!=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
