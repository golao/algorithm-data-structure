package org.golao.com.n2020;

import org.golao.com.algorithm.competition.LeetCodeContest195;
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
}
