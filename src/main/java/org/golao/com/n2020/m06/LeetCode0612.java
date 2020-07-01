package org.golao.com.n2020.m06;

import java.util.*;

public class LeetCode0612 {
    /**
     * https://leetcode-cn.com/problems/next-greater-element-iii/
     * 难度 ： medium
     * 题解： 1.关键在准确理解 32位正整数，题目一再加黑强调32位，就是怕理解错了。
     *        2. Java 的 int 类型是32位，但第一位是符号位，实际只有31位，现在把
     *           符号位也用上了，需要做一次特殊处理，转成 long 型
     *        3. 构造一个最小的整数  -- 理解错题意，是找到一个最小的大于n的数
     *           1)见力扣题解
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        long n32 = Integer.toUnsignedLong(n);
        char[] chars = (n32 + "").toCharArray();
        char[] cs = new char[chars.length];
        int j = 0;
        int index = chars.length - 1;
        cs[j] = chars[index--];
        while (index >= 0 && chars[index] >= cs[j]){
            j++;
            cs[j] = chars[index--];
        }
        if (index < 0){
            return -1;
        }
        for (int i = 0; i < cs.length; i++) {
            if (chars[index] < cs[i]){
                char temp = chars[index];
                chars[index] = cs[i];
                cs[i] = temp;
                break;
            }
        }
        j = 0;
        for (int i = index+1; i < chars.length; i++) {
            chars[i] = cs[j++];
        }

        long ans = Long.parseLong(new String(chars));
        if (ans > Integer.toUnsignedLong(-1)){
            return -1;
        }
        return (int)ans;
    }

    public int nextGreaterElementI(int n) {
        char[] chars = (n + "").toCharArray();
        char[] cs = new char[chars.length];
        int j = 0;
        int index = chars.length - 1;
        cs[j] = chars[index--];
        while (index >= 0 && chars[index] >= cs[j]){
            j++;
            cs[j] = chars[index--];
        }
        if (index < 0){
            return -1;
        }
        for (int i = 0; i < cs.length; i++) {
            if (chars[index] < cs[i]){
                char temp = chars[index];
                chars[index] = cs[i];
                cs[i] = temp;
                break;
            }
        }
        j = 0;
        for (int i = index+1; i < chars.length; i++) {
            chars[i] = cs[j++];
        }

        long ans = Long.parseLong(new String(chars));
        if (ans > Integer.MAX_VALUE){
            return -1;
        }
        return (int)ans;
    }
}
