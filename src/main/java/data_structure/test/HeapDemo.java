package src.main.java.data_structure.test;

import src.main.java.data_structure._06_heap.Heap;

public class HeapDemo {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(20);
        heap.insert("S");
        heap.insert("G");
        heap.insert("I");
        heap.insert("E");
        heap.insert("N");
        heap.insert("H");
        heap.insert("O");
        heap.insert("A");
        heap.insert("T");
        heap.insert("P");
        heap.insert("R");

        // 通过删除，来遍历堆中的元素，如果，返回是一个顺序，则说明正确
        String del;
        while ((del = heap.delMax()) != null) {
            System.out.print(del + ",");
        }
    }
}

/*
 *  注意类中，构造方法，定义了容量，所有调用的时候，括号要填入值
 */
