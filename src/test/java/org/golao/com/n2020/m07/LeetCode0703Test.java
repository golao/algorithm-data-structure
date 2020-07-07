package org.golao.com.n2020.m07;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode0703Test {
    private LeetCode0703 leetCode0703 = new LeetCode0703();
    @Test(timeout = 1000)
    public void testPickCherr(){
        int[][][] input = {
                {{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}
                ,{{3,1,1},{2,5,1},{1,5,5},{2,1,1}}
                ,{{1,1},{1,1}}
                ,{{1,0,0,3},{0,0,0,3},{0,0,3,3},{9,0,3,3}}
        };
        int[] ans = {28,24,4,22};
        for (int i = 0; i < ans.length; i++) {
            int pick = leetCode0703.cherryPickupII(input[i]);
            Assert.assertEquals(ans[i],pick);
        }
    }
}
