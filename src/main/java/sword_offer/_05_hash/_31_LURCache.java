package src.main.java.sword_offer._05_hash;

import java.util.HashMap;
import java.util.Map;

public class _31_LURCache {
    public static void main(String[] args) {
        LURCache lurCache = new LURCache(3);
        lurCache.put(1,1);
        lurCache.put(2,2);
        lurCache.put(3,3);
        lurCache.put(4,4);
    }
}

class LURCache{
    private ListNode tail;
    private ListNode head;
    private Map<Integer, ListNode> map;
    int capacity;

    public LURCache(int cap){
        map = new HashMap<>();

        tail = new ListNode(-1,-1);
        head = new ListNode(-1,-1);

        head.next = tail;
        tail.pre = head;
        capacity = cap;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            moveToTrail(map.get(key), value);
        }else {
            if(map.size() == capacity){
                ListNode toBeDelete = head.next;
                deleteNode(toBeDelete);

                map.remove(toBeDelete.key);
            }
            ListNode node = new ListNode(key, value);
            insertToTrail(node);

            map.put(key, node);
        }
    }

    public int getValue(int key){
        ListNode node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToTrail(node, node.value);
        return node.value;
    }

    private void moveToTrail(ListNode node, int newValue) {
        deleteNode(node);
        node.value = newValue;
        insertToTrail(node);
    }

    private void insertToTrail(ListNode node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    private void deleteNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

class ListNode{
    public int key;
    public int value;
    public ListNode pre;
    public ListNode next;

    public ListNode(int k, int v){
        this.key = k;
        this.value = v;
    }
}
