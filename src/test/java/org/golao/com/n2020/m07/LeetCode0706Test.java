package org.golao.com.n2020.m07;

import org.golao.com.algorithm.topic.easy.LeetCodeEasyString;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode0706Test {
    private LeetCode0705 leetCode0705 = new LeetCode0705();
    @Test
    public void test(){
        int[][][] input = {
                {{0,0,0},{0,1,0},{0,0,0}}
        };
        int[] ans = {2};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0705.uniquePathsWithObstaclesOn(input[i]);
            Assert.assertEquals(ans[i],result);
        }
    }

    LeetCodeEasyString leetCodeEasyString = new LeetCodeEasyString();
    @Test
    public void test02(){
        int[] input = {1,2,3,4,5,6,7};
        String[] ans = {"1","11","21","1211","111221","312211","13112221"};
        for (int i = 0; i < ans.length; i++) {
            String s = leetCodeEasyString.countAndSay(input[i]);
            Assert.assertEquals(ans[i], s);
        }
    }

    @Test
    public void testAppend(){
        StringBuilder builder = new StringBuilder();
        builder.append("ab");
        builder.append("c");
        System.out.println(builder.toString());
    }
}
