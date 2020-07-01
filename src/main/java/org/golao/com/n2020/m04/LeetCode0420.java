package org.golao.com.n2020.m04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by golao on 2020/4/20.
 * 今日目标：1 + 1 难 + 中等
 */
public class LeetCode0420 {
    /**
     * https://leetcode-cn.com/problems/pascals-triangle/
     * 题解： 杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1){
                    list.add(1);
                }else {
                    List<Integer> up = result.get(i - 2);
                    list.add(up.get(j - 1) + up.get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * 难度：简单
     * 题解：1. 暴力解，第一个和后续的差值比较，找出最大的，依次遍历全部的
     *          时间复杂度： O(n²)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                max = Math.max(max,prices[j] - prices[i]);
            }
        }
        return max;
    }
    public int maxProfit_01(int[] prices){
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int bottomPrices = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < bottomPrices){
                bottomPrices = prices[i];
                continue;
            }
            max = Math.max(max,prices[i] - bottomPrices);
        }
        return max;
    }

    /**
     * 2020.04.29
     * 用动态规划方式，状态转移方程
     * @param prices
     * @return
     */
    public int max_profit_dp(int[] prices){
        int dpi_0 = 0,dpi_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dpi_0 = Math.max(dpi_0,dpi_1 + prices[i]);
            dpi_1 = Math.max(dpi_1,-prices[i]);
        }
        return dpi_0;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     * 难度：困难
     * 使用动态规划，穷举所有状态，状态转移方程
     * @param prices
     * @return
     */
    public int maxProfit_iii(int[] prices) {
        int dp1_0 = 0,dp1_1 = Integer.MIN_VALUE;
        int dp2_0 = 0,dp2_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp2_0 = Math.max(dp2_0,dp2_1 + prices[i]);
            dp2_1 = Math.max(dp2_1,dp1_0 - prices[i]);
            dp1_0 = Math.max(dp1_0,dp1_1 + prices[i]);
            dp1_1 = Math.max(dp1_1,-prices[i]);
        }
        return dp2_0;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 难度：简单
     * 1. 用普通思维的话，只要明天比今天高，就买入或者持有，只要明天比今天低就卖出或者不操作
     *    即可得出最大利润
     * 2. 用dp table  解  用这个练手
     *
     * @param prices
     * @return
     */
    public int maxProfit_ii(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1,temp - price);
        }
        return dp_i_0;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
     * 难度：困难
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit_iv(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2)
            return maxProfit_ii(prices);
        int[][][] dp = new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i-1 == -1){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[n-1][k][0];
    }

    /**
     * 最大子串序列和
     *
     */
    public int maxSequence(int[] nums){
        int dpi_0 = Integer.MIN_VALUE,dpi_1 = 0;
        for (int i = 0; i < nums.length; i++) {
            dpi_0 = Math.max(dpi_0,dpi_1 + nums[i]);
            dpi_1 = Math.max(dpi_1 + nums[i],nums[i]);
        }
        return Math.max(dpi_0,dpi_1);
    }

    public static void main(String[] args) {
        LeetCode0420 leetCode0420 = new LeetCode0420();
        int[] t1 = {-1,-2};
        System.out.println(leetCode0420.maxSequence(t1));
    }

}
