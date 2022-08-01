package src.main.java.sword_offer._08_tree;

import java.util.*;

public class _56_findTarget {
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

        boolean result = findTarget2(treeNode, 80);
        System.out.println(result);
    }

    private static boolean findTarget(TreeNode root, int target) {
        // 使用hash表的方法，使用中序遍历
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        // 这里只用保存一个值，因此可用hashSet
        Set<Integer> set = new HashSet<>();
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(set.contains(target-cur.val)){
                return true;
            }
            set.add(cur.val);
            cur = cur.right;
        }
        return false;
    }

    private static boolean findTarget2(TreeNode root, int target) {
        // 使用双指针：55二叉树搜索，54颠倒中序遍历
        BSTIterator iterNext = new BSTIterator(root);
        ReverseBSTIterator iterPre = new ReverseBSTIterator(root);

        int next = iterNext.next();
        int pre = iterPre.next();
        while (next!=pre){
            if(next+pre==target){
                return true;
            }
            if(next+pre>target){
                pre = iterPre.next();
            }else {
                next = iterNext.next();
            }
        }
        return false;
    }
}
