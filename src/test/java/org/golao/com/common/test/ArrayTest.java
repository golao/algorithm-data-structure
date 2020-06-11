package org.golao.com.common.test;

import org.golao.com.n2020.LeetCode0606;
import org.golao.com.n2020.LeetCode0610;
import org.junit.Test;

/**
 * 2020.06.09
 */
public class ArrayTest {

    private LeetCode0606 leetCode0606 = new LeetCode0606();
    private LeetCode0610 leetCode0610 = new LeetCode0610();
    @Test
    public void test1(){
        int[][] ary = {
                {100, 4, 200, 1, 3, 2},
                {1,2,100,101,4,105,104,1000,10001,103,10892,102},
                {-1,100,-2,1,0},
                {-3,-2,-1,0,1,2,3},
                {-3,-2,-5,-9,-8,-7,-6},
                {1,3,5,2,4},
                {1,2,3,4,5},
                {21_4748_3646,-21_4748_3647,0,2,21_4748_3644,-21_4748_3645,21_4748_3645}
        };
        for (int[] a : ary) {
            int i = leetCode0606.longestConsecutive(a);
            int i1 = leetCode0606.longestConsecutiveLeetCode(a);
            System.out.println(i == i1);
            System.out.println(i);
        }
    }

    @Test
    public void test0610(){
        int[][] ary = {
                {},
                {1},
                {2,3,2},
                {1,2,3,1},
                {3,0,0,2},
                {2,7,9,3,1},
//                {10,1,10,100},
//                {10,1,10,100,200},
//                {10,1,10,100,200,200},
        };
        for (int[] a : ary) {
//            int rob = leetCode0610.rob(a);
//            int i = leetCode0610.robOpt(a);
            int i = leetCode0610.robII(a);
            System.out.println(i);
//            System.out.println(rob == i);
        }
    }
    @Test
    public void test0610_1(){
        int[][] ary = {
                {},
                {1},
                {1,2,1,2,3},
                {1,2,1,3,4},
        };
        int[] aK = {1,1,2,3};
        for (int i = 0; i < ary.length; i++) {
            int ans = leetCode0610.subarraysWithKDistinct(ary[i],aK[i]);
            System.out.println(ans);
        }
    }


    @Test
    public void testMod(){
        System.out.println(-0 / 3);
        System.out.println(-1 % 3);
        System.out.println(-2 % 3);
        System.out.println(-3 % 3);
        System.out.println(-4 % 3);
        System.out.println(-5 % 3);
        System.out.println(0 % 3);
        System.out.println(1 % 3);
    }
}
