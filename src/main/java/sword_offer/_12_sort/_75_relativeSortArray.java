package src.main.java.sword_offer._12_sort;

import java.util.Arrays;

public class _75_relativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,1,1,3,3,2,5,1,3};
        int[] arr2 = {3,1,2};
        int[] result = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 使用计数排序
        int[] counts = new int[1001];
        for(int num: arr1){
            counts[num]++; // 记录数组中 num出现的次数
        }

        // 先按指定的数组排序,并排给arr1
        int i=0;
        for(int sortNum:arr2){
            while (counts[sortNum]>0){
                arr1[i++] = sortNum;
                counts[sortNum]--;
            }
        }
        // 再排不按指定数组，递增排序
//        注意，索引才是值
        for (int j = 0; j < counts.length; j++) {
            while (counts[j]>0){
                arr1[i++] = j;
                counts[j]--;
            }
        }
        return arr1;
    }
}
