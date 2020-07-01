package org.golao.com.n2020.m03;

/**
 * Created by golao on 2020/3/4.
 */
public class LeetCode0304 {
    /**
     * 难度：简单
     * https://leetcode-cn.com/problems/reverse-string/
     * 两思路
     * 1. 递归利用栈交换头尾字母
     * 2. 循环利用双指针交换
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
