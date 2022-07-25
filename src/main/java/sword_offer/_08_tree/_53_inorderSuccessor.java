package src.main.java.sword_offer._08_tree;

import java.util.Stack;

import static src.main.java.sword_offer._08_tree._48_serialize.deserialize;

public class _53_inorderSuccessor {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(11);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        TreeNode result = inorderSuccessor(treeNode, treeNode);
        System.out.println(result.val);
        TreeNode result2 = inorderSuccessor2(treeNode, treeNode);
        System.out.println(result2.val);
    }

    private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean flag = false;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (flag) {
                break;
            } else if (p == cur) {
                flag = true;
            }
            cur = cur.right;
        }
        return cur;
    }

    private static TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        // 解法二 ，利用二叉树的特性优化
        TreeNode cur = root;
        TreeNode result = null;
        while (cur!=null){
            if(cur.val>p.val){
                result = cur;
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return result;
    }
}
