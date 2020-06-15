package org.golao.com.algorithm.competition;

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
}
