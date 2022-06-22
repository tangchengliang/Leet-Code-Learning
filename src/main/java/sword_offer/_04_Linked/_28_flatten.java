package src.main.java.sword_offer._04_Linked;

public class _28_flatten {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);
        Node n4 = new Node(1);
        Node n5 = new Node(1);
        Node n6 = new Node(1);
        Node n7 = new Node(1);
        Node n8 = new Node(1);
        Node n9 = new Node(1);
        n1.next = n2;n2.next = n3;
        n2.pre = n1;
        n2.child = n5;
        n3.next = n4;
        n3.pre = n2;
        n4.pre = n3;
        n5.next = n6;
        n6.pre=n5;
        n6.next = n7;
        n7.pre = n6;
        n6.child = n8;
        n8.next=n9;
        n9.pre=n8;

        Node result = flatten(n1);
        System.out.println(result);
    }
    // todo 暂时未理解
    private static Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }

    // 递归
    private static Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        while (node!=null){
            Node next = node.next;
            if(node.child!=null){
                Node child = node.child;
                Node childTail = flattenGetTail(node.child);
                node.child = null;
                node.next = child;
                child.pre = node;
                childTail.next = next;
                if(next!=null){
                    next.pre = childTail;
                }
                tail =  childTail;
            }else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }
}
