package org.golao.com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by golao on 2020/5/3.
 * 思路： 和LRU结构类似，用双端链表维护一个计数器链表
 *        头部的为最高频，尾部为最低频
 *        get 和put 的时候，升降对应node在链表中的顺序
 */
public class LFUCache {
    class DListNode{
        int key;
        int value;
        int freq;
        DListNode pre;
        DListNode next;
        public DListNode(int k ,int v){
            this.key = k;
            this.value = v;
            this.freq = 1;
        }
    }

    private void sawp(DListNode b,DListNode a){
        DListNode next = b.next;
        DListNode pre = a.pre;
        b.pre = pre;
        pre.next = b;
        a.pre = b;
        b.next = a;
        next.pre = a;
        a.next = next;
    }

    private void moveUp(DListNode node){
        DListNode pre = node.pre;
        if (pre.pre == null) { // is head
            return;
        }
        if (node.freq >= pre.freq){
            sawp(node,pre);
            moveUp(node);
        }
    }
    private void removeLast(){
        DListNode last = tail.pre;
        this.tail.pre = last.pre;
        last.pre.next = tail;
    }
    private void addToTail(DListNode node){
        DListNode pre = this.tail.pre;
        pre.next = node;
        node.pre = pre;
        node.next = tail;
        tail.pre = node;
    }

    private void init(){
        this.cache = new HashMap<>();
        this.head = new DListNode(0,0);
        this.tail = new DListNode(-1,-1);
        this.head.next = tail;
        this.tail.pre = head;
    }

    private DListNode head;
    private DListNode tail;
    private int capacity;
    private Map<Integer,DListNode> cache;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        init();
    }

    public int get(int key) {
        DListNode dListNode = this.cache.get(key);
        if (dListNode == null){
            return -1;
        }
        dListNode.freq += 1;
        moveUp(dListNode);
        return dListNode.value;
    }

    public void put(int key, int value) {
        if (this.capacity == 0){
            return;
        }
        DListNode dListNode = this.cache.get(key);
        if (dListNode != null){
            dListNode.value = value;
            dListNode.freq += 1;
            moveUp(dListNode);
            return;
        }
        if (this.cache.size() >= this.capacity){
            //remove the last one
            this.cache.remove(tail.pre.key);
            removeLast();
        }
        DListNode node = new DListNode(key,value);
        this.cache.put(key,node);
        //add to tail and moveup
        addToTail(node);
        moveUp(node);
    }
}
