package org.golao.com.n2020.m06;

import org.golao.com.n2020.m06.LeetCode0614;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode0614Test {
    private LeetCode0614 leetCode0614 = new LeetCode0614();
    @Test
    public void test(){
        int[][] ary = {
                {4,9,3},
                {2,3,5},
                {60864,25176,27249,21296,20204},
                {2,3,5}
        };
        int[] targets = {10, 10, 56803,11};
        int[] ans = {3, 5, 11361,5};
        for (int i = 0; i < ary.length; i++) {
            int bestValue = leetCode0614.findBestValue(ary[i], targets[i]);
            Assert.assertEquals(ans[i],bestValue);
        }
    }
}
