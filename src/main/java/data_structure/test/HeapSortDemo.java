package src.main.java.data_structure.test;

import src.main.java.data_structure._06_heap.HeapSort;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        Comparable[] arr = {1, 3, 6, -2, 4};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
