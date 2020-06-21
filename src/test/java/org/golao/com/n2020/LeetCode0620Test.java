package org.golao.com.n2020;

import org.golao.com.algorithm.competition.LeetCodeContestD28;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode0620Test {
    private LeetCodeContestD28 leetCodeContestD28 = new LeetCodeContestD28();
    @Test
    public void testMinDistance(){
        int[][] input1 = {{1,8,12,10,3},{1,4,8,10,20},{2,3,5,12,18},{7,4,6,1},{3,6,14,10}};
        int[] input2 = {3,3,2,1,4};
        int[] ans = {4,5,9,8,0};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCodeContestD28.minDistance(input1[i], input2[i]);
            Assert.assertEquals(ans[i], result);
        }
    }

    private LeetCode0619 leetCode0619 = new LeetCode0619();
    @Test
    public void maxSubArray(){
        int[][] intput = {{-2,1,-3,4,-1,2,1,-5,4},{-1,0,-2}};
        int[] ans = {6,0};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0619.maxSubArray(intput[i]);
            System.out.println(result);
        }
    }
}
