package src.main.java.data_structure._04_sort;

import java.util.Arrays;


public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 2, 7, 5, 4};
        System.out.println("排序前:" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序前:" + Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int insertVal;
        int insert_index;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];  //定义待插入的数
            insert_index = i - 1;
            // while 循环找到待插入的位置
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            while (insert_index >= 0 && insertVal < arr[insert_index]) {
                arr[insert_index + 1] = arr[insert_index]; //没找到合适的位置，后移，即覆盖待插入的数据
                insert_index--;
            }
            // insert_index+1 为待插入位置
            if (insert_index + 1 != i) {
                arr[insert_index + 1] = insertVal;
            }
        }
    }
}

