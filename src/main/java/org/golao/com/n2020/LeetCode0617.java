package org.golao.com.n2020;

import java.util.*;

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

    /**
     * https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences/
     * 难度： hard
     * 题解：  1. 本质就是 nums1 与 nums2 的乘积表中，找出和最大的序列对，且不能调换顺序
     *         2. dp[n][m]存储状态，使用dp[i][j]的情况下，所能达到的最大和
     *         3. 观察乘积表可知，dp[i][j]只能从 dp[i-1][j-1]中转化来，因为使用了dp[i][j],
     *            dp[i-1][j]  和 dp[i][j-1] 是不能使用的(会导致重复)
     *         4. dp[i][j] 要么是和 dp[i-1][j-1] 加当前值 ，要么是单独，只有这两种状态
     *         5. dp[i][j] = Max(dp[i-1][j-1] + num1[i] * num[j] , num1[i] * num2[j])
     *         6. 边缘的起始值 dp[-1][j] dp[i][-j] dp[-1][-1] 均为 -∞
     *         6. 维持一个 max 值
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int[] ary : dp) {
            Arrays.fill(ary, -1000);
        }
        int ans = Integer.MIN_VALUE;
        int[] preMax = new int[nums2.length+1];
        int[] curMax = new int[nums2.length+1];
        Arrays.fill(preMax, -1000);
        Arrays.fill(curMax, -1000);
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                int product = nums1[i-1] * nums2[j-1];
                dp[i][j] = Math.max(preMax[j-1] + product, product);
                curMax[j] = Math.max(dp[i][j], Math.max(curMax[j-1],preMax[j]));
                ans = Math.max(dp[i][j] , ans);
            }
            int[] temp = preMax;
            preMax = curMax;
            curMax = temp;
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list/
     * easy
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

}
