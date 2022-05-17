package src.main.java.data_structure._07_priority_queue;

public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;  // 存储元素的数组
    private int N;      // 记录堆中的元素

    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    // 往队列中插入一个元素
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    // 删除队列中最小的元素
    public T delMin() {
        // 先获取最小元素的值，并和最后一位交换
        T min = items[1];
        swap(1, N);
        // 删除最后一位元素
        items[N] = null;
        N--;
        // 再将1位置处的值下沉
        sink(1);
        return min;
    }

    // 上浮算法，使索引k处的值，处于合适的位置
    private void swim(int k) {
        while (k > 1) {
            if (!less(k / 2, k)) { //如果插入的k小于k/2的值，则交换
                swap(k / 2, k);
            } else {  //如果插入的k大于k/2的值，则退出循环
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
            int min = 2 * k; // 记录小的值得索引
            // 再判断有无右子节点
            if (2 * k + 1 <= N) {
                if (!less(2 * k, 2 * k + 1)) {
                    min = 2 * k + 1;
                }
            }
            // 再判断子节点最大值和当前节点值得大小
            if (less(k, min)) {
                // 如果 k的值小于左右两个子节点，则退出
                break;
            }
            swap(k, min);
            // 变换k值
            k = min;
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
