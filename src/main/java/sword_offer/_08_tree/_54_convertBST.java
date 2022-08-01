package src.main.java.sword_offer._08_tree;

import java.util.Stack;

public class _54_convertBST {
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

        TreeNode result = convertBST(treeNode);
        System.out.println(result);
    }

    private static TreeNode convertBST(TreeNode root) {
        //使用颠倒中序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum=0;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                // 颠倒的中序遍历，先遍历右子树
                cur = cur.right;
            }
            cur = stack.pop();
            sum+=cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }
}
