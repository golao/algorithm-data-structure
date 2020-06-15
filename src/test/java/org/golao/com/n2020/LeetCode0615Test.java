package org.golao.com.n2020;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeetCode0615Test {
    private LeetCode0615 leetCode0615 = new LeetCode0615();

    @Test
    public void test1(){
        String[] str = {"a","bc","abc","bcadf"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
    }
    @Test
    public void test2(){
        String[][] strs = {
                {"flower","flow","flight"},
                {"dog","racecar","car"},
                {},
                {"abcdefgh", "ab"}
        };
        String[] ans = {
                "fl",
                "",
                "",
                "ab"
        };
        for (int i = 0; i < strs.length; i++) {
            String s = leetCode0615.longestCommonPrefix(strs[i]);
            Assert.assertEquals(s, ans[i]);
            System.out.println(s);
        }
    }

}
