package src.main.java.sword_offer._08_tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int k){
        val = k;
    }
}

class AddTree {
    public AddTree() {
    }

    public TreeNode getTreeRoot() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;

        return treeNode;
    }
}
