package src.main.java.sword_offer._02_array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？
    请找出所有和为 0 且 不重复 的三元组。

 */
public class _07_threeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        result = threeSum(arr);
        System.out.println(result);
    }

    private static List<List<Integer>> threeSum(int[] arr) {
        // 1. 创建一个list嵌套list的集合来存放结果
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        // 2. 将数组排序
        if (arr.length >= 3) {
            Arrays.sort(arr);
            // 3. 依次固定位置
            int i = 0;
            while (i < arr.length - 2) {
                twoSum(arr, i, result);
                // 4. 计算完后需要去重, 并移动i指针
                int temp = arr[i];
                while (i < arr.length && arr[i] == temp) {
                    i++;
                }
            }
        }
        return result;
    }

    // 计算两数之和，是否 = -num[i]
    private static void twoSum(int[] arr, int i, List<List<Integer>> result) {
        int j=i+1;
        int k = arr.length-1;
        while (j<k){
            if(arr[j]+arr[k]+arr[i]==0){
                // 这里调用asList的方法, 将arr--->List
                result.add(Arrays.asList(arr[i],arr[j],arr[k]));
                // 这里也要去重复
                int temp = arr[j];
                while (arr[j]==temp && j<k){
                    j++;
                }
            }else if(arr[j]+arr[k]+arr[i]<0){
                j++;
            }else {
                k--;
            }
        }
    }
}

/*
    总结:
        3数之和，可以先固定一位数，再使用双指针搜索数据
        注意点：
            （1）避免重复----> while循环遇到相同的值，就跳过
            （2）存放嵌套list，[[], []]---->Arrays.asList(), 将数组转化成List集合的方法
                1）该方法适用于对象型数据的数组（String、Integer...）
                2）该方法不建议使用于基本数据类型的数组（byte,short,int,long,float,double,boolean）
                3）该方法将数组与List列表链接起来：当更新其一个时，另一个自动更新
                4）不支持add()、remove()、clear()等方法

 */
