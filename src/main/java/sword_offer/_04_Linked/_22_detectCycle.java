package src.main.java.sword_offer._04_Linked;

public class _22_detectCycle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next = l5;
        l5.next =l6;
        l6.next = l3;
        ListNode result = detectCycle(l1);
        System.out.println("环的起始节点=" + result);

        System.out.println("=========解法二======");
        ListNode result1 = detectCycle1(l1);
        System.out.println("环的起始节点=" + result1);
    }

    private static ListNode detectCycle(ListNode head) {
        // 找到环中的一个点，通过一快一慢，相遇，即是环中的点
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
        // 遍历计算环中节点的个数count
        int count = 1;
        for (ListNode loop = inLoop.next; loop != inLoop; loop = loop.next) {
            count++;
        }
        // p1先移动count, p2和p1同时移动，相遇即是环开始的节点
        ListNode fast = head;
        for(int i=0;i<count;i++){
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            // 注意判断没有环的情况
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                // fast要移动两步
                fast = fast.next;
            }
        }
        return null;
    }

    // 不考虑节点数目的限制
    private static ListNode detectCycle1(ListNode head) {
        // 找到环中的一个点，通过一快一慢，相遇，即是环中的点
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
        // 新建一个0节点
        // todo 模拟一遍这种作法
        ListNode node = new ListNode(0);
        node.next = head;
        while (node!=inLoop){
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }

}
