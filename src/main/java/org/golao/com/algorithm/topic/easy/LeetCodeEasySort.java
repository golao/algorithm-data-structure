package org.golao.com.algorithm.topic.easy;

/**
 * 排序专题
 * 重点： 堆排序，快速排序，归并排序
 *        1. 时间和空间复杂度
 *        2. 排序算法的稳定性
 *        3. 适用场景
 */
public class LeetCodeEasySort {
    /**
     * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
     * 215. 数组中的第K个最大元素
     * 思路： 最小堆和快速排序，两个思路可以解
     *        //TODO 面试重点题，需要理解，掌握，可自己实现堆结构
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return 0;
    }

    /**
     * https://leetcode-cn.com/problems/merge-sorted-array/
     * 88. 合并两个有序数组
     * 题解： 之前做过，从尾部开始合并，类似归并排序的合并方式即可
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m -1 , j = n - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0){
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * https://leetcode-cn.com/problems/first-bad-version/
     * 278. 第一个错误的版本
     * 题解： 二分查找
     *       1. 改变了一下程序的调用方式，便于写本地代码
     *       2. 查找第一个错误版本，所以当 ary[mid] 为true时，right 是移动到 mid
     *          因为只能确定上一轮查找 (mid - right] 的值都可以排除，但mid不能确定
     *          它不是第一个，不能排除
     * @param ary
     * @return
     */
    public int firstBadVersion(boolean[] ary, int n) {
        int left = 1, right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (ary[mid]){
                right = mid; // 不选取 mid + 1 ，是因为 mid 点也有可能是第一个错误版本
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
}
