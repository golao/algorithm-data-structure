package org.golao.com.n2020.m07;

import java.util.Arrays;

public class LeetCode0709 {
    /**
     * https://leetcode-cn.com/problems/re-space-lcci/
     * medium  每日一题
     * 面试题 17.13. 恢复空格
     * 思路： 字典树 + 动态规划
     *        1. 构建一颗后缀字典树
     *        2.
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        Trie root = new Trie();
        for (String s : dictionary) {
            root.insert(s);
        }
        int[] dp = new int[sentence.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= sentence.length() ; i++) {
            dp[i] = dp[i-1] + 1;
            Trie cur = root;
            for (int j = i; j >= 1 ; j--) {
                int p = sentence.charAt(j-1) - 'a';
                if (cur.next[p] == null){
                    break;
                }else if(cur.next[p].end){
                    dp[i] = Math.min(dp[i], dp[j-1]);// j 到 i  构成了一个词
                }
                if (dp[i] == 0){
                    break;
                }
                cur = cur.next[p];
            }
        }
        return dp[sentence.length()];
    }
    class Trie{
        Trie[] next;
        boolean end;
        Trie(){
            this.next = new Trie[26];
            end = false;
        }
        void insert(String s){
            Trie current = this;
            for (int i = s.length() - 1; i >= 0 ; i--) {
                int p = s.charAt(i) - 'a';
                if (current.next[p] == null){
                    current.next[p] = new Trie();
                }
                current = current.next[p];
            }
            current.end = true;

        }
    }

    /**
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     * 309. 最佳买卖股票时机含冷冻期
     * 0710 每日一题
     * 思路： 动态规划
     *        1. 分析状态，i 代表当前天， j  代表买卖状态， k 代表冷冻状态
     *        2. j = 0 未持有股票； j = 1 持有股票
     *        3. dp[i][0] 时分两种情况：
     *           1) 昨天未持有，今天延续   dp[i-1][0]
     *           2) 已持有，今天卖出       dp[i-1][1] + prices[i]
     *        4. 可以看到 dp[i][0] 时不涉及冷冻状态的判断
     *        5. dp[i][1] 时，也分两种状态
     *           1) 昨天已持有，今天延续    dp[i-1][1]
     *           2) 未持有，今天买入，      dp[i-2][0]
     *        6. 5.2 的情况，具体分析，要想今天能买入，前天必需是 dp[i-2][0] 状态
     *           前天结束时，状态必需处于未持有股票，今天才能买入。这儿处理了冷冻
     *           期状态，所以状态表，可以不用单独一个状态来记录冷冻
     *        7. 转移方程 ：
     *            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     *            dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
     *        8. 初始值
     *            dp[-1][0] = 0,  dp[-1][1] = -∞
     *            dp[-2][0] = 0
     *        9. 时间复杂度: O(n)
     *        10. 空间复杂度: O(n) 采用滚动数组能优化到 O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];
        dp[1][1] = Integer.MIN_VALUE;
        for (int i = 2; i < prices.length + 2; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-2]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i-2]);
        }
        return dp[prices.length + 1][0];
    }

    /**
     * 8. 初始值
     *      *            dp[-1][0] = 0,  dp[-1][1] = -∞
     *      *            dp[-2][0] = 0
     * @param prices
     * @return
     */
    public int maxProfitO1(int[] prices) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE, dp2 = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp2 - prices[i]);
            dp2 = temp;
        }
        return dp0;
    }

}
