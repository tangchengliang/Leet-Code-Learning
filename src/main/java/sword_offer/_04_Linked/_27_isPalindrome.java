package src.main.java.sword_offer._04_Linked;

public class _27_isPalindrome {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        SingleListLinked s = new SingleListLinked();
        boolean flag = isPalindrome(l1);
        System.out.println(flag);
        System.out.println("显示链表");
        s.list(l1);
    }

    // 判断回文字符串
    // 采取寻找中间节点，分为两个链表，将后面的链表反转，依次比较是否相同
    private static boolean isPalindrome(ListNode head) {
        // 寻找中间节点
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow!= null && fast!=null){
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        // 记录两个链表
        ListNode afterList = slow.next;
        slow.next = null;
        ListNode preList = head;

        afterList = reverseList(afterList);

        while (afterList!=null && preList!=null){
            if(afterList.val!=preList.val){
                return false;
            }
            afterList = afterList.next;
            preList = preList.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode next;
        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
