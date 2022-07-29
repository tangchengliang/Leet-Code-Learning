package src.main.java.sword_offer._08_tree;

import java.util.Stack;

import static src.main.java.sword_offer._08_tree._48_serialize.deserialize;

// 没有左子树的，二叉搜索树
public class _52_increasingBST {
    public static void main(String[] args) {
        String nodeStr = "8,6,5,#,#,7,#,#,10,9,#,#,11,#,#";
        TreeNode root = deserialize(nodeStr);

        TreeNode result = increasingBST(root);
        System.out.println(result.val);
    }

    // 采用中序遍历，找到一个最小值，就将下一个值置为其right
    private static TreeNode increasingBST(TreeNode root) {
        // 使用栈的思想来解决
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode first = null;  // 找到转换后的第一个节点
        TreeNode pre = null;    // 记录之前的节点
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                // 找到最左边的节点
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop(); // 弹出最小的值
            if(pre!=null){
                // 之前的右节点等于它
                pre.right = cur;
            }else {
                // 当pre=null时，说明cur就是first节点
                first = cur;
            }

            // 栈弹出节点
            pre = cur;
            cur.left = null;
            cur = cur.right;
        }
     return first;
    }
}
