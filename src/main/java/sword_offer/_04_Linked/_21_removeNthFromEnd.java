package src.main.java.sword_offer._04_Linked;

/**
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class _21_removeNthFromEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        SingleListLinked s = new SingleListLinked();
        s.addNode(l1);
        s.addNode(l2);
        s.addNode(l3);
        s.addNode(l4);
        s.addNode(l5);
        s.list();
        int n = 3;
        ListNode result = removeNthFromEnd(l1, 3);
        System.out.println("删除倒数" + n + "未后");
        s.list();
        System.out.println("返回的" + result + "头节点");
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpy = new ListNode(0); //重新建立一个0节点作为辅助节点
        // 将辅助头节点，和传入的节点连接起来
        dumpy.next = head;
        // 使用双指针，双指针之间的间隔为n
        ListNode left = dumpy;
        ListNode right = head;
        // 先将右指针移动n次，
        // 注意如果移动还未n次，就到达null，说明长度不够,在while中实现
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        // 接着同时移动两个指针
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dumpy.next;
    }
}

/*
    总结：只遍历一次，利用****双指针作为窗口****
    首先让右指针先移动k位，然后同时移动两个指针
    最后一个指针为null时，窗口的另外一个指针即为倒数第k个指针
 */
