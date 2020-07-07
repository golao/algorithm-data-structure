package org.golao.com.n2020.m07;

public class LeetCode0702 {

    /**
     * 每日一题
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
     * medium
     * 思路：  方法一： 1. 暴力解，合并二维数组为一维，排序后返回 n[k-1]
     *                  2. 时间复杂度: O(n²logn)
     *                  3. 空间复杂度: O(n²)
     *                  4. 实现略
     *         方法二： 1. 二分查找
     *                  2. mid = matrix[0][0] + matrix[n-1][n-1];
     *                  3. 从最底一行统计小于mid 的元素数量count
     *                  4. 根据 count 与 k 来调整 mid 的左右界
     *                  5.
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right){
            int mid = (int)(((long)left   + (long)right)/2);
            if (check(matrix, mid, k)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean check(int[][] matrix, int mid, int k){
        int count = 0;
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix.length){
            if (matrix[i][j] <= mid){
                count += i + 1;
                j++;
            }else {
                i--;
            }
        }
        return count >= k;
    }
}
