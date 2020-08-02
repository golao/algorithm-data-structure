package org.golao.com.n2020.m07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0727 {
    /**
     * https://leetcode-cn.com/problems/is-subsequence/
     * easy
     * 392. 判断子序列
     * 思路： 双指针
     *        1. s的长度范围 <= 100  t 长度 <= 500000
     *        2. s 每移动一位，都要在 t中寻找一个相等的，如找不到则返回false
     *        3. 全部匹配上，则返回true
     *        4. 时间复杂度: O(M + N) 分别为 s 的长度 加上 t 的长度
     *        5. 空间复杂度: O(1)   未使用额外空间
     *        6. 进阶： 如果输入  s1，s2，s3 ... sk 其中k >= 10 亿
     *           如何改进代码  {@link LeetCode0727#isSubsequenceII(String, String)}
     *        7. 二分查找，将复杂度下降到 mlogn dp则进一步降低了时间复杂度，达到了O(n)
     *           dp是看了官方题解，确实强大
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            while(start < t.length() && t.charAt(start) != s.charAt(i)){
                start++;
            }
            if(start >= t.length()){
                return false;
            }
        }
        return true;
    }

    /**
     * 思路： 1.对 t 进行预处理，因为都是小写字母，可以用二维数组存储对应字母和出现
     *         下标值
     *       2. 对s串匹配时， 按顺序，二分查找二维数组，只需取当前字母，对应的最小下标值
     *       3. 下一个字母匹配时，应取大于上一个字母下标的最小值
     *       4. 时间复杂度: O(MlogN) M 为 s 串长度
     *       5. 空间复杂度: O(n)
     * @param s
     * @param t
     * @return
     */
    private List<List<Integer>> alphabet = null;
    public boolean isSubsequenceII(String s, String t) {
        if (this.alphabet == null){
            this.alphabet = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                alphabet.add(new ArrayList<>());
            }
            for (int i = 0; i < t.length(); i++) {
                int index = t.charAt(i) - 'a';
                alphabet.get(index).add(i);
            }
        }
        int next = -1;
        for (int i = 0; i < s.length(); i++) {
            List<Integer> index = alphabet.get(s.charAt(i) - 'a');
            int left = 0, right = index.size() - 1;
            int pos = -1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (index.get(mid) > next){
                    pos = mid;
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            if (pos == -1){
                return false;
            }
            next = index.get(pos);
        }
        return true;
    }

    /**
     * 思路： 1. s 匹配 t时，大部分时间用来寻找下一个字母
     *        2. 根据以上，可以预处理t, f[i][j] 表示  t[i] 之后，j 字符出现的位置
     *        3. 如果 t[i] = j  那么  f[i][j] = i ; 否则，f[i][j] = f[i+1][j] , 仔细
     *           理解这个转移方程，可以得知，逆序处理 t 才是最佳方式
     *        4. 边界值： m = t.length()  , f[m][j] = m
     *        5. 根据以上可知，t 的预处理与 s 无关，所以可以处理后续需要大量匹配的 sk
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequenceDp(String s, String t) {
        int m = t.length();
        int[][] dp = new int[m + 1][26];
        Arrays.fill(dp[m], m);
        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a'){
                    dp[i][j] = i;
                }else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if (dp[start][pos] == m){
                return false;
            }
            start = dp[start][pos] + 1;
        }
        return true;
    }
}
