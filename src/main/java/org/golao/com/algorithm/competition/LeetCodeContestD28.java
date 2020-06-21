package org.golao.com.algorithm.competition;

import java.util.Arrays;
import java.util.Stack;

public class LeetCodeContestD28 {
    /**
     * 1
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        if (prices.length <= 1){
            return prices;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                Integer pop = stack.pop();
                prices[pop] = prices[pop] - prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

    /**
     * 2
     */
    class SubrectangleQueries {
        private int[][] rectangle;
        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    this.rectangle[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return this.rectangle[row][col];
        }
    }

    /**
     * 3
     * 题解： 双指针
     *        1. 向前找到和为 target 的子数组，记录长度
     *
     * @param arr
     * @param target
     * @return
     */
    public int minSumOfLengths(int[] arr, int target) {
        int left = 0;
        int right = 0;
        int end = 0;
        int sum = 0;
        int lenA = 0;
        int lenB = 0;
        while (left <= right && right < arr.length){
            while (sum < target){
                sum += arr[right++];
            }
            if (sum == target){//查找是否有重合的, 如有，找最短的
                end = right - 1;
            }
        }
        return -1;
    }

    /**
     * 4
     * 0620 补
     * 题解 ： 1. 问题的本质是把一个数组分成k 段，求和最小的的分法
     *         2. 假设 k=1， 那么k点设置在数组的中位数时，绝对值和最小
     *         3. dp[i][j] 代表 i个元素，分成k段的绝对值和最小
     *         4. dp[i][j] 是从 dp[k][j-1] 转移而来，dp[k][j-1] 表示前面，j-1 段中，
     *            有j-1 至 i-1个元素，k ∈ [j-1,i-1]  ->  k-1 ∈ [j,i];再加上j点负责
     *            的段的绝对值和 -> rec[k][i]  (表示从k到i，放一个邮箱的距离和)
     *         5. dp[i][j] = Min(dp[i][j], dp[k-1][j-1] + rce[k][j]) for(k-1 ∈ [j,i])
     *         6. rec[k][i] 可以进行预处理
     *         7. 起始值-- 二维dp的初始化，往往是一个数组 dp[i][1] = rec[0][i]; for range 0 i
     *         8. 返回最后的 dp[i][j]
     * @param houses
     * @param k
     * @return
     */
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int INF = (int)1e9;
        int n = houses.length;
        int[][] rec = new int[n][n];
        //预处理 rec 数组，计算两点之间的放置一个邮箱的绝对值和
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mid = i + j >> 1;
                for (int s = i; s <= j ; s++) {
                    rec[i][j] += Math.abs(houses[s] - houses[mid]);
                }
            }
        }
        int[][] dp = new int[n][k+1]; //
        for (int[] dp1 : dp) {
            Arrays.fill(dp1, INF);
        }
        // 初始化起始值 dp[i][1]
        for (int i = 0; i < n; i++) {
            dp[i][1] = rec[0][i];
        }
        //开始推导
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <=Math.min(i+1, k); j++) { //如果邮箱超过house个数，再多也只会是0
                for (int s = j-1; s <= i; s++) { //j从1开始计算，要多减一
                    dp[i][j] = Math.min(dp[i][j], dp[s-1][j-1] + rec[s][i]);
                }
            }
        }
        return dp[n-1][k];
    }


}
