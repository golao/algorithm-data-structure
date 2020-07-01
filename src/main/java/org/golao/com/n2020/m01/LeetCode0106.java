package org.golao.com.n2020.m01;

import org.golao.com.n2020.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by golao on 2020/1/6.
 */
public class LeetCode0106 {
    /**
     * 难度 : 简单
     * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        int i = head.val;
        while (head.next != null){
            head = head.next;
            i = (i << 1) + head.val ;// i = i*2 + head.val;
        }
        return i;
    }

    /**
     * 难度 ： 简单
     * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
     * 用栈解决问题
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int result = 0;
        Deque<Character> deque = new LinkedList<>();
        char start = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == start){
                deque.addFirst(s.charAt(i));
            }else {
                deque.removeFirst();
            }
            if (deque.isEmpty()){
                result++;
                if (i + 1 < s.length()){
                    start = s.charAt(i+1);
                }
            }
        }
        return result;
    }
    public int balancedStringSplitBetter(String s){
        int count = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R'){
                balance++;
            }else {
                balance--;
            }
            if (balance == 0){
                count++;
            }
        }
        return count;
    }



}
