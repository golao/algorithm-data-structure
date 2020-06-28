package org.golao.com.n2020;

import org.golao.com.algorithm.competition.LeetCodeContestD29;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode0625Test {
    private LeetCode0625 leetCode0625 = new LeetCode0625();
    @Test
    public void testWordBreak(){
        String[] input = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
                ,"a","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab","bb","catsandog","applepenapple","leetcode"};
        String[][] dicts = {{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"},{"a","b"},{"a","b"},{"a","b","bbb","bbbb"},{"cats", "dog", "sand", "and", "cat"},{"apple", "pen"},{"leet", "code"}};
        boolean[] ans = {false,true,true,true,false,true,true};
        for (int i = 0; i < ans.length; i++) {
            List<String> list = new ArrayList<>();
            Collections.addAll(list, dicts[i]);
            boolean result = leetCode0625.wordBreak(input[i],list);
            Assert.assertEquals(ans[i],result);
        }
    }

    @Test
    public void test(){
        int[][] input = {};
        int[] target = {};
        int[] ans = {};
        for (int i = 0; i < ans.length; i++) {
//            int result = leetCode0624.threeSumClosest(input[i], target[i]);
//            Assert.assertEquals(ans[i],result);
        }
    }


    @Test
    public void testRemoveDuplicateNode(){
        String[] input = {};
        String[] ans = {};
        for (int i = 0; i < ans.length; i++) {
//            int result = leetCode0624.threeSumClosest(input[i], target[i]);
//            Assert.assertEquals(ans[i],result);
        }
    }
    @Test
    public void testMIn(){
        int[][] input = {{7,8,9,11,12},{-1,0,-2,1,1,3,4},{1,2,4},{1,2,0},{1,2,3}};
        int[] ans = {1,2,3,3,4};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0625.firstMissingPositive(input[i]);
            Assert.assertEquals(ans[i],result);
        }
    }

    private LeetCodeContestD29 leetCodeContestD29 = new LeetCodeContestD29();
    @Test
    public void testContestD29_01(){
        int[][] input = {{4000,3000,1000,2000}};
        double[] ans = {};
        for (int i = 0; i < ans.length; i++) {

        }
    }
    @Test
    public void testContestD29_02(){
        int i = leetCodeContestD29.kthFactor(1000, 5);
        System.out.println(i);
    }
    @Test
    public void testContestD29_03(){
        int[][] input = {{1},{0},{0,0,0},{1,1,0,0,1,1,1,0,1},{1,1,0,1},{0,1,1,1,0,1,1,0,1},{1,1,1}};
        int[] ans = {0,0,0,4,3,5,2};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCodeContestD29.longestSubarray(input[i]);
            Assert.assertEquals(ans[i],result);
        }
    }




}
