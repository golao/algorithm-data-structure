package org.golao.com.n2020.m07;

import org.golao.com.algorithm.topic.easy.LeetCodeEasyOthers;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LeetCode0701Test {
    private LeetCode0701 leetCode0701 = new LeetCode0701();
    @Test
    public void test01(){
        int[][] inputA = {{1},{1},{1,2,3,2,1}};
        int[][] inputB = {{1},{2},{3,2,1,4,7}};
        int[] ans = {1,0,3};
        for (int i = 0; i < ans.length; i++) {
            int length = leetCode0701.findLengthII(inputA[i], inputB[i]);
            Assert.assertEquals(ans[i],length);
        }
    }

    private LeetCodeEasyOthers leetCodeEasyOthers = new LeetCodeEasyOthers();
    @Test
    public void testPrimes(){
        long start = System.currentTimeMillis();
        int result = leetCodeEasyOthers.countPrimes(600_0000);
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
    @Test
    public void testThreePower(){
        int[] input = {1162261467,1,2};
        boolean[] ans = {true,true,false};
        for (int i = 0; i < ans.length; i++) {
            boolean powerOfThree = leetCodeEasyOthers.isPowerOfThree(input[i]);
            Assert.assertEquals(ans[i],powerOfThree);
        }
    }

    @Test
    public void testRomanNumber(){
        String[] input = {"LXXX","XL","MCMXCIV","IX","IV","VI"};
        int[] ans = {80,40,1994,9,4,6};
        for (int i = 0; i < ans.length; i++) {
            int roman = leetCodeEasyOthers.romanToInt(input[i]);
            Assert.assertEquals(ans[i],roman);
        }
        Integer a = 1;
    }

    @Test(timeout = 1000)
    public void testBit(){
        Integer a = -3;
        int i = leetCodeEasyOthers.reverseBits(a);
        System.out.println(Integer.toUnsignedString(i,2));
        //   System.out.println(Integer.toBinaryString(a));
    }

    @Test
    public void testInt(){
        int INF = (int)-1e8;
        System.out.println(INF);
        System.out.println(2 << 1);
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        System.out.println(left - Integer.MIN_VALUE);
        System.out.println(left + Integer.MIN_VALUE);
        System.out.println(left + right);
        System.out.println(left);
        System.out.println(left % 2);
    }

    private LeetCode0702 leetCode0702 = new LeetCode0702();
    @Test(timeout = 1000)
    public void testKsmall(){
        int[][][] input = {
                {{4,5},{4,5}},
                {{-5,-4},{-5,-4}},
        };
        int[] k = {3,3};
        int[] ans = {5,-4};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0702.kthSmallest(input[i], k[i]);
            Assert.assertEquals(ans[i], result);
        }
    }

}
