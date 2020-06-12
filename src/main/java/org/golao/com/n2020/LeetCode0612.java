package org.golao.com.n2020;

import java.util.Arrays;

public class LeetCode0612 {
    /**
     * https://leetcode-cn.com/problems/next-greater-element-iii/
     * 难度 ： medium
     * 题解： 1.关键在准确理解 32位正整数，题目一再加黑强调32位，就是怕理解错了。
     *        2. Java 的 int 类型是32位，但第一位是符号位，实际只有31位，现在把
     *           符号位也用上了，需要做一次特殊处理，转成 long 型
     *        3. 构造一个最小的整数
     *           1)
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        long n32 = Integer.toUnsignedLong(n);
        char[] chars = (n32 + "").toCharArray();
        Arrays.sort(chars);
        int first = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0'){
                first = i;
                break;
            }
        }
        char[] min = new char[chars.length];
        min[0] = chars[first];
        int j = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i == first){
                continue;
            }
            min[j++] = chars[i];
        }
        long parseLong = Long.parseLong(new String(min));
        if (parseLong >= n32){
            return -1;
        }
        return (int)parseLong;
    }
}
