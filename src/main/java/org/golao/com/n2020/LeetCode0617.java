package org.golao.com.n2020;

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


}
