package org.golao.com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by golao on 2020/5/4.
 * LFU 时间复杂度O(1)实现版本
 *  双哈希表实现
 *  1. key_table  值为双向链表节点
 *  2. freq_table freq作为key ，值为双向链表
 *
 *  get 时，不存在返回 -1  存在则更新freq 表
 *  put 时，存在则更新值，并更新freq
 *          不存在是，检查capacity，容量够时，更新freq表
 *                                  容量不足时，删除频率最低的那个值
 *  需要维护一个全局频率最低的值  min_freq
 */
public class LFUCache_O1 {
    public class LFUCache{
        class Node{
            int key;
            int value;
            int freq;
            Node pre;
            Node next;
            Node(int k,int v){
                this.key = k;
                this.value = v;
            }
        }
        class DoubleLinkedList{
            Node head;
            Node tail;
            int size;
            DoubleLinkedList(){
                size = 0;
                head = new Node(-1,-1);
                tail = new Node(-2,-2);
                head.next = tail;
                tail.pre = head;
            }
            void addToHead(Node node){
                Node next = head.next;
                head.next = node;
                node.pre = head;
                node.next = next;
                next.pre = node;
                size++ ;
            }
            Node getLast(){
                if (size <= 0)
                    return null;
                return tail.pre;
            }
            void removeLast(){
                if (size <= 0)
                    return ;
                Node pre = tail.pre.pre;
                pre.next = tail;
                tail.pre = pre;
                size -- ;

            }
            void remove(Node node){
                Node pre = node.pre;
                Node next = node.next;
                pre.next = next;
                next.pre = pre;
                size--;
            }
            boolean isEmpty(){
                return size == 0;
            }
        }

        private int minFreq;
        private Map<Integer,Node> cache;
        private int capacity;
        private Map<Integer,DoubleLinkedList> freqMap;

        public LFUCache(int capacity){
            this.capacity = capacity;
            this.cache  = new HashMap<>();
            this.freqMap = new HashMap<>();
        }
        private void removeMinfreq(){
            DoubleLinkedList min = freqMap.get(minFreq);
            if (min != null){
                Node last = min.getLast();
                cache.remove(last.key);
                min.removeLast();
                if (min.isEmpty()){
                    freqMap.remove(minFreq);
                }
            }
        }



        private void putToFreqMap(Node node){
            DoubleLinkedList doubleLinkedList = freqMap.get(node.freq);
            if (doubleLinkedList == null){
                doubleLinkedList = new DoubleLinkedList();
                doubleLinkedList.addToHead(node);
                freqMap.put(node.freq,doubleLinkedList);
            }else {
                doubleLinkedList.addToHead(node);
            }
        }


        //两个操作，一个维护min freq  一个更新频率
        private void updateFreq(Node node){
            DoubleLinkedList doubleLinkedList = freqMap.get(node.freq);
            doubleLinkedList.remove(node);
            if (doubleLinkedList.isEmpty()){
                freqMap.remove(node.freq);
                minFreq = node.freq == minFreq ? minFreq+1 : minFreq;
            }
            node.freq += 1;
            putToFreqMap(node);
        }

        public int get(int key){
//            System.out.println("get : " + key);
            Node node = this.cache.get(key);
            if (node == null){
                return -1;
            }
            // 更新频率
            updateFreq(node);
//            System.out.println(this.cache);
            return node.value;
        }
        public void put(int key,int value){
//            System.out.println("put : key=" + key + " ,value=" + value);
            if (this.capacity <= 0){
                return;
            }
            Node node = this.cache.get(key);
            if (node != null){
                node.value = value;
                updateFreq(node);
                return;
            }
            if (this.cache.size() >= this.capacity){
                removeMinfreq();
            }
            Node n = new Node(key,value);
            n.freq = 1;
            this.cache.put(key,n);
            putToFreqMap(n);
            minFreq = 1;
//            System.out.println(this.cache);
        }
    }
}
