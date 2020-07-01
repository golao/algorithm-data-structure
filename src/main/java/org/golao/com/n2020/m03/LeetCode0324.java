package org.golao.com.n2020.m03;

import org.golao.com.n2020.ListNode;

/**
 * Created by golao on 2020/3/24.
 */
public class LeetCode0324 {
    /**
     * https://leetcode-cn.com/problems/add-two-numbers/
     * 难度：中等
     * 题解：模仿加法，用双指针移动的思路,以l2 为返回链表
     *       注意进位情况
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode left = l1;
        ListNode right = l2;
        while (true){
            carryBit(right,left.val);
            if (right.next == null || left.next == null){
                break;
            }
            right = right.next;
            left = left.next;
        }
        //处理left 比 right 大的情况
        if (right.next == null && left.next != null){
            right.next = left.next;
        }
        return l2;
    }
    //处理进位
    private void carryBit(ListNode node,int val){
        node.val += val;
        if (node.val >= 10){
            node.val = node.val % 10;
            if (node.next == null){
                node.next = new ListNode(1);
            }else {
                carryBit(node.next,1);
            }
        }
    }

}
