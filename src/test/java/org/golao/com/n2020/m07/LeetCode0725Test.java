package org.golao.com.n2020.m07;

import org.golao.com.algorithm.competition.LeetCodeContest199;
import org.golao.com.algorithm.competition.LeetCodeContestD31;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode0725Test {
    private LeetCodeContestD31 leetCodeContestD31 = new LeetCodeContestD31();
    @Test
    public void test(){
        String[] input = {"acbadbaada","abcd","a","aaaaa"};
        int[] ans = {2,1,0,4};
        for (int i = 0; i < ans.length; i++) {
            int sp = leetCodeContestD31.numSplits(input[i]);
            Assert.assertEquals(ans[i], sp);
        }
    }
    private LeetCodeContest199 leetCodeContest199 = new LeetCodeContest199();

    @Test
    public void test01(){
        String[] input = {""};
        int[][] index = {{}};
        String[] ans = {""};
        for (int i = 0; i < ans.length; i++) {
            String s = leetCodeContest199.restoreString(input[i], index[i]);
            Assert.assertEquals(ans[i], s);
        }
    }
    @Test
    public void test02(){
        String[] input = {"001011101","000","101","10111"};
        int[] ans = {5,0,3,3};
        for (int i = 0; i < ans.length; i++) {
            int s = leetCodeContest199.minFlips(input[i]);
            Assert.assertEquals(ans[i], s);
        }
    }
}
