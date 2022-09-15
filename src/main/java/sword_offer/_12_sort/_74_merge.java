package src.main.java.sword_offer._12_sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 合并区间
public class _74_merge {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{4,5},{8,10},{2,6},{9,12},{15,18}};
        int[][] result = merge(arr);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] merge(int[][] arr) {
        // 将区间按左边的数进行递增排序
        Arrays.sort(arr, (a1,a2)->a1[0]-a2[0]);
        /*
            依次取值，判断相邻两端是否有交值,可合并的情况如下
              （1）  arr[i][0]---------arr[i][1]
                          arr[i+1][0]----------arr[i+1][1]    -->可以合并
              （2）   arr[i][0]-----------------------------arr[i][1]
                          arr[i+1][0]----------arr[i+1][1]
        */
        // 用一个新的结果来接收数据，用可变的List
        List<int[]> merge = new LinkedList<>();
        int i=0;
        while (i<arr.length){
            int[] temp = {arr[i][0], arr[i][1]};  // 获取i对应的元素
            int j = i+1;    // 获取i后一个元素
            while (j<arr.length && temp[1]>=arr[j][0]){
                temp[1] = Math.max(temp[1], arr[j][1]);
                j++;
            }
            merge.add(temp);
            i=j;
        }
        int[][] result = new int[merge.size()][];
        return merge.toArray(result);
    }
}
/*
    新知识：lamda表达式处理Comparator    :
    将集合转为数组Array    : merge.toArray(new int[merge.size()][]);
 */
