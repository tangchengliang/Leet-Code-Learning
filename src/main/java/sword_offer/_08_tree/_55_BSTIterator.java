package src.main.java.sword_offer._08_tree;

import java.util.Stack;

public class _55_BSTIterator {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        BSTIterator bstIterator = new BSTIterator(treeNode);
        while (bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }
}

// 中序遍历，由小到大
class BSTIterator {
    TreeNode cur;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}

// 颠倒的中序遍历，结果由大道小
class ReverseBSTIterator {
    TreeNode cur;
    Stack<TreeNode> stack;

    public ReverseBSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.left;
        return val;
    }
}