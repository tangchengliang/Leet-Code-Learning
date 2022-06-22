package src.main.java.sword_offer._04_Linked;

// 双向链表
public class Node {
    public int val;
    public Node pre;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.pre = null;
        this.next = null;
        this.child = null;
    }
}
