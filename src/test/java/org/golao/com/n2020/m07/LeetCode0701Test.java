package org.golao.com.n2020.m07;

import org.golao.com.algorithm.topic.easy.LeetCodeEasyOthers;
import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void testBit(){
        Integer a = 1;
        
        System.out.println(Integer.toBinaryString(a));
    }


}
