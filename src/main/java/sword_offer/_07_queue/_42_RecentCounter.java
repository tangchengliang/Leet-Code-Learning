package src.main.java.sword_offer._07_queue;

import java.util.LinkedList;
import java.util.Queue;

public class _42_RecentCounter {
    public static void main(String[] args) {

    }
}

class RecentCounter{
    private Queue<Integer> times;
    private int windowSize;

    public RecentCounter(int size){
        times = new LinkedList<>();
        windowSize = size;
    }

    public int ping(int time){
        times.offer(time);
        if(time-times.peek()>windowSize){
            times.poll();
        }
        return times.size();
    }
}
