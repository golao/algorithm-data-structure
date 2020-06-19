package org.golao.com.n2020;

/**
 * Created by golao on 2020/4/10.
 */
public class LeetCode0410 {
    /**
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     * 难度：困难
     * 题解： 题目要求时间复杂度为 O(log(m+n))
     * 1. 这道题收获很多，涉及logN 复杂度的，用了分治法，去看并理解了归并排序
     * 2. 官方题解中的 m >= n ，结合代码才明白，这是程序先决条件，避免发生 j 为负数
     * 3. halfLen = (m + n + 1) / 2   -- 在偶数时，+ 1 不起作用;奇数时，partA部分多一个
     * 0619 -- 来填坑
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (nums1.length > nums2.length){
            return 0.0;
        }
        int left = n / 2;
        int right = m / 2;
        if (nums1[left] < nums2[right]){

        }else {

        }



        return 0.0;
    }

    /**
     * 写一个时间复杂度为O(n) 的解法
     * 1. 两个都是有序的数组，只需将它们归并排序，从有序数组中得出中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays_On(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] temp = new int[m + n];
        int i = 0, j = 0, t = 0;
        while (i < m && j < n) {
            temp[t++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            temp[t++] = nums1[i++];
        }
        while (j < n) {
            temp[t++] = nums2[j++];
        }
        int mid = (m + n) / 2;
        return (m + n) % 2 == 0 ? (temp[mid-1] + temp[mid]) / 2.0 : temp[mid];
    }

}
