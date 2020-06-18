package org.golao.com.n2020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode0617 {
    /**
     * https://leetcode-cn.com/problems/best-sightseeing-pair/
     * medium
     * 题解：
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int dp0 = A[0];
        int dp1 = 0;
        for (int i = 1; i < A.length; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0 - 1, A[i]);
            dp1 = Math.max(dp1, temp + A[i] - 1);
        }
        return dp1;
    }

    /**
     * 2020.06.18
     * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
     * hard
     * 题解： 1. 解析数字与层数 ， 存入队列中
     *        2. parse 中前序遍历顺序进行递归
     *        3. 判断队列中的数，是否为当前节点的左右节点
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder(String S) {
        String[] split = S.split("\\-+");
        if (split.length == 1){
            return new TreeNode(Integer.parseInt(split[0]));
        }
        Queue<Entry> queue = new LinkedList<>();
        int level = 0;
        int point = 0;
        for (int i = 0; i < split.length; i++) {
            while (point < S.length() && S.charAt(point) == '-'){
                level++;
                point++;
            }
            queue.add(new Entry(Integer.parseInt(split[i]), level));
            level = 0;
            while (point < S.length() && S.charAt(point) != '-'){
                point++;
            }
        }
        return parseTree(queue);
    }
    private TreeNode parseTree(Queue<Entry> queue){
        Entry entry = queue.remove();
        TreeNode node = new TreeNode(entry.number);
        if (queue.isEmpty() || queue.peek().level <= entry.level) {
            return node;
        }
        node.left = parseTree(queue);

        if (queue.isEmpty() || queue.peek().level <= entry.level){
            return node;
        }
        node.right = parseTree(queue);
        return node;
    }


    class Entry{
        int number;
        int level;
        Entry(int num, int level){
            this.level = level;
            this.number = num;
        }
    }

    /**
     * 力扣官方题解
     * 思路： 1. 对当前点 T ，要么是前一个节点 S 的左节点，要么是从跟节点到S(不包括S)中某个节点的
     *        右节点。这是先序遍历  根 -> 左 -> 右 的性质决定了
     *        2. 利用这个性质，可以用一个栈模拟递归加回溯来顺序处理
     *        3. 当前节点 T 的level 与 栈顶元素个数对比(空则当前节点为根节点)，当 level = size 时，
     *           说明T的深度仅比栈顶元素大 1  ，是栈顶元素的左节点
     *           其他情况，则将栈顶元素弹出，直到找到，level = size ，此时T为栈顶元素的右节点。
     *        4. 最后处理完，弹出栈顶元素，即根节点
     *        5. 一些基本的操作，指针移动用while
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorderLeetCode(String S) {
        int pos = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (pos < S.length()){
            int level = 0;
            while (pos < S.length() && S.charAt(pos) == '-'){
                level++;
                pos++;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))){
                value = value * 10 + S.charAt(pos) - '0';
                pos++;
            }
            TreeNode node = new TreeNode(value);
            if (level == deque.size()){
                if (!deque.isEmpty()){
                    deque.peekFirst().left = node;
                }
            }else {
                while (level != deque.size()){
                    deque.removeFirst();
                }
                deque.peekFirst().right = node;
            }
            deque.addFirst(node);
        }
        return deque.removeLast();
    }


}
