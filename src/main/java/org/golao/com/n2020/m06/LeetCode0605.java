package org.golao.com.n2020.m06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode0605 {
    /**
     * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
     * 难度：简单
     * 题解： 维护四个界  left right top bottom,四个指针顺时针进行移动即可；
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        int ansSize = matrix.length * matrix[0].length;
        int[] ans = new int[ansSize];
        int left = 0,right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        int i = 0;
        while (i < ansSize){
            //left to right
            for (int j = left; j <= right && i < ansSize; j++) {
                ans[i] = matrix[top][j];
                i++;
            }
            top++;
            //top to bottom
            for (int j = top; j <= bottom && i < ansSize; j++) {
                ans[i] = matrix[j][right];
                i++;
            }
            right--;
            //right to left
            for (int j = right; j >= left && i < ansSize; j--) {
                ans[i] = matrix[bottom][j];
                i++;
            }
            bottom--;
            //bottom to top
            for (int j = bottom; j >= top && i < ansSize; j--) {
                ans[i] = matrix[j][left];
                i++;
            }
            left++;
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     * 难度：中等
     * 题解： 维护一个最长不重复子序列值  max
     *        遍历字符串，set存储字符，重复则重新开始计数，不重复则加一
     * 复杂度： 时间复杂度O(n)
     *          空间复杂度，额外set开销，O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //特例处理
        if (s == null || s.isEmpty()){
            return 0;
        }
        int left = 0, right = -1;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            right = i;
            if (set.contains(s.charAt(i))){
                max = Math.max(max, right - left);
                while (s.charAt(left) != s.charAt(i)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }else {
                set.add(s.charAt(i));
            }

        }
        return Math.max(max,right - left + 1);
    }

    private void updateSet(int start,int a,int now,String s,Set<Character> set){
        //重复的字符，在子串s中，位置靠前，所以移除 a 位置前面的字符，操作数更少
        if ((start + now) > (2 * a)){
            for (int i = start; i <= a; i++) {
                set.remove(s.charAt(i));
            }
        }else {//反之，则a的位置靠后，清除set，并重新添加a到now位置的字符，操作更少
            set.clear();
            for (int i = a+1; i < now; i++) {
                set.add(s.charAt(i));
            }
        }
        //
    }
}
