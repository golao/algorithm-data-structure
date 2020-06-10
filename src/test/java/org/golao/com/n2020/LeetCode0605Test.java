package org.golao.com.n2020;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode0605Test {
    private LeetCode0605 leetCode0605 = new LeetCode0605();

    @Test
    public void test(){
//        int[][] ary = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] ary =  { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        int[] ints = leetCode0605.spiralOrder(ary);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void lengthOfLongestSubstringTest(){
        String[] strings = {"",null,"afeabcd","pwwkew","dvdf","asjrgapa","asjrgapa"};
        for (String s : strings) {
            int length = this.leetCode0605.lengthOfLongestSubstring(s);
            System.out.println(length);
        }
    }
}
