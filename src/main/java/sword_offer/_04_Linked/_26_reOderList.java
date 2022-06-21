package src.main.java.sword_offer._04_Linked;

// 注意本文不是返回值，而是直接改变链表
public class _26_reOderList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
        SingleListLinked s = new SingleListLinked();
        reOderList(l1);
        System.out.println("显示链表");
        s.list(l1);

    }

    /**
     * 思路：将链表对半分，后半链表反转，再用新链表依次添加两个链表的值
     *  对半分---> 找到中间节点 ---->快慢指针
     *  注意: 奇偶节点
     *      奇数：1,2,3,4,5  ->3
     *      偶数：1,2,3,4    ->2
     *      记录不包括中间节点的，后半节点，用于反转
     * @param head
     * @return ListNode
     */
    private static void reOderList(ListNode head) {
        if(head.next==null){
            return;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast!=null){
            // 先移动fast，看是否到达null
            fast = fast.next;
            if(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        // 记录后半链表, 并反转
        ListNode halfList = slow.next;
        halfList = reverseList(halfList);
        // 记录前半链表，即dummy
        slow.next = null;
        // 连接节点
        addLink(head, halfList, head);

    }

    private static void addLink(ListNode node1, ListNode node2, ListNode head) {
        // 需要在理解一下这道题
        ListNode pre = head;
        while (node1!=null && node2!=null){
            // 中间节点尝试保留该节点之后的节点
            ListNode temp = node1.next;

            pre.next = node1;
            node1.next = node2;
            pre = node2;

            node1 = temp;
            node2 = node2.next;
        }
        // 处理奇数的情况
        if(node1!=null){
            pre.next = node1;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode node;
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }
}
/*
       总结： ListNode pre = head;;  如果新建立的链表指向了head，temp改变那么head将会被改变
       新增链表时，要不断往后添加数据，
            采取一个新的链表头结点，
            然后再用中间节点来遍历
            最后，返回新的头节点
        例如：该题要添加两个节点，关键在于中间节点如何使用--->让中间节点保留该节点之后的数据
        有点混乱，以后多理解吧
 */
