package src.main.java.sword_offer._05_hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * O(1) 实现元素的插入和删除
 *  用 HashMap  和 ArrayLIst实现
 *  HashMap记录索引， ArrayList记录数据
 *  Array.size获取最后一位元素的索引，                                                                                         插入最后
 *  删除时，也和最后一位元素交换
 */
public class _30_RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(3);
        randomizedSet.insert(4);
        randomizedSet.insert(5);
        randomizedSet.insert(6);

        System.out.println(randomizedSet.getRandom());
        randomizedSet.list();
        randomizedSet.remove(3);
        randomizedSet.list();

    }
}

class RandomizedSet{
    HashMap<Integer, Integer> numToLocation;
    ArrayList<Integer> nums;

    public RandomizedSet(){
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val){
        if(numToLocation.containsKey(val)){
            return false;
        }
        // 将元素插入最后一位
        numToLocation.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val){
        if(!numToLocation.containsKey(val)){
            return false;
        }
        // 将当前元素，与最后一位元素交换, 并删除val和hash中的val
        int temp = nums.get(nums.size()-1);
        int val_index = numToLocation.get(val);
        numToLocation.put(temp, val_index);
        numToLocation.remove(val);

        nums.set(val_index, temp);
        nums.remove(nums.size()-1);
        return true;
    }

    public int getRandom(){
        Random random = new Random();
        int r = random.nextInt(nums.size());
        return nums.get(r);
    }

    public void list(){
        for(Integer num: nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
