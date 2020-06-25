package org.golao.com.algorithm.topic.easy;

import java.util.*;

/**
 * 专题系列： 初级 - 数组
 */
public class LeetCodeEasyArray {
    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * easy
     * 26. 删除排序数组中的重复项
     * 题解： 快慢指针，快指针与前值比较，相同则跳过
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int i = 1;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[j - 1]){
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * easy
     * 122. 买卖股票的最佳时机 II
     * 题解： 当前元素比前一个元素大时，累加 ans += prices[i] - prices[i-1]
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1; i< prices.length; i++){
            if(prices[i] > prices[i-1]){
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/rotate-array/
     * easy
     * 189. 旋转数组
     * 题解：如果使用空间 O(n)，本题没有难度
     *      1. 要求使用 O(1) 空间实现，是本题的精髓和难点
     *      //TODO
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
    }

    /**
     * https://leetcode-cn.com/problems/contains-duplicate/
     * easy
     * 217. 存在重复元素
     * 题解；面向入门级别的题，用哈希表最简单
     *       //TODO 1. 额外任务：实现堆排序 2. TreeSet TreeMap 实现原理了解
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/single-number/
     * easy
     * 136. 只出现一次的数字
     * 题解： 使用set存储，存在则删除，遍历结束时，返回set中剩余的那个元素
     *       2. 学习到的解法： 异或运算，异或运算满足交换律和结合律，且a ^ a = 0
     *       3. 所以代码可以写出 空间复杂度为 O(1) 的解 {@link LeetCodeEasyArray#singleNumberXor(int[])}
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }

    /**
     * 异或运算
     * @param nums
     * @return
     */
    public int singleNumberXor(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    /**
     * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
     * easy
     * 350. 两个数组的交集 II
     * 题解： 方法一： 排序后，双指针移动，相等则放入ans数组中并共同移动一位
     *                 不等则分情况，更小的那个数组进行指针移动
     *                 ans 长度取 Min(n1,n2), 返回值为 ans 的子数组
     *        方法二： {@link LeetCodeEasyArray#intersectUseMap(int[], int[])}
     *                 1.用 map 存储较短的数组的元素值和出现次数
     *                 2.遍历较长的数组，与map中的元素进行比较
     *                 3.如果存在，则次数大于0，则放入ans中
     *                 4.返回 ans 子数组
     *         方法三： 在方法一的基础上，如果nums1 较短， nums2很大，那么2指针的移动
     *                  因为具有单调性，可以使用二分查找的方式进行指针移动，快速定位到
     *                  移动位置
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int p1 = 0, p2 = 0, pa = 0;
        while (p1 < nums1.length && p2 < nums2.length){
            if (nums1[p1] == nums2[p2]){
                ans[pa++] = nums1[p1++];
                p2++;
            }else if (nums1[p1] > nums2[p2]){
                p2++;
            }else {
                p1++;
            }
        }
        return Arrays.copyOfRange(ans,0,pa);
    }

    /**
     * 用 哈希表 的解决方式
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectUseMap(int[] nums1, int[] nums2){
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[]{};
        }
        if (nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        int[] ans = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int e : nums1) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        int pa = 0;
        for (int e : nums2) {
            if (map.containsKey(e)){
                int times = map.get(e);
                if (times > 0){
                   ans[pa++] = e;
                   map.put(e, times - 1);
                }
            }
        }
        return Arrays.copyOfRange(ans,0, pa);
    }

    /**
     * https://leetcode-cn.com/problems/plus-one/
     * easy
     * 66. 加一
     * 题解：  关键是进位
     *         逆序遍历，当前位的值  digits[i] = (digits[i] + carry) % 10
     *          digits[i] + carry  这个值需要用临时变量存储 起来
     *          试了白板写代码，这个位置没使用临时变量，导致了一次W/A
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int n = digits.length;
        digits[n-1] += 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int temp = digits[i] + carry;
            digits[i] = temp % 10;
            carry = temp / 10;
        }
        int[] ans = digits;
        if(carry > 0){
            ans = new int[n+1];
            ans[0] = 1;
            // 看了一下别人的解法，这个数组复制可以省略
            // 因为后面的数组进位后，值全为 0 ，和新建数组默认值一致
            System.arraycopy(digits,0,ans,1,n);
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/move-zeroes/
     * easy
     * 283. 移动零
     * 题解： 方法一：快慢指针，快指针遇到 0 则跳过
     *                将慢指针到尾部的数赋为0
     *        方法二:  {@link LeetCodeEasyArray#moveZeroesSlide(int[])}
     *                 双指针，维护一个值为 0 的窗口，进行滑动
     *                 右指针遇到 0 时，往前移动，非0时， 交换两个指针的值
     *                 这个方法，在时间复杂度上没有变，但是在操作上，减少了交换操作
     *                 是个最优的解
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[slow++] = nums[i];
            }
        }
        for(int i = slow; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    /**
     * 维护 0 窗口进行滑动交换
     * @param nums
     */
    public void moveZeroesSlide(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[slow];
                nums[slow] = nums[i];
                nums[i] = temp;
                slow++;
            }
        }
    }

    /**
     * https://leetcode-cn.com/problems/two-sum/
     * easy
     * 1. 两数之和
     *    以前做过，也用过这道题面试别人，印象比较深刻，代码简单，思路略过了
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer index = map.get(target - nums[i]);
            if(index != null){
                return new int[]{index,i};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }

    /**
     * https://leetcode-cn.com/problems/valid-sudoku/
     * medium
     * 36. 有效的数独
     * 思路：  模拟法，进行横纵，小九宫格检查
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                boolean row = validSudoUpdate(board[i][j], set1);
                boolean col = validSudoUpdate(board[j][i], set2);
                if (!col || !row){
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean val = validSudoSmall(board, i, j);
                if (!val){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean validSudoUpdate(char board,Set<Character> set){
        if (board != '.') {
            if (set.contains(board)) {
                return false;
            } else {
                set.add(board);
                return true;
            }
        }
        return true;
    }
    private boolean validSudoSmall(char[][] board,int row,int col){
        Set<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                boolean result = validSudoUpdate(board[i][j], set);
                if (!result){
                    return false;
                }
            }
        }
        return true;
    }


}
