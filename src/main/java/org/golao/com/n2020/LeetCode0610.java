package org.golao.com.n2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode0610 {

    public boolean isPalindrome(int x) {
        String str = x + "";
        StringBuilder sb = new StringBuilder(x + "");
        return str.equals(sb.reverse().toString());
    }
    /**
     * https://leetcode-cn.com/problems/house-robber/
     * 难度：简单
     *  采用原始的动态规划，深刻的理解一下转移方程
     *  转移方程，一定要想清楚前面多少种状态，如何转移到后一种状态去，取哪个要求的值(最大 ，最小。。）
     * 后一间房子与前一间房子之间的转移关系  f(x) = f(x-1)  f(x) = f(x-1) + nums[i]
     *  0 代表不抢，1 代表抢
     *  dp[n][0] = Max(dp[n-1][1], dp[n-1][0])
     *  dp[n][1] = dp[n-1][0] + nums[i]
     *
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
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1] = dp[i-1][0] + nums[i];
            max = Math.max(Math.max(dp[i][1],dp[i][0]),max);
        }
        return max;
    }

    /**
     * 动态规划，优化版本
     * 提交报错一次，注意，每次提交注意特例处理
     *
     * @param nums
     * @return
     */
    public int robOpt(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int dp_0 = 0;
        int dp_1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = dp_0;
            dp_0 = Math.max(dp_1,dp_0);
            dp_1 = temp + nums[i];
        }
        return Math.max(dp_0,dp_1);
    }

    /**
     * https://leetcode-cn.com/problems/house-robber-ii/
     * 难度：medium
     * 首尾形成了环
     * 题解： 1. nums[0] 不抢，剩下的和robI 解法一样，求最大值
     *        2. nums[0] 抢  ， 只取 dp[n][0] 的解
     *        3. 比较上面两个值，返回较大的值
     * @param nums
     * @return
     */
    public int robII(int[] nums) {
        //特例处理
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        //第一间不抢
        int dp_00 = 0;
        int dp_01 = 0;
        //第一间抢的情况下
        int dp_10 = Integer.MIN_VALUE; // 不存在
        int dp_11 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = dp_00;
            dp_00 = Math.max(dp_00,dp_01);
            dp_01 = temp + nums[i];
            int temp1 = dp_10;
            dp_10 = Math.max(dp_10,dp_11);
            dp_11 = temp1 + nums[i];
        }
        return Math.max(Math.max(dp_00,dp_01),dp_10);
    }

    /**
     * https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
     * 难度： hard
     * 题解： 看例子，不太像是一个hard的题，但通过率很低
     *        1. 使用了暴力解法，逐个遍历，使用最长匹配模式，时间复杂度为O(n²) 提交后超时了
     *        2.
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        int realSize1 = 0;
        int rs2 = 0;
        int ans = 0;
        int L1 = 0, L2 = 0;
        for (int i = 0; i < A.length; i++) {
            boolean add1 = update(map1,A[i],true);
            if (add1){
                realSize1++;
            }
            boolean add2 = update(map2,A[i],true);
            if (add2){
                rs2++;
            }
            while (realSize1 > K){
                boolean remove = update(map1, A[L1++], false);
                realSize1 = remove ? realSize1 - 1 : realSize1;
            }
            while (rs2 >= K){
                boolean remove = update(map2, A[L2++],false);
                rs2 = remove ? rs2 - 1 : rs2;
            }
            ans += L2 - L1;
        }
        return ans;
    }

    private boolean update(Map<Integer,Integer> map,int a,boolean add){
        Integer times = map.getOrDefault(a, 0);
        if (add){
            map.put(a, times+1);
        }else {//remove
            map.put(a,times-1);
        }
        return add ? times == 0 : times == 1;
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
