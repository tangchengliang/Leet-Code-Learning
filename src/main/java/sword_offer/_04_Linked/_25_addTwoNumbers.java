package src.main.java.sword_offer._04_Linked;

public class _25_addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        SingleListLinked s = new SingleListLinked();
        ListNode result = addTwoNumbers(l1,l4);
        s.list(result);
        System.out.println(result);
    }

    private static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // 先将两个链表反转
        ListNode reverse_head1 = reverseLinked(head1);
        ListNode reverse_head2 = reverseLinked(head2);
        // 反转的数相加
        ListNode reversedHead = addReverse(reverse_head1, reverse_head2);
        return reverseLinked(reversedHead);
    }

    private static ListNode addReverse(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (head1!=null || head2!=null){
            int sum=(head1==null?0:head1.val)+(head2==null?0:head2.val)+carry;
            carry = sum>10?1:0;
            sum = sum>=10?sum-10:sum;
            ListNode newNode = new ListNode(sum);

            sumNode.next = newNode;
            sumNode = sumNode.next;

            head1 = head1==null?null:head1.next;
            head2 = head2==null?null:head2.next;
        }
        if(carry>0){
            sumNode.next = new ListNode(carry);
        }
        return dummy.next;
    }

    private static ListNode reverseLinked(ListNode head) {
        // 记录中间值
        ListNode node;
        // 当前值
        ListNode cur = head;
        // 前一个值
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
