package org.golao.com.n2020;

import java.util.Stack;

public class LeetCode0630 {
    /**
     * 每日一题
     * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
     * easy
     * 剑指 Offer 09. 用两个栈实现队列
     * 思路： 1. 2015年进t8t时，一面的试题
     *        2. 一个栈负责delete操作，一个负责 append操作时
     *        3. 当 del 栈为空时，从 append 栈中弹出元素压入del栈
     *        4. 时间复杂度: O(1)  每个元素均进栈出站各一次
     *        5. 空间复杂度: O(n)
     *
     */
    class CQueue {
        Stack<Integer> del;
        Stack<Integer> append;

        public CQueue() {
            this.del = new Stack<>();
            this.append = new Stack<>();
        }

        public void appendTail(int value) {
            append.push(value);
        }

        public int deleteHead() {
            if (del.isEmpty() && append.isEmpty()) {
                return -1;
            }
            if (del.isEmpty()) {
                while (!append.isEmpty()) {
                    del.push(append.pop());
                }
            }
            return del.pop();
        }
    }
}
