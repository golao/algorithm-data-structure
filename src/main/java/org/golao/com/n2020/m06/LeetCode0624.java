package org.golao.com.n2020.m06;

import java.util.Arrays;

public class LeetCode0624 {
    /**
     * 每日一题
     * {@link LeetCode0615#threeSumClosest(int[], int)}
     * medium
     * 题解：之前做过了这题，现在重新实现一遍
     *       1. 对数组进行排序
     *       2. 三指针，left，right 放两端，cur = left + 1
     *       3. sum = nums[left] + nums[cur] + nums[right]，
     *       4. 外层循环固定 left，right，里层循环cur
     *       5. 维护一个全局变量 abs =  Math.abs(sum - target)，每次移动指针更新该值
     *          并与旧值 abs 比较，如果新值大于旧值，说明过拟了，返回前sum
     *       6. abs = 0 直接返回
     *
     *       //  以上思路 5 ，是有问题的，abs 的值，会在 cur移动的时候，就会发生由靠近到过拟
     *           这时返回，不是最优结果
     *           需要调整为，全局都遍历到，改成for循环，一端固定移动，剩下的用两个指针去探查
     *       //和三数之和为0 的题相比，返回不同数组时，需要去重，而去重的关键是每次每个指针
     *          移动的元素都是不同的，遇到相同的指针，则要while移动到不同元素为止
     *       时间复杂度：O(n²)
     *       空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int abs = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {//固定一端
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int st = Math.abs(sum - target);
                if (st < abs){
                    abs = st;
                    result = sum;
                }
                if (sum > target){
                    right--;
                }else if (sum < target){
                    left++;
                }else {
                    return sum;
                }
            }
        }
        return result;
    }
}
