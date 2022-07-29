package src.main.java.sword_offer._08_tree;

import java.util.LinkedList;
import java.util.List;

import static src.main.java.sword_offer._08_tree._48_serialize.deserialize;

public class _49_sumNumbers {
    public static void main(String[] args) {
        String nodeStr = "3,9,5,#,#,1,#,#,0,#,2,#,#";
        TreeNode root = deserialize(nodeStr);

        int sum = sumNumbers(root);
        System.out.println(sum);
    }

    /*
        1)每次从根节点开始，先左后右递归，--->前序遍历
        2）遇到叶子节点，才将值保存
        3）遇到叶子节点时，要记录path
     */
    private static int sumNumbers(TreeNode root) {
        return dfsNum(root, 0);
    }

    private static int dfsNum(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        path = path * 10 + root.val;
        if(root.left==null && root.right==null){
            System.out.println(path);
            return path;
        }
        return dfsNum(root.left, path) + dfsNum(root.right, path);
    }
}
