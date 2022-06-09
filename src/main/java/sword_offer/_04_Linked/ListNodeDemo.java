package src.main.java.sword_offer._04_Linked;

public class ListNodeDemo {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(1);
        singleListLinked s = new singleListLinked();
        s.addNode(l1);
        s.addNode(l2);
        s.addNode(l3);
        s.list();
        s.delNode(1);
        s.list();
    }

}
class singleListLinked{
    ListNode head = new ListNode(0);

    public ListNode getHead(){
        return head;
    }

    // add 默认添加到末尾
    public void addNode(ListNode x){
        ListNode temp = head;
        // 找到待插入点
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = x;
        x.next=null;
    }
    // 删除节点
    public void delNode(int val){
        ListNode temp = head;
        boolean flag = false;  // 判断是否有点
        // 找到删除的点
        while (temp.next!=null){
            if(temp.next.val==val){
                // 此时temp.next  就是要删除的点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            // 删除即指向后一个节点
            temp.next = temp.next.next;
        }else {
            throw new RuntimeException("待删除节点val="+val+"未找到，请重新输入！");
        }
    }

    public void list(){
        ListNode temp = head.next;
        if(temp==null){
            throw new RuntimeException("没有数据，请添加！");
        }
        while (temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


// 建立一个节点，存放数据
class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNodeDemo{" +
                "val=" + val +
                '}';
    }
}
