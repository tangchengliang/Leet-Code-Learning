package src.main.java.sword_offer._11_binarySearch;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private ListNode head;
    private ListNode trail;
    private Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new ListNode(-1,-1);
            trail = new ListNode(-1,-1);
            map = new HashMap<>();

            head.next = trail;
            trail.pre = head;
            }

    public int get(int key) {
            ListNode node = map.get(key);
            if(node == null){
            return -1;
            }
            // 取node.value，是因为如果是插入修改元素，会传入一个newValue值，所以这里有两个参数
            moveToTrail(node, node.value);
            return node.value;
            }

    public void put(int key, int value) {
        // 先确认是否有这个元素
        if(map.containsKey(key)){
            moveToTrail(map.get(key), value);
        }else{
            // 先判断是否满了
            if(capacity==map.size()){
                // 删除头节点
                ListNode deleteHead = head.next;
                deleteNode(deleteHead);
                // map中也要删除
                map.remove(deleteHead.key);
            }
            // 插入节点
            ListNode insert = new ListNode(key, value);
            insertValue(insert);

            // 修改map
            map.put(key, insert);
        }
    }

    // 移动到链表尾部
    public void moveToTrail(ListNode node, int newValue){
        // 先删除该节点
        deleteNode(node);
        // 将该节点插入到链表后
        node.value = newValue;
        insertValue(node);
    }

    // 删除节点
    public void deleteNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 插入节点到链表尾部
    public void insertValue(ListNode node){
        trail.pre.next = node;
        node.pre = trail.pre;
        node.next = trail;
        trail.pre = node;
        }
    }

class ListNode{
    public ListNode next;
    public ListNode pre;
    public int key;
    public int value;

    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}