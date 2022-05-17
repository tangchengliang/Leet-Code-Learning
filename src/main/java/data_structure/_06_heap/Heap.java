package src.main.java.data_structure._06_heap;

// 用泛型记录元素，继承Comparable接口，给堆中元素加入比较规则
public class Heap<T extends Comparable<T>> {
    // 存储堆中的元素
    private T[] items;
    // 记录元素个数
    private int N;

    public Heap(int capacity) {
        // 构造方法，创建容量为capacity的Heap对象
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    // 判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    // 交换i和j处的值
    private void swap(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // 插入元素
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    // 使用上浮法，使索引k处的元素回到正确的位置
    private void swim(int k) {
        // 通过循环，不断比较当前节点和其父节点的值，如果比父节点值大，就交换元素
        while (k > 1) {
            if (less(k / 2, k)) {
                swap(k / 2, k);
            }else {
                break;
            }
            k = k / 2;
        }
    }

    // 删除堆中对打的元素，并返回这个最大元素
    public T delMax() {
        // 根节点和最右侧值交换
        T max = items[1];
        swap(1, N);
        // 删除最大索引处元素
        items[N] = null;
        // 元素--
        N--;
        sink(1);
        return max;
    }

    // 使用下沉算法，使索引k处的元素回到正确的位置
    private void sink(int k) {
        // 如果当前是最底层就不用循环了
        while (2 * k <= N) {
            int max;
            if(2*k+1<=N){ // 存在右子节点
                if(less(2*k, 2*k+1)){
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }
            }else { // 不存在右子节点
                max = 2*k;
            }
            // 比较当前结点和子结点中的较大者，如果当前结点不小，则结束循环
            if(!less(k, max)){
                break;
            }
            // 当前节点小
            swap(k, max);
            k=max;
        }
    }
}
