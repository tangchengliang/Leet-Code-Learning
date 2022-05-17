package src.main.java.data_structure._07_priority_queue;

public class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] items;  // 存储元素的数组
    private int N;      // 记录堆中的元素

    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    // 往队列中插入一个元素
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    // 删除队列中最大的元素
    public T delMax() {
        // 先获取最大元素的值，并和最后一位交换
        T max = items[1];
        swap(1, N);
        // 删除最后一位元素
        items[N] = null;
        N--;
        // 再将1位置处的值下沉
        sink(1);
        return max;
    }

    // 上浮算法，使索引k处的值，处于合适的位置
    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) { //如果插入的k大于k/2的值，则交换
                swap(k / 2, k);
            } else {  //如果插入的k小于k/2的值，则退出循环
                break;
            }
            // 变换k的值
            k /= 2;
        }
    }

    // 下浮算法，使索引k处的值，处于合适的位置
    private void sink(int k) {
        // 先判断有无子节点
        while (2 * k <= N) {
            int max = 2 * k; // 记录大的值得索引
            // 再判断有无右子节点
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                }
            }
            // 再判断子节点最大值和当前节点值得大小
            if(!less(k, max)){
                // 如果 k的值大于左右两个子节点，则退出
                break;
            }
            swap(k, max);
            // 变换k值
            k = max;
        }
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void swap(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
