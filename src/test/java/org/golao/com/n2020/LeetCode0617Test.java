package org.golao.com.n2020;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode0617Test {
    private LeetCode0617 leetCode0617 = new LeetCode0617();
    @Test
    public void test0617(){
        int[][] ary = {
                {8,1,5,2,6},
                {1,5,5,2,6,5},
        };
        int[] k = {2,3,2};
        int[] ans = {11,10};
        for (int i = 0; i < ary.length; i++) {
            int kDistinct = leetCode0617.maxScoreSightseeingPair(ary[i]);
            Assert.assertEquals(ans[i], kDistinct);
        }
    }
}
