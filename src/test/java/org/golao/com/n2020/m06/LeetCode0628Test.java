package org.golao.com.n2020.m06;

import org.golao.com.algorithm.competition.LeetCodeContest195;
import org.golao.com.algorithm.topic.easy.LeetCodeEasyArray;
import org.golao.com.algorithm.topic.easy.LeetCodeEasyString;
import org.golao.com.n2020.m06.LeetCode0628;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode0628Test {
    private LeetCode0628 leetCode0628 = new LeetCode0628();
    @Test
    public void test(){
        int[][] intput = {{7,2,5},{2,3,1,2,4,3}};
        int[] k = {7,7};
        int[] ans = {1,2};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0628.minSubArrayLen(k[i], intput[i]);
            Assert.assertEquals(ans[i],result);
        }
    }

    private LeetCodeContest195 leetCodeContest195 = new LeetCodeContest195();
    @Test
    public void test02(){
        int[][] intput = {{-4,-7,5,2,9,1,10,4,-8,-3},{-1,1,-2,2,-3,3,-4,4},{-10,10},{1,2,3,4,5,10,6,7,8,9},{1,2,3,4,5,6}};
        int[] k = {3,3,2,5,7};
        boolean[] ans = {true,true,true,true,true};
        for (int i = 0; i < ans.length; i++) {
            boolean result = leetCodeContest195.canArrange(intput[i],k[i]);
            Assert.assertEquals(ans[i],result);
        }
    }

    private LeetCodeEasyArray leetCodeEasyArray = new LeetCodeEasyArray();
    @Test
    public void testArray01(){
        int[][] intput = {{-1,-100,3,99},{1,2,3}};
        int[][] ans = {{3,99,-1,-100},{3,1,2}};
        int[] k = {2,1};
        for (int i = 0; i < k.length; i++) {
            leetCodeEasyArray.rotate(intput[i],k[i]);
            Assert.assertArrayEquals(ans[i],intput[i]);
        }
    }
    @Test
    public void testArray02(){
        int[][] intput = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] ans = {{3,99,-1,-100},{3,1,2}};
        int[] k = {2,1};
        for (int i = 0; i < k.length; i++) {
            leetCodeEasyArray.rotate(intput);
            Assert.assertArrayEquals(ans[i],intput[i]);
        }
    }

    private LeetCodeEasyString leetCodeEasyString = new LeetCodeEasyString();
    @Test
    public void testString01(){
        StringBuilder builder = new StringBuilder();
        builder.append(Integer.MIN_VALUE);
        "".toCharArray();
        System.out.println(builder.reverse().toString());
    }


}
