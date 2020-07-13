package org.golao.com.n2020.topic;

import org.golao.com.algorithm.topic.medium.LeetCodeMediumDynamicProgramming;
import org.junit.Assert;
import org.junit.Test;

public class LeetCodeMediumTest {
    private LeetCodeMediumDynamicProgramming dynamicProgramming = new LeetCodeMediumDynamicProgramming();
    @Test
    public void test(){
        int[][] coins = {{1,2,5}};
        int[] amount = {5};
        int[] ans = {4};
        for (int i = 0; i < ans.length; i++) {
            int change = dynamicProgramming.change(amount[i], coins[i]);
            Assert.assertEquals(ans[i], change);
        }
    }
}
