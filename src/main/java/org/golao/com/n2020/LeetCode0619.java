package org.golao.com.n2020;

import java.util.Arrays;

public class LeetCode0619 {
    /**
     * https://leetcode-cn.com/problems/valid-palindrome/
     * easy
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }


    /**
     * 力扣官方题解，双指针移动
     * 总结： 涉及到指针移动的，一般使用while循环
     *        1. 守住边界值，每个++ -- 前都要注意边界问题
     *        2. 每个while 循环，注意是否有跳出
     *        3. 测试用例的编写： 从无到有，从有到边界值，从边界值到越界值
     *           数据量不求大，但求覆盖多种情况
     * @param s
     * @return
     */
    public boolean isPalindromeLeetCode(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left < right){
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/paint-house-iii/
     * hard
     * 题解 ： 三维动态dp[i][j][k] ： 第i 个房子，形成了j个街区，刷的k颜色时，cost的最小值
     * @param houses
     * @param cost
     * @param m
     * @param n
     * @param target
     * @return
     */
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int INF = (int) 1e8;
        int[][][] dp = new int[m+1][target+1][n+1];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, INF);
            }
        }
        if (houses[0] > 0){
            dp[0][1][houses[0]] = 0;
        }else {
            for (int i = 1; i <= n; i++) {
                dp[0][1][i] = cost[0][i-1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= target; j++) {
                int color = houses[i];
                if (color > 0){
                    for (int k = 1; k <= n; k++) {
                        if (color == k){
                            dp[i][j][color] = Math.min(dp[i-1][j][k],dp[i][j][color]);
                        }else {
                            dp[i][j][color] = Math.min(dp[i-1][j-1][k], dp[i][j][color]);
                        }
                    }
                }else {
                    for (int k = 1; k <= n ; k++) {
                        for (int s = 1; s <= n ; s++) {
                            if (k == s) { //同一个街区
                                dp[i][j][k] = Math.min(dp[i-1][j][s] + cost[i][k-1], dp[i][j][k]);
                            }else {
                                dp[i][j][k] = Math.min(dp[i-1][j-1][s] + cost[i][k-1], dp[i][j][k]);
                            }
                        }
                    }

                }
            }
        }
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, dp[m-1][target][i]);
        }
        return ans == INF ? -1 : ans;
    }

}
