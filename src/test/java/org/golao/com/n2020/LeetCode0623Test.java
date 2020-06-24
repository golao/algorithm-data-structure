package org.golao.com.n2020;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LeetCode0623Test {
    private LeetCode0623 leetCode0623 = new LeetCode0623();
    @Test
    public void test1(){
        String[] inputA = {"11","1010","11111"};
        String[] inputB = {"1","1011","1111111111"};
        String[] ans = {"100","10101","10000011110"};
        for (int i = 0; i < ans.length; i++) {
//            String binary = leetCode0623.addBinary(inputA[i], inputB[i]);
            String binary = leetCode0623.addBinaryLeetCode(inputA[i], inputB[i]);
            Assert.assertEquals(ans[i],binary);
        }
    }
    @Test
    public void testSet(){
        Set<Integer> set = new HashSet<>();
        int mod = 4;
        int k = 8;
        set.add(1);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        //ConcurrentModificationException
        while (iterator.hasNext()){
            Integer next = iterator.next();
            int m = (next + mod) % k;
            set.add(m);
        }
        System.out.println(set);
    }
    @Test
    public void testCheckSubarraySum(){
        int[][] input = {{0,1},{23,2,4,6,7},{23,2,6,4,7},{100,99},{5,5,5,2,3,34,6}};
        int[] k = {0,6,6,100,5};
        boolean[] ans = {false,true,true,false,true};
        for (int i = 0; i < ans.length; i++) {
            boolean result = leetCode0623.checkSubarraySumLeetCode(input[i], k[i]);
            Assert.assertEquals(ans[i], result);
        }
    }

    @Test
    public void testRemoveElement(){
        int[][] input = {{0,1,2,2,3,0,4,2},{1}};
        int[] val = {2,1};
        int[] ans = {5,0};
        int[][] arys = {{0,1,4,0,3},{}};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0623.removeElement(input[i],val[i]);
            Arrays.sort(arys[i]);
            int[] ints = Arrays.copyOfRange(input[i], 0, ans[i]);
            Arrays.sort(ints);
            Assert.assertArrayEquals(arys[i],ints);
            System.out.println(Arrays.toString(input[i]));
            Assert.assertEquals(ans[i], result);
        }
    }

}
