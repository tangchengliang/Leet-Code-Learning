package src.main.java.sword_offer._08_tree;

import static src.main.java.sword_offer._08_tree._48_serialize.deserialize;

public class _51_maxPathSum {
    public static void main(String[] args) {
        String nodeStr = "-9,4,#,#,20,15,-3,#,#,#,7,#,#";
        TreeNode root = deserialize(nodeStr);
        int maxSum = maxPathSum(root);
        System.out.println(maxSum);
    }

    // 后序遍历，先找到左子树最大值，和右子树最大值
    // 再和经过根节点+左右子树比较大小
    private static int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        maxPathSumDfs(root, maxSum);
        return maxSum[0];
    }

    private static int maxPathSumDfs(TreeNode root, int[] maxSum) {
        if(root==null){
            return 0;
        }
        int[] maxLeftSum = {Integer.MIN_VALUE};
        int left = Math.max(0, maxPathSumDfs(root.left, maxLeftSum));

        int[] maxRightSum = {Integer.MIN_VALUE};
        int right = Math.max(0, maxPathSumDfs(root.right, maxRightSum));

        // 先比较左右子节点的最大值
        maxSum[0] = Math.max(maxLeftSum[0], maxRightSum[0]);
        // 再和根节点的相比较
        maxSum[0] = Math.max(maxSum[0], root.val+left+right);

        // 返回此节点的最大最小值：根节点的值+最大的左右节点值
        return root.val + Math.max(left, right);
    }
}
