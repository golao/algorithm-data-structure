package org.golao.com.n2020.m08;

import org.golao.com.algorithm.competition.LeetCodeContest200;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode0802Test {
    private LeetCodeContest200 leetCodeContest200 = new LeetCodeContest200();

    /**
     * [7,3,7,3,12,1,12,2,3]
     * 5
     * 8
     * 1
     */
    @Test
    public void test01(){
        int[][] input = {{7,3,7,3,12,1,12,2,3},{3,0,1,1,9,7}};
        int[] a = {5,7};
        int[] b = {8,2};
        int[] c = {1,3};
        int[] ans = {12,4};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCodeContest200.countGoodTriplets(input[i], a[i], b[i], c[i]);
            Assert.assertEquals(ans[i], result);
        }
    }
    @Test
    public void test02(){
        int[][] input = {{1,25,35,42,68,70},{2,1,3,5,4,6,7}};
        int[] k = {1,2};
        int[] ans ={25,5};
        for (int i = 0; i < ans.length; i++) {
            int winner = leetCodeContest200.getWinner(input[i], k[i]);
            Assert.assertEquals(ans[i], winner);
        }
    }

    @Test(timeout = 1000)
    public void test04(){
        int[][] n1 = {{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},{6,7,12,13,14,17,20},{1,3,5,7,9},{2,4,5,8,10}};
        int[][] n2 = {{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},{1,4,5,7},{3,5,100},{4,6,8,9}};
        int[] ans = {45,93,109,30};
        for (int i = 0; i < ans.length; i++) {
            int m = leetCodeContest200.maxSum(n1[i], n2[i]);
            Assert.assertEquals(ans[i], m);
        }
    }
    /**
     *
     */
}
