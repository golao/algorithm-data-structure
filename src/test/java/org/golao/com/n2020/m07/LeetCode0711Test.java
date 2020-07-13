package org.golao.com.n2020.m07;

import org.golao.com.algorithm.competition.LeetCodeContest197;
import org.golao.com.algorithm.competition.LeetCodeContestD30;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode0711Test {
    private LeetCodeContestD30 leetCodeContestD30 = new LeetCodeContestD30();
    @Test
    public void test01(){

        String[] input = {"20th Oct 2052","6th Jun 1933"};
        String[] ans = {"2052-10-20","1933-06-06"};
        for (int i = 0; i < ans.length; i++) {
            String s = leetCodeContestD30.reformatDate(input[i]);
            Assert.assertEquals(ans[i],s);
        }
    }

    @Test
    public void test04(){
        int[] input = {1,2,3,4,5,6};
        boolean[] ans = {true,false,true,true,false,true};
        for (int i = 0; i < ans.length; i++) {
            boolean b = leetCodeContestD30.winnerSquareGame(input[i]);
            Assert.assertEquals(ans[i] , b);
        }
    }

    private LeetCodeContest197 leetCodeContest197 = new LeetCodeContest197();
    @Test
    public void test97_1(){
        int[][] input = {{1,2,3},{1,2,3,1,1,3},{1,1,1,1}};
        int[] ans = {0,4,6};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCodeContest197.numIdenticalPairs(input[i]);
            Assert.assertEquals(ans[i], result);
        }
    }
    @Test
    public void test97_02(){
        String[] input = {"0000","111111","0110111"};
        int[] ans = {0,21,9};
        for (int i = 0; i < ans.length; i++) {
           int result = leetCodeContest197.numSub(input[i]);
            Assert.assertEquals(ans[i], result);
        }
    }
}
