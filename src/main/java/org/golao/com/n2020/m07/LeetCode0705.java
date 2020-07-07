package org.golao.com.n2020.m07;

import java.util.Arrays;

public class LeetCode0705 {
    public int longestValidParentheses(String s) {

        return 0;
    }

    /**
     * https://leetcode-cn.com/problems/unique-paths-ii/
     * medium
     * 思路： 方法一：1. 动态规划
     * 2. 机器人只能向右和向下移动，dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 3. 时间复杂度: O(n²)
     * 4. 空间复杂度: O(n²) 可优化到 O(n) {@link LeetCode0705#uniquePathsWithObstaclesOn(int[][])}
     * 5. 关键点，选择初始化的点，dp[0][1] 或 dp[1][0]
     * 6. 因为只和上一行和右边值相关，二维dp空间可以优化为 一维保存上一行，
     * 一个常量保持右边值
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
//        dp[0][1] = 1; // 初始化条件，不要进行想当然判断，而是要判断 输入数组的值
                       // 力扣测试能通过，说明测试例子不充分
        dp[0][1] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public int uniquePathsWithObstaclesOn(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        int[] upper = new int[n];
        int right = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    upper[j] = 0;
                    right = 0;
                } else {
                    upper[j] = right + upper[j];
                    right = upper[j];
                }
            }
            right = 0;
        }
        return upper[n - 1];
    }
}
