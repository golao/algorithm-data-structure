package org.golao.com.n2020;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeetCode0611Test {
    private LeetCode0611 leetCode0611 = new LeetCode0611();

    @Test
    public void test1(){
        int[][] ary = {
                {1},
                {30,30,30,30,30,30},
                {73, 74, 75, 71, 69, 72, 76, 73},
        };
        int[][] ans = {
                {0},
                {0,0,0,0,0,0},
                {1, 1, 4, 2, 1, 1, 0, 0},
        };
        for (int i = 0; i < ary.length; i++) {
            int[] ints = leetCode0611.dailyTemperatures(ary[i]);
            int[] opt = leetCode0611.dailyTemperaturesOpt(ary[i]);
            System.out.println(Arrays.toString(ints));
//            boolean equals = Arrays.equals(ints, ans[i]);
            boolean equals = Arrays.equals(ints, opt);
            Assert.assertTrue(equals);
            int[] optI = leetCode0611.dailyTemperaturesOptI(ary[i]);
            Assert.assertArrayEquals(opt, optI);

        }
    }

    @Test
    public void test2(){
        int[][] ary1 = {
                {2,4},
                {4,1,2},
                {1},
        };
        int[][] ary2 = {
                {1,2,3,4},
                {1,3,4,2},
                {1},
        };
        int[][] ans = {
                {3,-1},
                {-1,3,-1},
                {-1},
        };

        for (int i = 0; i < ary1.length; i++) {
            int[] optI = leetCode0611.nextGreaterElement(ary1[i],ary2[i]);
            Assert.assertArrayEquals(ans[i], optI);
        }
    }

    @Test
    public void testIII(){
        int[][] ary1 = {
                {1,2,1},
                {2,4},
                {1},
                {1,1,1,1},
                {-1,-1,-1,-1},
        };

        int[][] ans = {
                {2,-1,2},
                {4,-1},
                {-1},
                {-1,-1,-1,-1},
                {-1,-1,-1,-1},
        };

        for (int i = 0; i < ary1.length; i++) {
            int[] optI = leetCode0611.nextGreaterElementsII(ary1[i]);
            Assert.assertArrayEquals(ans[i], optI);
        }
    }

}
