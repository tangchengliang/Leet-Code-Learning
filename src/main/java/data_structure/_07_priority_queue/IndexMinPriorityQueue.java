package src.main.java.data_structure._07_priority_queue;

import java.util.Arrays;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] items;  // 存储元素的数组
    private int N;      // 记录堆中的元素
    private int[] pq;   // 保存每个元素在items数组中的索引
    private int[] qp;   // 保存pq 的逆序，pq值作为索引，pq的索引作为值

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];

        // 默认情况下，没有元素，qp为-1
        Arrays.fill(qp, -1);
    }

    // 往队列中插入一个元素
    public void insert(int i, T t) {
        // 如果索引i处已经存在元素，则不插入
        if(contains(i)){
            throw new RuntimeException("该索引已存在");
        }
        // 个数+1
        N++;
        // 把元素存放在items中
        items[i] = t;
        // 使用pq存放这个索引
        pq[N] = i;
        // 在qp的i索引处存放N
        qp[i] = N;
        // 上浮items[pq[N]],让pq堆有序
        swim(N);
    }

    // 判断k对应得元素，是否存在
    public boolean contains(int k) {
        // 默认情况下，qp所有元素都为-1.
        return qp[k] != -1;
    }

    // 修改索引i 处的元素为t
    public void changeItem(int i, T t) {
        // 修改items数组中索引i处的值为t
        items[i] = t;
        // 找到i在pq中的位置
        int k = qp[i];
        // 对pq[k]做下沉
        sink(k);
        // 对pq[k]做上沉
        swim(k);
    }

    // 最小元素关联的索引
    public int min_index() {
        // pq 的1处存放最小的索引
        return pq[1];
    }

    // 删除索引i关联的元素
    public void delete(int i) {
        // 找出i在pq中的索引
        int k = qp[i];
        // 把pq中索引k处的值和索引N处的值交换
        swap(k,N);
        // 删除qp中索引pq[N]处的值
        qp[pq[N]] = -1;
        // 删除pq中索引N处的值
        pq[N] = -1;
        // 删除items中索引i处的值
        items[i] = null;
        // 元素-1
        N--;
        // 对pq[k]做下沉
        sink(k);
        // 对pq[k]做上沉
        swim(k);
    }

    // 删除队列中最小的元素
    public int delMin() {
        // 找到items中最小元素的索引
        int minIndex = pq[1];
        // 交换pq中索引1处的值和N处的值
        swap(1,N);
        // 删除qp中索引pq[N]处的值
        qp[pq[N]] = -1;
       // 删除pq中索引N的值
        pq[N] = -1;
        // 删除items中最小的元素
        items[minIndex] = null;
        // 元素-1
        N--;
        // 对pq[1]做下沉，让堆有序
        sink(1);
        return minIndex;
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

    // 判断堆中索引i,j对应元素的大小
    private boolean less(int i, int j) {
        // 先通过pq找出items中的索引，然后再找出items中的元素进行对比
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    // 交换堆中i索引，和j索引处的值
    private void swap(int i, int j) {
        // 先交换pq数组中的值
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        // 更新qp数组中的值
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
