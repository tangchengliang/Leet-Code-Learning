package src.main.java.sword_offer._07_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
    给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
    实现 MovingAverage 类：

    MovingAverage(int size) 用窗口大小 size 初始化对象。
    double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，
    请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。

 */
public class _41_MovingAverage {
    public static void main(String[] args) {
        MovingAverage obj = new MovingAverage(3);
        List<Double> result = new LinkedList<>();
        int[] arr = {3,1,10,3,5};
        for(int i:arr) {
            double next = obj.next(i);
            result.add(next);
        }
        System.out.println(result);
    }
}

class MovingAverage{
    private Queue<Integer> nums;
    private int capacity;
    private int sum;

    public MovingAverage(int size){
        nums = new LinkedList<>();
        capacity = size;
    }

    public double next(int val){
        // 将val加入到队列中
        nums.offer(val);
        sum+=val;
        if(nums.size()>capacity){
            // 队列删除第一个元素，poll可以返回这个值
            sum-=nums.poll();
        }
        return (double)sum/nums.size();
    }
}
