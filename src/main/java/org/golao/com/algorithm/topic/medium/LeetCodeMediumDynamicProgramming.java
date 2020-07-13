package org.golao.com.algorithm.topic.medium;

import java.util.Arrays;

public class LeetCodeMediumDynamicProgramming {
    /**
     * https://leetcode-cn.com/problems/jump-game/
     * 55. 跳跃游戏
     * 思路：  1. 保留前面最大能跳跃的步数，与nums[i] 相比，取最大跳跃步数为当前值
     *         2. 判断该值是否大于 0，如小于等于0 则无法继续往下跳，返回false
     *         3. 注意只需判断到倒数第二位，最后一位不需要判断
     *         4. 时间复杂度: O(n)
     *         5. 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            step = Math.max(step - 1, nums[i]);
            if (step <= 0){
                return false;
            }
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/jump-game-ii/
     * 45. 跳跃游戏 II
     *
     * @param nums
     * @return
     */
    public int jumpII(int[] nums) {
//        int[] maxStep = new int[nums.length];
//        Arrays.fill(maxStep, Integer.MAX_VALUE);
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j <= nums[i] + i && j < nums.length; j++) {
//                if (maxStep[j] < i){
//                    continue;
//                }
//                maxStep[j] = i;
//            }
//        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = i - 1; j >= 0 ; j--) {
                if (nums[j] >= i - j){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[n - 1];
    }

    /**
     *
     * @param nums
     * @return
     */
    public int jumpIIOn(int[] nums) {
        int n = nums.length;
        int[] step = new int[n];
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i] + i;
            if (cur < pre){
                continue;
            }
            for (int j = pre + 1; j <= cur && j < n; j++) {
                step[j] = i;
            }
            pre = cur;
        }
        int index = n - 1;
        int count = 0;
        while (index != 0){
            index = step[index];
            count++;
        }
        return count;
    }

    /**
     * https://leetcode-cn.com/problems/unique-paths/
     * 62. 不同路径
     * 思路： 典型的动态规划题
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[] upper = new int[n];
        int right = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                upper[j] += right;
                right = upper[j];
            }
            right = 0;
        }
        return upper[n-1];
    }

    /**
     * https://leetcode-cn.com/problems/coin-change-2/
     * 518. 零钱兑换 II
     * 思路：   1. 第一想法是联想到爬楼梯这一题
     *          2. 很快发现，解法不对，比答案要大很多
     *          3. 根源上是问题分析错误，爬楼梯是排列  1,2  和  2，1 是两种爬法
     *             而在这题上，这是一种零钱兑换，本题是组合，而不是排列
     *          4. 本题是解组合题的经典，先遍历硬币，用硬币去组合出金额
     *          5. 时间复杂度: O(M * amount) M 硬币种类
     *          6. 空间复杂度: O(n)
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
