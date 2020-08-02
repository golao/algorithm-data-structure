package org.golao.com.algorithm.lcof;

public class LeetCodeOffer {
    /**
     * 剑指 Offer 03. 数组中重复的数字
     * easy
     * 思路：
     *     方法一： 1. 用boolean 数组标记，遇到重复返回
     *              2. 时间复杂度: O(n)
     *              3. 空间复杂度: O(n)
     *     方法二： 1. 原地标记，使用正负符号
     *              2. 需要处理数字为 0 的情况
     *              3. 时间复杂度: O(n)
     *              4. 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                nums[i] = nums.length;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index == nums.length){
                index = 0;
            }
            if(nums[index] < 0){
                return index;
            }
            nums[index] = - nums[index];
        }
        return -1;
    }
}
