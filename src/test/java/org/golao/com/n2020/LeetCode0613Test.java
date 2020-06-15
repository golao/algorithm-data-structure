package org.golao.com.n2020;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode0613Test {
    private LeetCode0613 leetCode0613 = new LeetCode0613();
    @Test
    public void test1(){
        int[] ary = {1,2,3,4,5};
        int[] ans = {1,2,3,5,8};
        for (int i = 0; i < ary.length; i++) {
            int i1 = leetCode0613.climbStairs(ary[i]);
            Assert.assertEquals(ans[i],i1);
        }
    }
}
