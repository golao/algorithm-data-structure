package org.golao.com.n2020.m06;

import java.util.Arrays;
import java.util.Collections;

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
     *        状态转移时，注意 houses[i] 的值，以及街区值
     *
     * @param houses
     * @param cost
     * @param m
     * @param n
     * @param target
     * @return
     */
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        //先初始化三维数组
        int[][][] dp = new int[m][target+1][n+1];
        int INF = (int)1e8;//不能选 Integer.MAX_VALUE 会溢出
        for (int[][] dp2 : dp) {
            for (int[] dp1: dp2) {
                Arrays.fill(dp1, INF);
            }
        }
        //设置起始值, 三维dp的起始值 dp[0][1][j]，也是一个三维数组
        //根据houses[0] 的不同值来判断
        //三维动态dp[i][j][k] ： 第i 个房子，形成了j个街区，刷的k颜色时
        if (houses[0] > 0){
            dp[0][1][houses[0]] = 0;
        }else {
            for (int i = 1; i <= n; i++) {
                dp[0][1][i] = cost[0][i-1];
            }
        }
        //开始动态规划，状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= target; j++) {
                if (houses[i] > 0){// 已刷漆，只求 dp[i][j][houses[i]] 的转移值，其他颜色不用转移
                    for (int k = 1; k <= n; k++) {
                        if (houses[i] == k){//颜色相同的情况下，和上一个房子是同一个街区
                            dp[i][j][houses[i]] = Math.min(dp[i-1][j][k], dp[i][j][houses[i]]);
                        }else {//和上一个房子不同街区
                            dp[i][j][houses[i]] = Math.min(dp[i-1][j-1][k], dp[i][j][houses[i]]);
                        }
                    }
                }else {// 未刷漆， 求所有dp[i][j][k] 的转移值
                    for (int k = 1; k <= n; k++) {//当前状态和上一个状态，两个状态都有n个颜色取值
                        for (int s = 1; s <= n; s++) {// 转移所有颜色状态
                            if (k == s) { // 同一个街区
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j][s] + cost[i][k-1]);
                            }else {// 不同街区
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j-1][s] + cost[i][k-1]);
                            }
                        }
                    }
                }
            }
        }

        //计算最后结果
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, dp[m-1][target][i]);
        }
        return ans == INF ? -1 : ans;
    }

    /**
     * https://leetcode-cn.com/problems/regular-expression-matching/
     * hard
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        return false;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-subarray/
     * easy
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

}
