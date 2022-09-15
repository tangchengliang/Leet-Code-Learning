package src.main.java.sword_offer._12_sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 计数排序：适用于相差不大，但是数据量很大的数据，比如年龄排序
public class countSort {
    public static void main(String[] args) {
        int[] age = {1,2,3,1,1,3,3,2,5,1,3};
        int[] sort = countSortTest(age);
        System.out.println(Arrays.toString(sort));
    }

    private static int[] countSortTest(int[] arr) {
        // 第一步读取元素，找到最大最小值，计算差值，即为辅助数组的长度
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num:arr){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] counts = new int[max-min+1];
        // 第二步,记录counts中对应的数出现了几次
        for(int num:arr){
            counts[num-min]++;
        }

        //第三步，将计数的数组值依次取出，即是结果
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]>0){
                result.add(i+min);
                counts[i]--;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
    由于List中存放的是封装类型，不是基础类型，因此toArray不能直接是基础类型的结果
        两种种 List<Integer> 转为 int数组
        （1）遍历每一个元素，然后放入数组
        （2）使用stream()的方式: result.stream().mapToInt(Integer::intValue).toArray()
 */
