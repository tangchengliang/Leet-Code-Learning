package src.main.java.data_structure._06_heap;

import static java.lang.System.arraycopy;

public class HeapSort {

    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private static void swap(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 对source数组中的数据从小到大排序
    public static void sort(Comparable[] source) {
        //1.创建一个比原数组大1的数组
        Comparable[] heap = new Comparable[source.length + 1];
        //2.构造堆
        createHeap(source, heap);
        //3.堆排序
        //3.1定义一个变量，记录heap中未排序的所有元素中最大的索引
        int n = heap.length - 1;
        while (n > 1) {
            //3.2交换heap中索引1处的元素和N处的元素
            swap(heap, 1, n);
            n--;
            //3.3对索引1处的元素在0~N范围内做下沉操作
            sink(heap, 1, n);
        }
        //4.heap中的数据已经有序，拷贝到source中
        System.arraycopy(heap, 1, source, 0, source.length - 1);
    }

    // 根据源数组，构造堆 heap
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        // 1.拷贝数据
        arraycopy(source, 0, heap, 1, source.length);
        // 2.从heap索引的一半处开始倒叙遍历，对得到的每一个元素做下沉操作
        for (int i = heap.length / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    // 在heap堆中，对target处的元素做下沉，范围是0~range
    private static void sink(Comparable[] heap, int target, int range) {
        //1.找出target结点的两个子结点中的较大值
        while (2 * target <= range) {  // 若果没有子节点，2*target > range 就不会进入循环
            int max = 2 * target;   // 默认最大值为左子节点
            //如果存在右子结点
            if (2 * target + 1 <= range) {
                if (less(heap, 2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                }
            }
            //2.如果当前结点的值小于子结点中的较大值，则交换
            if (less(heap, target, max)) {
                swap(heap, target, max);
            }
            //3.更新target的值
            target = max;
        }
    }
}
