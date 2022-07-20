package src.main.java.sword_offer._07_queue;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _44_largestValues {
    public static void main(String[] args) {
        AddTree tree = new AddTree();
        TreeNode root = tree.getTreeRoot();
        List<Integer> result1 = largestValues1(root);
        List<Integer> result2 = largestValues2(root);
        System.out.println(result1);
        System.out.println(result2);
    }

    // 用一个队列实现二叉树的广度优先搜索
    // 注意每一层，何时遍历完，使用一个计数器
    // current记录当前层位于队列中的数目，初始化只有一个根节点，因此设置为1，当current=0时，表示当前层的节点遍历完毕
    // next记录下一层中位于队列中节点的数目，初始设为0
    public static List<Integer> largestValues1(TreeNode root){
        if(root==null){
            return new LinkedList<>();
        }
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> tree = new LinkedList<>();
        int current = 1;
        int next = 0;
        int maxValue = Integer.MIN_VALUE;
        // 开始遍历树节点
        tree.offer(root);
        while (!tree.isEmpty()){
            TreeNode poll = tree.poll();
            current--;
            maxValue = Math.max(poll.val, maxValue);
            if(poll.left!=null){
                tree.offer(poll.left);
                next++;
            }
            if(poll.right!=null){
                tree.offer(poll.right);
                next++;
            }
            if(current==0){
                current=next;
                next = 0;
                result.add(maxValue);
                maxValue = Integer.MIN_VALUE; // 将最小值还原
            }
        }
        return result;
    }

    // 两个队列，每个队列存一层的值
    public static List<Integer> largestValues2(TreeNode root){
        if(root==null){
            return new LinkedList<>();
        }
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        int maxValue = Integer.MIN_VALUE;
        while (!queue1.isEmpty()){
            TreeNode poll = queue1.poll();
            maxValue = Math.max(maxValue, poll.val);
            if(poll.left!=null){
                queue2.offer(poll.left);
            }
            if(poll.right!=null){
                queue2.offer(poll.right);
            }
            if(queue1.isEmpty()){
                result.add(maxValue);
                maxValue = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }
}

