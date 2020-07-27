package org.golao.com.n2020.m07;

import org.golao.com.algorithm.competition.LeetCodeContest198;
import org.golao.com.algorithm.topic.TopologicalOrder;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode0716Test {
    private LeetCode0715 leetCode0715 = new LeetCode0715();
    @Test
    public void testBipartite(){
        int[][][] graphs = {
                {{1,3}, {0,2}, {1,3}, {0,2}},
                {{1,2,3}, {0,2}, {0,1,3}, {0,2}}
        };
        boolean[] ans = {true,false};
        for (int i = 0; i < ans.length; i++) {
            boolean bipartite = leetCode0715.isBipartiteBFS(graphs[i]);
            Assert.assertEquals(ans[i], bipartite);
        }
    }

    @Test
    public void testBinarySearch(){
        int[][] input = {{4,5,6},{1,3,5,6},{1,3,5,6},{1,3,4}};
        int[] targets = {3,7,2,2};
        int[] ans = {0,4,1,1};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0715.searchInsert(input[i], targets[i]);
            Assert.assertEquals(ans[i], result);
        }
    }

    @Test
    public void testDp(){
        String[] s1 = {"abc","aabcc","abc"};
        String[] s2 = {"abb","dbbca","abb"};
        String[] s3 = {"aabcbb","aadbbcbcac","abbabc"};
        boolean[] ans = {true,true,true};
        for (int i = 0; i < ans.length; i++) {
            boolean interleave = leetCode0715.isInterleave(s1[i], s2[i], s3[i]);
            Assert.assertEquals(ans[i], interleave);
        }
    }

    private TopologicalOrder topological = new TopologicalOrder();
    @Test(timeout = 1000)
    public void testTopologicalOrder(){
        int[] nums = {2,2};
        int[][][] input = {{{1,0},{0,1}},{{1,0}}};
        boolean[] ans = {false,true};
        for (int i = 0; i < ans.length; i++) {
            boolean canFinish = topological.canFinish(nums[i], input[i]);
            Assert.assertEquals(ans[i], canFinish);
        }
    }

    private LeetCodeContest198 leetCodeContest198 = new LeetCodeContest198();
    @Test(timeout = 1000)
    public void test198_1(){
        int[] input = {3};
        int[] input2 = {2};
        int[] ans = {5};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCodeContest198.numWaterBottles(input[i], input2[i]);
            Assert.assertEquals(ans[i], result);
        }
    }

    @Test(timeout = 1000)
    public void test198_2(){
        int[] n = {4,7};
        int[][][] input = {{{0,2},{0,3},{1,2}},{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}};
        String[] lables = {"aeed","abaedcd"};
        int[][] ans = {{1,1,2,1},{2,1,1,1,1,1,1}};
        for (int i = 0; i < ans.length; i++) {
            int[] countSubTrees = leetCodeContest198.countSubTrees(n[i], input[i], lables[i]);
            Assert.assertArrayEquals(ans[i], countSubTrees);
        }
    }


}
