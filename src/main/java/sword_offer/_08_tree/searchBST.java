package src.main.java.sword_offer._08_tree;

import java.util.List;

import static src.main.java.sword_offer._08_tree._48_serialize.deserialize;

// 二叉搜索树，按节点递增遍历，------>中序遍历, 找到与val相等的节点
public class searchBST {
    public static void main(String[] args) {
        String nodeStr = "8,6,5,#,#,7,#,#,10,9,#,#,11,#,#";
        TreeNode root = deserialize(nodeStr);

        TreeNode result = searchBSTTest(root, 5);
        System.out.println(result.val);
    }

    private static TreeNode searchBSTTest(TreeNode root, int k) {
        TreeNode cur = root;
        while (cur!=null){
            if(cur.val==k){
                break;
            }
            if(cur.val<k){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return cur;
    }
}
