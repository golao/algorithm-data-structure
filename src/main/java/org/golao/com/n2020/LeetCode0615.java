package org.golao.com.n2020;

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
}
