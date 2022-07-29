package src.main.java.sword_offer._07_queue;

import java.util.LinkedList;
import java.util.Queue;

public class _43_CBTInsert {
    public static void main(String[] args) {
        AddTree tree = new AddTree();
        TreeNode root = tree.getTreeRoot();
        CBTInsert cbtInsert = new CBTInsert(root);
        int insert_parent = cbtInsert.insert(7);
        int insert_parent2 = cbtInsert.insert(8);
        System.out.println(insert_parent);
        System.out.println(insert_parent2);
    }
}

class CBTInsert {
    private Queue<TreeNode> queue;
    private TreeNode root;

    public CBTInsert(TreeNode root) {
        this.root = root;

        queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode poll = queue.poll();
            queue.offer(poll.left);
            queue.offer(poll.right);
        }
    }

    public int insert(int val) {
        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(val);

        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;

            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }

    public TreeNode getRoot() {
        return this.root;
    }
}


