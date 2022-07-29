package src.main.java.sword_offer._08_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class dfs_tree {
    public static void main(String[] args) {
        AddTree tree = new AddTree();
        TreeNode root = tree.getTreeRoot();
        List<Integer> result1 = inorderTraversal1(root);
        List<Integer> result2 = inorderTraversal2(root);
        List<Integer> result3 = preorderTraversal1(root);
        List<Integer> result4 = preorderTraversal2(root);
        List<Integer> result5 = postOrderTraversal1(root);
        System.out.println("中序遍历1="+result1);
        System.out.println("中序遍历2="+result2);
        System.out.println("前序遍历3="+result3);
        System.out.println("前序遍历4="+result4);
        System.out.println("后序遍历5="+result5);
    }

    // 中序遍历1，DFS 先遍历左边-->根节点-->右边
    public static List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> nodes = new LinkedList<>();
        inorderDfs(root, nodes);
        return nodes;
    }

    private static void inorderDfs(TreeNode root, List<Integer> nodes) {
        if(root!=null){
            inorderDfs(root.left, nodes);
            nodes.add(root.val);
            inorderDfs(root.right, nodes);
        }
    }

    // 中序遍历2，栈的思想
    public static List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            // 当找到最左子数时
            cur = stack.pop();
            nodes.add(cur.val);
            cur = cur.right;
        }
        return nodes;
    }

    // 前序遍历1，DFS 先遍历根节点-->左-->右
    public static List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> nodes = new LinkedList<>();
        preorderDfs(root, nodes);
        return nodes;
    }

    private static void preorderDfs(TreeNode root, List<Integer> nodes) {
        if (root!=null){
            nodes.add(root.val);
            preorderDfs(root.left, nodes);
            preorderDfs(root.right, nodes);
        }
    }

    // 前序遍历2， 栈迭代的思想
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur  = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                nodes.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            cur = pop.right;
        }
        return nodes;
    }

    // 后序遍历 DFS，先左-->右--->根
    public static List<Integer> postOrderTraversal1(TreeNode root){
        List<Integer> nodes = new LinkedList<>();
        postOrderDfs(root, nodes);
        return nodes;
    }

    private static void postOrderDfs(TreeNode root, List<Integer> nodes) {
        if(root!=null){
            postOrderDfs(root.left, nodes);
            postOrderDfs(root.right, nodes);
            nodes.add(root.val);
        }
    }

    // 后序遍历，栈的思想， 较难
    // 需要记录前一个节点，来判断右节点是否遍历
    public static List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;    // 记录当前节点
        TreeNode pre  = null;   // 记录遍历的上一个节点
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){  // 一直遍历，直到到达最后一个左子节点
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();  // 取出栈顶元素比较， 看是否有右子节点，且右子节点未被遍历，遍历右节点
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
            }else {
                // 没有右子节点，则弹出，并记录它
                stack.pop();
                nodes.add(cur.val);
                pre = cur;
                cur = null; // 因为是最左下的节点，遍历已经完成，所以置位null
            }
        }
        return nodes;
    }
}
