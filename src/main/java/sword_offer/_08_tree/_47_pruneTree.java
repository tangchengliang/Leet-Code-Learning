package src.main.java.sword_offer._08_tree;

public class _47_pruneTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(0);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNode result = pruneTree(treeNode1);
        System.out.println(result.val);
    }

    // 需要明确什么时候需要剪枝，（1）左右都为null，且当前节点值为0
    // 由于是后序遍历，所以会先删除左右为0的节点，最后删除根也为0的节点
    private static TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left==null && root.right==null && root.val==0){
            return null; // 删除这个节点
        }
        return root;
    }
}
