package org.golao.com.n2020;

/**
 * 67480
 */
public class LeetCode0613 {
    /**
     * https://leetcode-cn.com/problems/climbing-stairs/
     * 难度： easy
     * 题解： 这是一道入门级动态规划题
     *        1. f(x) = f(x-1) + f(x-2)
     *        2. 初始值 f(0) = 1, f(1) = 1;
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 1){
            return 1;
        }
        int dp0 = 1;
        int dp1 = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = dp0 + dp1;
            dp0 = dp1;
            dp1 = ans;
        }
        return ans;
    }
}
