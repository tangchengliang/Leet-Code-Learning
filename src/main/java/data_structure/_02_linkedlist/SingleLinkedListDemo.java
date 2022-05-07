package src.main.java.data_structure._02_linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1, "无极大师", "剑圣");
        HeroNode h2 = new HeroNode(5, "寒冰射手", "艾希");
        HeroNode h3 = new HeroNode(4, "鲁班大师", "卤蛋");
        HeroNode h4 = new HeroNode(2, "德玛西亚", "概论");
        HeroNode h5 = new HeroNode(3, "无姓之人", "劫劫");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByNo(h1);
        linkedList.addHero(h2);
        linkedList.addByNo(h3);
        linkedList.addByNo(h4);
        linkedList.addByNo(h5);
        linkedList.modifyByNo(h4);
        linkedList.removeByNo(5);
        linkedList.list();
        System.out.println("题目一：求单链表中有效节点的个数num=" + numHero(linkedList.getHead()));
        System.out.println("题目二：查找单链表中的倒数第k 个结点=" + reverseKHero(linkedList.getHead(),2));
        System.out.println("题目三：反转单链表" );
        reverseLinked(linkedList.getHead());
        linkedList.list();
    }
    /*
     * 面试题目：
     *  （1）求单链表中有效节点的个数
     *  （2）查找单链表中的倒数第k 个结点
     *  （3）单链表的反转【腾讯面试题，有点难度】
     *  （4）从尾到头打印单链表【百度，要求方式1：反向遍历。方式2：Stack 栈】
     */
    public static int numHero(HeroNode head) {
        HeroNode temp = head.next;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static HeroNode reverseKHero(HeroNode head, int k) {
        int count = numHero(head);
        if (count < k || k < 0) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 1; i <= count - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static void reverseLinked(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            // 只有一个元素，返回本身
            return;
        }
        HeroNode reverse_head = new HeroNode(0,"","");
        HeroNode temp = head.next; // 遍历指针
        HeroNode next ; // 中间存储
        while (temp != null){
            // 取出链表的元素，依次插入到中间链表的前面
            next = temp.next;  //暂时存放的，用于遍历的中间变量
            temp.next = reverse_head.next;  //将temp 的下一个节点指向新的链表的最前端
            reverse_head.next = temp;
            temp = next;
        }
        head.next = reverse_head.next;
    }
}

// 创建一个单链表，管理英雄
class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    HeroNode head = new HeroNode(0, "", "");

    // 返回头节点
    public HeroNode getHead() {
        return head;
    }

    //1.添加英雄，默认添加到最后
    public void addHero(HeroNode heroNode) {
        HeroNode temp = head;  //定义中间指针，指向头结点
        // 先遍历链表，找到指向 null的节点
        while (temp.next != null) {
            temp = temp.next;
        }
        // 找到尾节点后，指向新的节点
        temp.next = heroNode;
    }

    // 2.第二种方式在添加英雄时，根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
    public void addByNo(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = true;
        while (true) {
            if (temp.next == null) break;
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                // 说明要添加的序号已经存在
                flag = false;
                break;
            }
            temp = temp.next;
        }
        // 找到待插入节点后
        if (flag) {
            heroNode.next = temp.next;
            temp.next = heroNode;
        } else {
            System.out.printf("添加的编号%d 已经存在，不能添加\n", heroNode.no);
        }
    }

    // 3.修改节点的信息, 根据 no 编号来修改，即 no 编号不能改.
    public void modifyByNo(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = true;
        while (true) {
            if (temp.next == null) {
                flag = false;  // 遍历到末尾，跳出
                break;
            }
            if (temp.next.no == heroNode.no) {
                break;  // 找到节点位置跳出
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.name = heroNode.name;
            temp.next.nickname = heroNode.nickname;
        } else {
            System.out.println("修改的编号" + heroNode.no + "不存在，修改失败");
        }
    }

    //3.删除节点，通过编号 no 删除
    public void removeByNo(int no) {
        HeroNode temp = head;
        boolean flag = true;
        while (true) {
            if (temp.next == null) {
                flag = false;
                break;
            }
            if (temp.next.no == no) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("不存在no=" + no + "的节点，删除失败");
        }
    }

    // 显示链表
    public void list() {
        // 遍历
        HeroNode temp = head.next; //避免输出头节点
        if (temp == null) {
            System.out.println("空链表，没有数据~~");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

// 定义一个HeroNode，就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点

    // 构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，重写toString
    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + ", nickname='" + nickname + '}';
    }
}