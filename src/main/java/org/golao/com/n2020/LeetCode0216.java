package org.golao.com.n2020;

import java.util.Arrays;

/**
 * Created by golao on 2020/2/16.
 */
public class LeetCode0216 {
    public static void main(String[] args) {
        int max = 9;
        int r = max--;
        System.out.println(r);
        System.out.println(max);
        LeetCode0216 lc = new LeetCode0216();
        int[] ary = {-3,-2,0,5};
        System.out.println(Arrays.toString(lc.sortedSquares(ary)));
    }
    /**
     * 难度:简单
     * 思路: 遇到 I 拿当前序列最小，遇到 D 拿当前序列最大
     * https://leetcode-cn.com/problems/di-string-match/
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        int max = S.length();
        int min = 0;
        int[] result = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            result[i] = S.charAt(i) == 'D' ? max-- : min++;
        }
        result[S.length()] = max;
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     * 难度：简单
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
