package org.golao.com.algorithm.competition;

import java.util.Arrays;

public class LeetCodeContest191 {
    /**
     * 问题一
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max1 = Math.max(nums[0],nums[1]);
        int max2 = Math.min(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max2){
                if (nums[i] > max1){
                    max2 = max1;
                    max1 = nums[i];
                }else {
                    max2 = nums[i];
                }
            }
        }
        return (max1-1) * (max2 -1);
    }

    /**
     * 切蛋糕，返回值需要对10的九次方 + 7  取模返回
     * 两个数组中，元素不重复
     * 对 horizon 数组排序，并求出相邻两数的差，取差值最大的数
     * 对 vertical 数组进行排序，并求出相邻两数的差，取差值最大的数
     * @param h
     * @param w
     * @param horizontalCuts
     * @param verticalCuts
     * @return
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        int hmax = Math.max(horizontalCuts[0],h - horizontalCuts[horizontalCuts.length-1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            int d = horizontalCuts[i] - horizontalCuts[i - 1];
            hmax = Math.max(d,hmax);
        }
        Arrays.sort(verticalCuts);
        int wmax = Math.max(verticalCuts[0],w - verticalCuts[verticalCuts.length-1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            int d = verticalCuts[i] - verticalCuts[i-1];
            wmax = Math.max(d,wmax);
        }
        long result = (long)hmax * (long)wmax;
        return (int) ( result % (1000000000L+7L));
    }
}
