package org.golao.com.n2020;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test3(){
        int[][] ary = {
                {-1,2,1,-4}
        };
        int[] target = {1};
        int[] ans = {2};
        for (int i = 0; i < ary.length; i++) {
            int i1 = leetCode0615.threeSumClosest(ary[i], target[i]);
            Assert.assertEquals(ans[i], i1);
        }
    }
    @Test
    public void test4(){
        int[][] ary = {
                {1, 0, -1, 0, -2, 2},
                {0,4,-5,2,-2,4,2,-1,4},
                {0,2,2,4,4,4}
        };
        int[] target = {0, 12,12};
        for (int i = 0; i < ary.length; i++) {
            List<List<Integer>> lists = leetCode0615.fourSum(ary[i], target[i]);
            for (List<Integer> list : lists) {
                System.out.println(list);
            }
//            Assert.assertEquals(ans[i], i1);
        }
    }

}
