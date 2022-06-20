package src.main.java.sword_offer._04_Linked;

public class _24_reverseList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        SingleListLinked s = new SingleListLinked();

        ListNode result = reverseList(l1);
        s.list(result);

        System.out.println("解法二");
//        ListNode result1 = reverseList1(l1);
//        s.list(result1);

    }

    /**
     * 暴力反转：依次读取链表中的数，用一个中间链表来存放，并存放到中间链表前面
     *
     * @param head
     * @return ListNode
     */
    private static ListNode reverseList(ListNode head) {
        // 建立一个新的链表
        ListNode newLinked = new ListNode(0);
        // 遍历节点,从头部开始
        ListNode temp = head;
        // 中间节点，暂时存放数据
        ListNode node = null;
        while (temp != null) {
            // 中间节点先记录temp后的数据
            node = temp.next;
            // 将当前节点放到新链表的最前端
            // 注意每一次newLinked都为0
            temp.next = newLinked.next;  // 当前节点的next指向newLinked头节点的后的链表数据
            newLinked.next = temp;      // 将newLinked头节点指向temp，实现了temp的插入
            // 取出中间变量
            temp = node;
        }
        head = newLinked.next;
        return head;
    }

    /**
     * 原理一样，利用三个指针：pre，cur，next记录三个节点
     * pre:当前指针的前一个指针  cur.next = pre
     * cur: 当前指针，判断是否为null
     * next：当前指针的下一个节点，保存数据，防止断裂
     *
     * @param head head
     * @return ListNOde
     */
    private static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;  // 防止断裂
            cur.next = pre;     // 将当前指针指向前一指针，实现反转
            pre = cur;          // 更新前一指针指向目前的指针，以便于之后的cur指向它
            cur = next;         // 取出存放的指针
        }
        return pre;  // 返回最后一个节点
    }
}
