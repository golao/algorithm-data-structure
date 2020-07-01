package org.golao.com.algorithm.topic.easy;

/**
 *  1. 位运算
 *  2.
 */
public class LeetCodeEasyOthers {
    /**
     * https://leetcode-cn.com/problems/number-of-1-bits/
     * 191. 位1的个数
     * 思路： 对 n 每个二进制位进行 与 操作，结果为0 说明该位是 1
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0){
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    /**
     * 思路： 1. 将 x, y 的每一位进行对比
     *        2. 要对比每一位，就必需先屏蔽其他位的干扰，将其他位全部变为1 ，需要比较的位 mask 为 0
     *        3. 移动比较位 mask，同时统计不同的数量
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int diff = 0;
        int b = 1;
        int mask = (-1 ^ b);
        for (int i = 0; i < 32; i++) {
            if ((x | mask) != (y | mask)){
                diff++;
            }
            b <<= 1;
            mask = (-1 ^ b);
        }
        return diff;
    }

    /**
     * https://leetcode-cn.com/problems/missing-number/
     * 268. 缺失数字
     * 思路： 方法一： 实现略，已在力扣上进行了提交
     *              1. 设置一个和 nums 同等大小的 flag 数组作为标记
     *              2. 遍历 nums，对出现[0, n-1]的数，标记 flag 下标元素为true
     *              3. 遍历 flag 数组，遇到第一个 false ，返回其下标
     *              4. 如果 flag 全为 true，那么按顺序，是 n 未出现，返回n即可
     *              5. 时间复杂度: O(n)
     *              6. 空间复杂度: O(n)
     *
     *         方法二：为当前实现
     *              1. 使用 nums 数组自身来做标记，省去空间开销
     *              2. 遍历nums 数组，把所有负数改为 n+1
     *              3. 把非负数，全部进行 +1 操作，这样做的目的，是为了把 0 提升为 1,因为 0 没有
     *                 正负之分，不能作为标识
     *              4. 利用数的正负值，来识别序列数的出现，下一轮遍历 nums 时，nums[i] ∈ [1,n]
     *                 的值，nums[nums[i]] = -nums[nums[i]],
     *              5. 最后 遍历 nums，遇到第一个负数，返回其下标，即使缺失的数
     *              6. [0,n-1] 都有时，最后返回 n
     *              7. 时间复杂度: O(n)
     *              8. 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] >= 0 ? nums[i] + 1 : n + 1;
        }
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums[i]);
            if (abs > 0 && abs < n + 1){
                nums[abs-1] = - Math.abs(nums[abs-1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i;
            }
        }
        return n;
    }
}
