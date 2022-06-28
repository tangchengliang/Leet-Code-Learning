package src.main.java.sword_offer._04_Linked;

public class _29_insert {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l1;
        int insertVal = 5;
        ListNode result = insert(l1,insertVal);
        System.out.println(result);
        System.out.println(result);
    }

    /**
     *  循环链表 按val值插入
     *  (1) 链表0个元素
     *  (2) 链表1个元素
     *  (3) 插入值，在中间：1）中间；2）在最大最小值
     * @param head head
     * @param insertVal insertVal
     * @return LisNode
     */
    private static ListNode insert(ListNode head, int insertVal) {
        ListNode node = new ListNode(insertVal);
        if(head==null){
            head = node;
            head.next = head;
        }else if(head.next==null){
            head.next = node;
            node.next = head;
        }else {
            insertCore(head, node);
        }
        return head;
    }

    private static void insertCore(ListNode head, ListNode node) {
        // 遍历链表，找到待插入的位置
        // 记录，特殊的边界情况，即插入最大，最小值
        ListNode cur = head;            // 记录当前值
        ListNode biggest = head;        // 记录最大值
        ListNode next = head.next;      // 记录cur的下一个值，并用于判断是否是最后一个点
        // 遍历
        while (!(cur.val<=node.val && next.val>=node.val) && next!=head){
            cur = next;
            next = next.next;
            if(cur.val>=biggest.val){
                biggest=cur;        // 更新最大值
            }
        }
        // 找到待插入位置，开始插入
        // 待插入的值时中间
        if(cur.val<=node.val && next.val>=node.val){
            cur.next = node;
            node.next = next;
        }else {
            // 插入最大最小值之间
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}
/*
    循环链表遍历：
        用一个next节点记录cur的下一节点，来判断next==head? 来判断是否遍历完成
 */
