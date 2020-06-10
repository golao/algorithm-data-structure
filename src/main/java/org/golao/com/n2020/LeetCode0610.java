package org.golao.com.n2020;

public class LeetCode0610 {

    public boolean isPalindrome(int x) {
        String str = x + "";
        StringBuilder sb = new StringBuilder(x + "");
        return str.equals(sb.reverse().toString());
    }
    /**
     * https://leetcode-cn.com/problems/house-robber/
     * 难度：简单
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int k = 2;
        int[][] dp = new int[nums.length][k];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int max = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] + nums[i];
            max = Math.max(Math.max(dp[i][1],dp[i][0]),max);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode0610 leetCode0610 = new LeetCode0610();
        int[] ary = {121,-121,10,1001};
        for (int a : ary) {
            boolean palindrome = leetCode0610.isPalindrome(a);
            System.out.println(palindrome);
        }
    }

}
