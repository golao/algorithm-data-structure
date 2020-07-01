package org.golao.com.n2020.m05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by golao on 2020/5/1.
 *  今日搞定  一中等 一困难 级别题目
 */
public class LeetCode0501 {
    /**
     * https://leetcode-cn.com/problems/lru-cache/
     * 难度： 中等
     * 记得以前在面试用友金融时候，有这道题
     */
    class LRUCache {
        private LinkedList<Integer> list = new LinkedList<>();
        private Map<Integer,Integer> map = new HashMap<>();
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer value = this.map.get(key);
            if (value == null){
                return -1;
            }else {
                list.removeFirstOccurrence(key);
                list.addFirst(key);
                return value;
            }
        }

        public void put(int key, int value) {
            if (this.get(key) == -1){
                map.put(key,value);
                return;
            }
            if (this.map.size() >= this.capacity){
                Integer last = list.pollLast();
                map.remove(last);
            }
            map.put(key,value);
            list.addLast(key);
        }
    }
}
