package src.main.java.leet_code.sort;

import java.util.Arrays;
import java.util.HashMap;

/*
    给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 */
public class easy_169_多数元素 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int resp = majorityElement(nums);
        System.out.println(resp);
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // 摩尔投票法，求解纵数
    //摩尔投票法,先假设第一个数过半数并设cnt=1；遍历后面的数如果相同则cnt+1，不同则减一，
    // 当cnt为0时则更换新的数字为候选数（成立前提：有出现次数大于n/2的数存在）
    public static int moErVote(int[] nums) {
        int count = 1;
        int major = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==major){
                count++;
            }else {
                count--;
                if(count==0){
                    major = nums[i+1];
                }
            }
        }
        return major;
    }

    public static void hash(int[] nums){
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num: nums){
            if(!counts.containsKey(num)){
                counts.put(num,1);
            }else {
                counts.put(num, counts.get(num)+1); // 会覆盖原来的数
            }
        }
    }
}

/*
 *  摩尔选举法，用于处理众数>n/2的问题
 */
