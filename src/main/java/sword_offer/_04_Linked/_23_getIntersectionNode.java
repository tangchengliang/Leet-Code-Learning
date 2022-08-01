package src.main.java.sword_offer._04_Linked;

import java.util.Stack;

/*
    三种方法求解：
        （1）将链表2的尾结点指向其头节点，问题就变为22
        （2）利用栈的思想，先放入栈中，再依次比较元素
        （3）双指针，先计算两链表的长度差，长的链表先移动长度差，再同时移动

        注意 ：不能链表逆序，因为逆序一条，另外一条逆序时，链表就变了
            例如 123456 --->654321
                783456 --->12378
 */
public class _23_getIntersectionNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l7.next = l8;
        l8.next = l3;

        ListNode result = getIntersectionNode1(l1, l7);
        System.out.println(result);

        ListNode result2 = getIntersectionNode2(l1, l7);
        System.out.println(result2);

        ListNode result3 = getIntersectionNode3(l1, l7);
        System.out.println(result3);
    }

    // 方法3.双指针,计算delta=长的链表-短的链表，长链表先移动delta，再同时移动，遇到相同的点，就是起点
    private static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        int count1 = getLinkedCount(headA);
        int count2 = getLinkedCount(headB);

        // 比较链表哪个长，哪个短
        ListNode longLinked = count1 > count2 ? headA : headB;
        ListNode shortLinked = count1 > count2 ? headB : headA;

        ListNode longer = longLinked;
        ListNode shorter = shortLinked;
        // 先移动长的链表
        int delta = Math.abs(count1 - count2);
        for (int i = 0; i < delta; i++) {
            longer = longer.next;
        }
        // 再同时移动两个电表，直到值相同
        while (longer != null && shorter != null) {
            if (longer == shorter) {
                return shorter;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }

    private static int getLinkedCount(ListNode headA) {
        int count = 0;
        ListNode temp = headA;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    // 方法2：从尾部往头比较，利用栈先进后出的思想，先将数据存放到栈中，再依次取出
    private static ListNode getIntersectionNode2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != null) {
            stack1.push(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            stack2.push(temp2);
            temp2 = temp2.next;
        }

        ListNode s1 = null;
        ListNode s2 = null;
        // 依次取出元素
        while (stack1.size() != 0 && stack2.size() != 0) {
            s1 = stack1.pop();
            s2 = stack2.pop();
            if (s1 != s2) {
                return s1.next;
            }
            // todo 注意当重合点为第一个元素时，可能会返回null
        }
        // 如果一个栈为0，判断此时两个元素是否相同
        if (s1 == s2) {
            return s1;
        }
        return null;
    }

    // 方法1：链表2的尾部指向其头部形成环，然后找到环入口节点
    private static ListNode getIntersectionNode1(ListNode head1, ListNode head2) {
        // 遍历链表二，让其尾节点指向其头节点，形成环
        ListNode temp2 = new ListNode(0);
        temp2.next = head2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = head2;

        // 利用22题简单方法找到环
        // 找到环中的一个点，通过一快一慢，相遇，即是环中的点
        ListNode inLoop = getNodeInLoop(head1);

        // 要判断是否有环
        if (inLoop == null) {
            temp2.next = null; //还原表结构
            return null;
        }
        ListNode node = new ListNode(0);
        node.next = head1;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }
        temp2.next = null; //还原表结构
        return node;
    }

    private static ListNode getNodeInLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            // 注意这里是判断fast是否为null
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}
