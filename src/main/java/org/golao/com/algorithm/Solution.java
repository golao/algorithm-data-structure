package org.golao.com.algorithm;

import java.util.*;

public class Solution {

    /**
     * 测试记录：
     * 1. 输入[] ,应输出[]  我返回了 null   报错
     * 2. 输入[0,0,0,0] ，应输出[[0,0,0]] 我输出[[0,0,0],[0,0,0],[0,0,0],[0,0,0]]
     *   缺乏去重机制 -- 加入 set 字符串作为key 进行去重
     * 3. 超时了，三个for循环，改一下
     * @param nums
     * @return
     */
    public List<List<Integer>> findThreeNumber(int[] nums){
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        int[] dp = new int[nums.length];
        Set<String> set = new HashSet<>();
        int bond = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < bond; j++) {
                dp[j] = nums[i] + nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    int sum = dp[j] + nums[k];
                    if (sum > 0){
                        bond = k;
                        break;
                    }
                    String str = "" + nums[i] + nums[j] + nums[k];
                    if (sum == 0 && !set.contains(str)){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[k]);
                        result.add(list);
                        set.add(str);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 排序 + 双指针
     * 本题的难点在于如何去除重复解。
     *
     * 算法流程：
     * 特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。
     * 对数组进行排序。
     * 遍历排序后数组：
     * 若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
     * 对于重复元素：跳过，避免出现重复解
     * 令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
     * 当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
     * 若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
     * 若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
     * 复杂度分析
     * 时间复杂度：O\left(n^{2}\right)O(n
     * 2
     *  )，数组排序 O(N \log N)O(NlogN)，遍历数组 O\left(n\right)O(n)，双指针遍历 O\left(n\right)O(n)，总体 O(N \log N)+O\left(n\right)*O\left(n\right)O(NlogN)+O(n)∗O(n)，O\left(n^{2}\right)O(n
     * 2
     *  )
     * 空间复杂度：O(1)O(1)
     *
     * 作者：wu_yan_zu
     * 链接：https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     */
    public List<List<Integer>> threeSum(int[] nums){
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length -1] < 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return result;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length -1;
            while(left < right){
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left < right && nums[left] == nums[left+1]){
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right -= 1;
                    }
                    left++;
                    right--;
                }else if (threeSum < 0){
                    left++;
                }else {
                    right--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};

//        int[] test = {-3,3-9,1,5,8,-2};

        List<List<Integer>> threeNumber = solution.findThreeNumber(test);
        List<List<Integer>> lists = solution.threeSum(test);
        System.out.println(threeNumber);
        System.out.println(lists);

    }
}
