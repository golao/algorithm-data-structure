package org.golao.com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by golao on 2020/5/3.
 * 实现一个时间复杂度为 O(1)的lru
 */
public class LRUCache {

    class DListNode{
        int key;
        int value;
        DListNode pre;
        DListNode next;
        public DListNode(int k,int v){
            this.key = k;
            this.value = v;
        }
    }
    private void remove(DListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void addToHead(DListNode node){
        head.next.pre = node;
        node.pre = head;
        node.next = head.next;
        head.next = node;
    }
    private void moveToHead(DListNode node){
        remove(node);
        addToHead(node);
    }


    private void init(){
        this.head = new DListNode(0,0);
        this.tail = new DListNode(-1,-1);
        head.next = tail;
        tail.pre = head;
        this.cache = new HashMap<>(this.capacity);
    }

    private DListNode head;
    private DListNode tail;
    private Map<Integer,DListNode> cache ;
    private int capacity ;
    public LRUCache(int capacity){
        this.capacity = capacity;
        init();
    }

    public int get(int key){
        DListNode dListNode = this.cache.get(key);
        if (dListNode == null){
            return -1;
        }else {
            moveToHead(dListNode);
        }
        return dListNode.value;
    }

    public void put(int key,int value){
        DListNode dListNode = this.cache.get(key);
        if (dListNode != null){
            dListNode.value = value;
            moveToHead(dListNode);
            return;
        }
        DListNode node = new DListNode(key,value);
        if (this.cache.size() >= this.capacity){
            this.cache.remove(tail.pre.key);
            remove(tail.pre);
        }
        this.cache.put(key,node);
        addToHead(node);
    }

}
