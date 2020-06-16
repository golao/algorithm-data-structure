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
     * 0615 补
     * @param houses
     * @param k
     * @return
     */
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int[][][] dp = new int[houses.length][k][2];
        int[][] state = new int[houses.length][k];
        for (int i = 0; i < houses.length; i++) {
            for (int j = 1; j < k; j++) {
                int dp00 = dp[i-1][j][0] + houses[i] - houses[state[i-1][j]];
                int dp01 = dp[i-1][j][1] + houses[i] - houses[i-1];
                if (dp00 < dp01){
                    dp[i][j][0] = dp00;
                    state[i][j] = state[i-1][j];
                }else {
                    dp[i][j][0] = dp01;
                    state[i][j] = i-1;
                }
                int dp11 = dp[i-1][j-1][1];
                int dp10 = dp[i-1][j-1][0] + lessDistans(houses, state[i-1][j-1], i);
                dp[i][j][1] = Math.min(dp10, dp11);
            }
        }
        return dp[houses.length-1][k-1][1];
    }

    private int lessDistans(int[] house, int start, int end){
        int sum = 0;
        if (start < 0){
        }
        for (int i = start + 1; i < end; i++) {
            int e1 = house[end] - house[i];
            int s1 = house[i] - house[start];
            if (e1 < s1){
                sum += e1 - s1;
            }
        }
        return sum;
    }


}
