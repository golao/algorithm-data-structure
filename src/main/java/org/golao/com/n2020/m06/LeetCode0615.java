package org.golao.com.n2020.m06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class LeetCode0615 {
    /**
     * https://leetcode-cn.com/problems/longest-common-prefix/
     * easy
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String prefix = "";
        outer:
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() ||
                        strs[0].charAt(i) != strs[j].charAt(i)){
                    break outer;
                }
            }
            prefix = strs[0].substring(0, i+1);
        }
        return prefix;
    }

    /**
     * https://leetcode-cn.com/problems/3sum-closest/
     * medium
     * 題解： 借鉴 {@link org.golao.com.algorithm.Solution#threeSum(int[])}
     *        先排序，再进行双指针移动，不断逼近最靠近解
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int abs = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                int st = Math.abs(sum - target);
                if (st < abs){
                    abs = st;
                    ans = sum;
                }
                if (sum > target){
                    R--;
                }else if(sum < target) {
                    L++;
                }else {
                    return sum;
                }
            }
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/4sum/
     * medium
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = nums.length -1; j > i+2; j--) {
                int L = i + 1;
                int R = j - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum > target) {
                        while (L < R - 1 && nums[R] == nums[R-1]){
                            R--;
                        }
                        R--;
                    } else if (sum < target) {
                        while (L + 1 < R && nums[L] == nums[L+1]){
                            L++;
                        }
                        L++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[L]);
                        list.add(nums[R]);
                        list.add(nums[j]);
                        ans.add(list);
                        while (L < R - 1 && nums[R] == nums[R-1]){
                            R--;
                        }
                        R--;
                        while (L + 1 < R && nums[L] == nums[L+1]){
                            L++;
                        }
                        L++;
                    }
                }
                while ( j - 1 > i+2 && nums[j] == nums[j-1]){
                    j--;
                }
            }
            while (i + 1 < nums.length - 3 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return ans;
    }

    /**
     * TODO 重写一遍，加深对多指针操作的练习
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSumI(int[] nums, int target){
        return null;

    }


}
