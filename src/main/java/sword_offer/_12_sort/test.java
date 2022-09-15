package src.main.java.sword_offer._12_sort;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[][] arr = {{1,20},{4,5},{8,10},{2,6},{9,12},{15,18}};

        Arrays.sort(arr, (a1, a2)->a2[1]-a1[1]);
        System.out.println(Arrays.deepToString(arr));
    }
}
