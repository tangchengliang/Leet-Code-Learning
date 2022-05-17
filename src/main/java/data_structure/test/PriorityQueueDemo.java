package src.main.java.data_structure.test;

import src.main.java.data_structure._07_priority_queue.IndexMinPriorityQueue;
import src.main.java.data_structure._07_priority_queue.MaxPriorityQueue;
import src.main.java.data_structure._07_priority_queue.MinPriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        System.out.println("---------最大优先队列——————————");
        MaxPriorityQueue<String> maxpq = new MaxPriorityQueue<>(20);
        for(String s: arr){
            maxpq.insert(s);
        }
        System.out.println(maxpq.size());
        String del;
        while (!maxpq.isEmpty()){
            del = maxpq.delMax();
            System.out.print(del+" ");
        }

        System.out.println();
        System.out.println("---------最小优先队列——————————");
        MinPriorityQueue<String> minpq = new MinPriorityQueue<>(20);
        for(String s: arr){
            minpq.insert(s);
        }
        System.out.println(minpq.size());
        String del_min;
        while (!minpq.isEmpty()){
            del_min = minpq.delMin();
            System.out.print(del_min+" ");
        }

        System.out.println();
        System.out.println("---------索引优先队列——————————");
        IndexMinPriorityQueue<String> index_min_pq = new IndexMinPriorityQueue<>(20);
        for (int i = 0; i < arr.length; i++) {
            index_min_pq.insert(i, arr[i]);
        }
        System.out.println(index_min_pq.size());
        // 获取最小索引值
        System.out.println("最小索引值="+index_min_pq.min_index());
        // 测试修改
        index_min_pq.changeItem(0, "Z");
        int minIndex = -1;
        while (!index_min_pq.isEmpty()){
            minIndex = index_min_pq.delMin();
            System.out.print(minIndex+" ");
        }
    }
}
