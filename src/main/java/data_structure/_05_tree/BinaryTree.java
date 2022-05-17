package src.main.java.data_structure._05_tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    // 记录根节点
    private Node root;
    // 记录树中的元素
    private int N;

    private class Node {
        // 存储键
        public Key key;
        // 存储值
        public Value value;
        // 存储 右子节点
        public Node right;
        // 存储 左子节点
        public Node left;

        // 构造方法
        public Node(Key key, Value value, Node right, Node left) {
            this.key = key;
            this.value = value;
            this.right = right;
            this.left = left;
        }
    }

    // 获取树中元素个数
    public int size() {
        return N;
    }

    // 向树中添加元素 k-v
    public void put(Key key, Value value) {
        // root 表示从头节点开始
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value) {
        // 如果子树为空
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        //如果子树不为空 ----> 比较x节点的键和key的大小
        int cmp = x.key.compareTo(key);
        if (cmp < 0) {
            // 如果key>x节点的键，则继续寻找x节点的右子树
            x.right = put(x.right, key, value);
        } else if (cmp > 0) {
            // 如果key<x节点的键，则继续寻找x节点的左子树
            x.left = put(x.left, key, value);
        } else {
            // 如果key==x节点的键，则替换value
            x.value = value;
        }
        return x;
    }

    // 查找树中指定key的value
    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        // 如果子树为空
        if (x == null) {
            return null;
        }
        int cmp = x.key.compareTo(key);
        if (cmp < 0) {
            // 如果key>x节点的键，则继续寻找x节点的右子树
            return get(x.right, key);
        } else if (cmp > 0) {
            // 如果key<x节点的键，则继续寻找x节点的左子树
            return get(x.left, key);
        } else {
            // 如果key==x节点的键，则替换value
            return x.value;
        }
    }

    // 删除指定key的节点
    public void delete(Key key) {
        root = delete(root, key);
    }

    // 删除指定key的节点，并返回一个新树
    public Node delete(Node x, Key key) {
        // 如果树为空, 如果不存在的key值，到这里就是空，返回null
        if (x == null) {
            return null;
        }
        int cmp = x.key.compareTo(key);
        if (cmp < 0) {
            // 让删除后的新树，成为右子树
            x.right = delete(x.right, key);
        } else if (cmp > 0) {
            x.left = delete(x.left, key);
        } else {
            // 找到了待删除的节点x
            // 1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            if (x.right == null) {
                N--;
                return x.left;
            }
            // 2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点
            if (x.left == null) {
                N--;
                return x.right;
            }
            //3.当前结点的左右子树都存在
            //3.1找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //3.2删除右子树中最小的结点
            Node n = x.right;
            while (n.left.left != null) {
                n = n.left;
            }
            n.left = null;
            // 删除结点的左子树成为最小结点minNode的左子树
            minNode.left = x.left;
            // 删除结点的右子树成为最小结点minNode的左子树
            minNode.right = x.right;
            // 让被删除结点的父节点指向最小结点minNode
            x = minNode;
            // 个数-1
            N--;
        }
        return x;
    }

    // 寻找最小键
    public Key getMinKey() {
        return getMinKey(root).key;
    }

    private Node getMinKey(Node x) {
        if (x == null) {
            return null;
        }
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    // 寻找最大键
    public Key getMaxKey() {
        return getMaxKey(root).key;
    }

    private Node getMaxKey(Node x) {
        if (x == null) {
            return null;
        }
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    // 前序遍历
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new LinkedList<>();
        preErgodic(root, keys);
        return keys;
    }

    public void preErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        //1.把当前结点的key放入到队列中;
        keys.offer(x.key);
        //2.找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        //3.找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    // 中序遍历
    public Queue<Key> midErgodic() {
        Queue<Key> keys = new ArrayDeque<>();
        midErgodic(root, keys);
        return keys;
    }

    private void midErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        // 1.找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left != null) {
            midErgodic(x.left, keys);
        }
        // 2.把当前结点的key放入到队列中;
        keys.offer(x.key);
        // 3.找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    // 后序遍历
    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new ArrayDeque<>();
        afterErgodic(root, keys);
        return keys;
    }

    private void afterErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        // 1.找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left != null) {
            afterErgodic(x.left, keys);
        }
        // 2.找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }
        // 3.把当前结点的key放入到队列中;
        keys.offer(x.key);
    }

    // 层序遍历
    public Queue<Key> layerErgodic() {
//        1.创建队列，存储每一层的结点；
        Queue<Key> keys = new ArrayDeque<>();

        Queue<Node> nodes = new ArrayDeque<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            // 2.使用循环从队列中弹出一个结点：
            Node x = nodes.poll();
            // 2.1获取当前结点的key；
            keys.offer(x.key);
            // 2.2如果当前结点的左子结点不为空，则把左子结点放入到队列中
            if (x.left != null) {
                nodes.offer(x.left);
            }
            // 2.3如果当前结点的右子结点不为空，则把右子结点放入到队列中
            if (x.right != null) {
                nodes.offer(x.right);
            }
        }
        return keys;
    }

    // 树的最大深度
    public int maxDepth() {
        return maxDepth(root);
    }

    // 计算指定节点树的最大深度
    public int maxDepth(Node x) {
        if (x == null) {
            return 0;
        }
        int l_depth = 0;
        int r_depth = 0;
        int max;
        // 计算左子树的最大深度
        if (x.left != null) {
            l_depth = maxDepth(x.left);
        }
        // 计算右子树的最大深度
        if (x.right != null) {
            r_depth = maxDepth(x.right);
        }
        max = l_depth > r_depth ? l_depth + 1 : r_depth + 1;
        return max;
    }
}
