package org.golao.com.algorithm.topic.easy;

import com.sun.org.apache.xml.internal.security.c14n.helper.AttrCompare;
import org.golao.com.n2020.ListNode;

/**
 * 专题：链表
 */
public class LeetCodeEasyList {
    /**
     * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
     * 237. 删除链表中的节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     * 19. 删除链表的倒数第N个节点
     * 思路： 方法一： 1. 递归，到尾节点时，返回层级等于n时，进行删除操作
     *                 2. 时间复杂度 O(n), 空间复杂度 O(n)
     *        方法二： 迭代，两遍循环，第一遍数链表长度，第二遍在 length - n 节点时
     *                 进行删除操作
     *        思考： 如果函数不返回任何值时，如何删除？
     *               -- 将删除节点的下一个节点的值和指针，拷贝到删除节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        delete(preHead, n);
        return preHead.next;
    }
    private int delete(ListNode node , int n){
        if (node.next == null){
            return 1;
        }
        int level = delete(node.next, n);
        if (level == n){
            node.next = node.next.next;
        }
        return level + 1;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndSpaceO1(ListNode head, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode first = preHead;
        ListNode second = preHead;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return preHead.next;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/
     * 206. 反转链表
     * 题解：
     *     方法一： 1. 迭代
     *              2. 维护两个节点，pre 和 cur
     *              3. 每次循环，将 cur 的 next 指向 pre
     *      方法二： {@link LeetCodeEasyList#reverseListRecursive(ListNode)}
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     *  递归： 1. 将尾节点返回，成为反转后的头节点
     *         2. 将当前节点的下个节点的后继指针，指向当前节点
     *         3. 将当前节点的后继指针设置为null  防止循环
     * @param head
     * @return
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null){ //尾部
            return head;
        }
        ListNode cur = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    /**
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * 21. 合并两个有序链表
     * 回顾： 1. 六天前做过这题
     *        2. 当时的实现是用了一个新的链表去合并l1 l2 的节点
     *        3. 当时这个实现，是自己没有学会用一个头指针解决指针传递的问题
     *        4. 目前的实现比较优雅
     *        5. 链表的难点就是指针传递，Java 没有指针，以引用代替，所以Java程序员
     *           对指针的理解，相对c/c++ 要弱些
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle/
     * 141. 环形链表
     * 思路：  方法一： set 存储 ListNode 内存地址，如果重复则说明有环，否则能找到 null 节点退出(实现略)
     *         方法二： 1. 快慢指针
     *                  2. 一个循环内快指针移动两步，慢指针移动一步，相对速度是一步
     *                  3. 如果存在环形，快指针必然会追上慢指针
     *                  4. 时间复杂度: O(n)
     *                  5. 空间复杂度: O(1)
     *                  6. 指针移动前，注意判断 null 的情况
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
