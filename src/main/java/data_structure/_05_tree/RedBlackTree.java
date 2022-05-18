package src.main.java.data_structure._05_tree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;         // 根节点
    private int N;             // 记录元素个数
    private static final boolean RED = true;        // 红色链接
    private static final boolean BLACK = false;     // 黑色链接

    // 节点类
    private class Node {
        public Key key;         // 存储键
        public Value value;     // 存储值
        public Node left;       // 存储左子节点
        public Node right;      // 存储右子节点
        public boolean color;   // 由其父节点指向它的链接的颜色

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    // 判断当前结点的父指向链接是否为红色
    private boolean isRed(Node x) {
        // 空节点，默认是黑色链接
        if (x == null) {
            return false;
        }
        // 非空节点需要判断节点color属性值
        return x.color == RED;
    }

    // 左旋调整
    private Node rotateLeft(Node h) {
        // 找出当前节点的右子节点，记为x
        Node x = h.right;
        // 将 x 的左子节点成为h的右子节点
        h.right = x.left;
        // 让 x 成为h的左子节点
        x.left = h;
        // 让x节点的color属性 = h结点的color
        x.color = h.color;  // 就是节点往上，例如竖线
        // 让 h节点的color属性，变为红色
        h.color = RED;
        // 返回当前节点的右子节点
        return x;
    }

    // 右旋调整
    private Node rotateRight(Node h) {
        // 找到h结点的右子节点，记为x
        Node x = h.left;
        // 让x节点的右子结点成为h结点的左子节点
        h.left = x.right;
        // 让 h 成为 x 的右子结点
        x.right = h;
        // 让 x 的color属性 = h的color属性
        x.color = h.color;  // 就是节点往上，例如竖线
        // 让h节点的color，变为红色
        h.color = RED;
        // 返回当前节点的左子节点
        return x;
    }

    //颜色反转，相当于拆分4-结点
    private void flipColors(Node h) {
        // 让当前节点变为红色
        h.color = RED;
        // 左右子节点变为黑色即可
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // 在整个树上完成插入操作
    public void put(Key key, Value value) {
        root = put(root, key, value);
        // 将根节点的颜色变为BLACK
        root.color = BLACK;
    }

    // 在整个树上完成插入操作，并返回一个新树
    private Node put(Node h, Key key, Value value) {
        // 如果为空，直接返回一个红色节点
        if (h == null) {
            N++;  // 注意  添加都是在为空时添加成功的，所以只在这里N++即可
            //标准的插入操作，和父结点用红链接相连
            return new Node(key, value, null, null, RED);
        }
        // 则遍历找到插入节点的位置
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            // key < h.key,则往左寻找
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            // key > h.key,则往右寻找
            h.right = put(h.right, key, value);
        } else {
            // key = h.key ，则替换当前值
            h.value = value;
        }
        // 左旋
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        // 右旋
        if (isRed(h.left) && isRed(h.left.left)) {
           h = rotateRight(h);
        }
        // 反转
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }

    // 根据Key，从树中找出对应的值
    public Value getValue(Key key) {
        return getValue(root, key);
    }

    // 从指定的树中，找到Key对应的值
    private Value getValue(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // key < h.key,则往左寻找
            return getValue(x.left, key);
        } else if (cmp > 0) {
            // key > h.key,则往右寻找
            return getValue(x.right, key);
        } else {
            // key = h.key ，则输出Value
            return x.value;
        }
    }

    // 获取树中元素的个数
    public int size() {
        return N;
    }
}


