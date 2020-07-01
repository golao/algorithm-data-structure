package org.golao.com.n2020.m07;

public class LeetCode0701 {
    /**
     * 每日一题
     * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
     * medium
     * 718. 最长重复子数组
     * 思路：
     *    方法一： 1. 数组的数据量是  0 - 1000  暴力三循环的枚举，时间复杂度: O(n³) ，要ac悬
     *             2. 动态规划方式，A[i] = B[j] 时，dp[i+1][j+1] 的公共前缀 加-
     *                dp[i][j] = dp[i+1][j+1] + 1 : 0 ;
     *             3. 利用这个把时间复杂度优化到 O(n²）
     *             4. 空间复杂度: O(n)
     *     方法二： 滑动窗口 {@link LeetCode0701#findLengthII(int[], int[])}
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (A[i] == B[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    /**
     * 思路：  官方题解
     *         1. 滑动窗口，枚举数组对齐的方式：
     *             B 移动，对齐 A 数组 -- 如 A[0] -> B[0]  下一次循环则是从 A[1] -> B[0] 开始
     *             A 移动，对齐 B 数组
     *         2.
     * @param A
     * @param B
     * @return
     */
    public int findLengthII(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int max = maxLenteh(A,0, B, i, len);
            ans = Math.max(ans,max);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(m - i, n);
            int max = maxLenteh(A, i, B, 0, len);
            ans = Math.max(ans,max);
        }
        return ans;
    }
    private int maxLenteh(int[] A, int offsetA,int[] B, int offsetB,int len){
        int max = 0, count = 0;
        for (int i = 0; i < len; i++) {
            if (A[i+offsetA] == B[i+offsetB]){
                count++;
            }else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
