package org.golao.com.n2020;

public class LeetCode0617 {
    /**
     * https://leetcode-cn.com/problems/best-sightseeing-pair/
     * medium
     * 题解：
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int dp0 = A[0];
        int dp1 = 0;
        for (int i = 1; i < A.length; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0 - 1, A[i]);
            dp1 = Math.max(dp1, temp + A[i] - 1);
        }
        return dp1;
    }
}
