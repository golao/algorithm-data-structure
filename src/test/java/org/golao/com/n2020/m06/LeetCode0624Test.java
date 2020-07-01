package org.golao.com.n2020.m06;

import org.golao.com.n2020.m06.LeetCode0624;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode0624Test {
    private LeetCode0624 leetCode0624 = new LeetCode0624();

    /**
     * 测试模板代码
     */
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
    public void testTreeSum(){
        int[][] input = {{1,2,4,8,16,32,64,128},{-1,2,1,-4},{2,-9,8,1},{1,1,1,4,2,1,1}};
        int[] target = {82,1,5,4};
        int[] ans = {82,2,1,4};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0624.threeSumClosest(input[i], target[i]);
            Assert.assertEquals(ans[i],result);
        }
    }

}
