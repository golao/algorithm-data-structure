package org.golao.com.algorithm.topic.medium;

import java.util.*;
import java.util.function.Function;

/**
 * 专题： 数组与字符串
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium
 */
public class LeetCodeMediumArrayAndString {
    /**
     * https://leetcode-cn.com/problems/3sum/
     * 15. 三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        return null;
    }

    /**
     * https://leetcode-cn.com/problems/set-matrix-zeroes/
     * 73. 矩阵置零
     * 思路：   方法一： 用O(m + n) 额外空间，记录横纵，然后修改即可
     * 方法二： 题目要求使用常数空间
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

    }

    /**
     * https://leetcode-cn.com/problems/group-anagrams/
     * 49. 字母异位词分组
     * 思路：
     * 方法一： 将字符串排序后，放入map中
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            List<String> list = map.computeIfAbsent(sortStr, x -> new ArrayList<String>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
     * 334. 递增的三元子序列
     * 思路 ：  设置两个值，small ，mid
     *          1. 当nums[i] 小于等于 small ，交换
     *          2. 当 nums[i] 大于 small   且小于 mid  ，交换
     *          3. 当 nums[i] 大于 mid  说明找到第三个数了，返回true
     *          4. 时间复杂度: O(n)
     *          5. 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n < mid) {
                mid = n;
            }
            if (n > mid) {
                return true;
            }
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     * 3. 无重复字符的最长子串
     * 思路： 滑动窗口 + 哈希表
     *        1. left ，right 指向起始坐标 0
     *        2. right 在没有重复时，往右移动，遇到重复时停止
     *        3. 此时 right - left 是当前以 left 为起点所能达到的最长的无重复子串
     *        4. 移动left，并删除哈希表中left指向的字符，直到哈希表中不存在重复字符
     *        5. 重复 2 步骤，维持一个最长子串变量
     *        6. 时间复杂度: O(n)
     *        7. 空间复杂度: O(1) 最多26个字母，当然题目没特意说明一定是字母，所以
     *           复杂度也可能是 n
     *        8. 双指针的编码技巧，之前做了这题，现在写的代码更简洁了，真熟能生巧
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
            }
            ans = Math.max(ans, right - i);
            set.remove(s.charAt(i));
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     * 5. 最长回文子串
     * 方法一： 动态规划
     *          1. 放在字符串和数组专题，思维上没往这个方向想
     *          2. dp[i][j] = dp[i+1][j-1] && (s[i] == s[j])
     *          3. i -> j 形成的子串，只有在  i+1  ->  j-1 是回文，且 s[i] == s[j]
     *             的情况下，才是回文串。
     *          4. 这里有效的利用了子问题的解
     *          5. 回文串的边界情况：  1) 一个字符  true
     *                                 2) 两个字符  s[i] == s[j]
     *          6. 维持一个变量最长串
     *          7. 时间复杂度: O(n²)
     *          8. 空间复杂度: O(n²)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if (len == 0){
                    dp[i][j] = true;
                }else if(len == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && len > ans.length() - 1){
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }
}
