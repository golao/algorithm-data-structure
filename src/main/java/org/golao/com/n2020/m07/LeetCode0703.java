package org.golao.com.n2020.m07;

public class LeetCode0703 {
    /**
     * https://leetcode-cn.com/problems/cherry-pickup/
     * hard
     * 思路 ： 方法一： 1. 动态规划, 从上往下与从下往上，两个方式是否会干扰？
     *                     影响到全局最优解
     *                  2. 从上往下时， 每次只能向右，或向下移动，那么对每个格子
     *                     它的状态只取决于上一个格子，和左边的格子，如果这两个
     *                     格子是不可达的，那么当前格子也是不可达的
     *                  3. dp[i][j] 不等于 -1 时  dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]) + grid[i][j]
     *
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        return 0;
    }

    /**
     *
     * @param grid
     * @return
     */
    public int cherryPickupII(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int INF = (int)-1e8;
        int[][][] dp = new int[row][col+2][col+2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col + 2; j++) {
                dp[i][j][0] = INF;
                dp[i][j][col+1] = INF;
                dp[i][0][j] = INF;
                dp[i][col+1][j] = INF;
            }
        }
        dp[0][1][col] = grid[0][0] + grid[0][col-1];
//        int unreachable = col - 2;
//        int startRow = 0, startCol = 1;
//        while (unreachable > 0){
//            for (int i = startCol; i < startCol + unreachable; i++) {
//                grid[startRow][i] = INF;
//            }
//            startRow++;
//            startCol++;
//            unreachable -= 2;
//        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col+1; j++) {
                for (int k = 1; k < col + 1; k++) {
                    for (int s = -1; s < 2; s++) {
                        for (int m = -1; m < 2; m++) {
                            if (j == k){
                                dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j+s][k+m] + grid[i][j-1]);
                            }else {
                                dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j+s][k+m] + grid[i][j-1] + grid[i][k-1]);
                            }
                        }
                    }
                }
            }
        }
        int ans = INF;
        for (int i = 1; i < col+1; i++) {
            for (int j = 1; j < col + 1; j++) {
                ans = Math.max(dp[row-1][i][j],ans);
            }
        }
        return ans;
    }
}
