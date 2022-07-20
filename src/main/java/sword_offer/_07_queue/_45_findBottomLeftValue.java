package src.main.java.sword_offer._07_queue;

import java.util.LinkedList;
import java.util.Queue;

public class _45_findBottomLeftValue {
    public static void main(String[] args) {
        AddTree tree = new AddTree();
        TreeNode root = tree.getTreeRoot();
        int bottomLeftValue = findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }

    private static int findBottomLeftValue(TreeNode root) {
        // 双队列记录
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        // 每个队列记录一层
        // 第一个队列记录一个数
        queue1.offer(root);
        int result = root.val;
        while (!queue1.isEmpty()) {
            TreeNode poll = queue1.poll();
            if (poll.left != null) {
                queue2.offer(poll.left);
            }
            if (poll.right != null) {
                queue2.offer(poll.right);
            }
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if (!queue1.isEmpty()) {
                    result = queue1.peek().val;
                }
            }
        }
        return result;
    }
}
