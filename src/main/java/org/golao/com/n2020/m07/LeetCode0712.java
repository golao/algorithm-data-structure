package org.golao.com.n2020.m07;

import java.util.Arrays;

public class LeetCode0712 {
    /**
     * 每日一题
     * https://leetcode-cn.com/problems/dungeon-game/
     * hard
     * 174. 地下城游戏
     * 思路： 动态规划
     *        //1. dp[i][j] = min(dp[i][j-1], dp[i-1][j]) + dungenon[i][j];
     *        存在两个要素，1.是格子的健康点数，2是最低携带的起始点数，如果
     *         从左上向右下规划，两个要素很难说谁更重要，存在后效性，无法进行
     *         动态规划，上述动态方程只描述了累计健康点数和，没有描述起始携带
     *         点，所以不能解此题
     *
     *         2. 如果从右下往左上进行递推，那么只需要考虑最低的起始携带点数，
     *            这样就可以进行动态规划了
     *         3. 动态转移方程：
     *            dp[i][j] = max((min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]) , 1)
     *         4. 初始值：
     *            dp[m][n-1] = 1,  dp[m-1][n] = 1
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
