package src.main.java.sword_offer._07_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _46_rightSideView {
    public static void main(String[] args) {
        AddTree tree = new AddTree();
        TreeNode root = tree.getTreeRoot();
        List<Integer> rightValue = rightSideView(root);
        System.out.println(rightValue);
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightValue = new LinkedList<>();
        if(root==null){
            return rightValue;
        }
        // 使用双队列来记录
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty()){
            TreeNode poll = queue1.poll();
            if(poll.left!=null){
                queue2.offer(poll.left);
            }
            if(poll.right!=null){
                queue2.offer(poll.right);
            }
            if(queue1.isEmpty()){
                rightValue.add(poll.val);
                queue1=queue2;
                queue2 = new LinkedList<>();
            }
        }
        return rightValue;
    }
}
