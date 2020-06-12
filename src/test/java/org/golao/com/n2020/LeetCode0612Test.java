package org.golao.com.n2020;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode0612Test {
    private LeetCode0612 leetCode0612 = new LeetCode0612();
    @Test
    public void test1(){
        int[] ary ={-1,-2,0,1,Integer.MIN_VALUE,Integer.MAX_VALUE};
        for (int i = 0; i < ary.length; i++) {
            System.out.println(Integer.toBinaryString(ary[i]));
        }
        System.out.println(Integer.toUnsignedLong(-1));
        System.out.println(Integer.toUnsignedLong(-2));
        System.out.println(Integer.toUnsignedLong(1));
        System.out.println(Integer.toUnsignedLong(0));
        System.out.println(Integer.toUnsignedLong(Integer.MIN_VALUE));

    }
    @Test
    public void test2(){
        int a = -1;
        System.out.println((long)a);
        System.out.println(Long.toBinaryString(a));
        System.out.println(Long.toBinaryString(0xffffffffL));
        System.out.println(((long)a) & 0xffffffffL);
    }
    @Test
    public void test3() {
        long n32 = 9873467;
        String str  = n32 + "";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(str.toCharArray()));
    }

    @Test
    public void test0612() {
        int[] ary = {12,21,-1};
        for (int i = 0; i < ary.length; i++) {
            System.out.println(Integer.toUnsignedLong(ary[i]));
            int i1 = leetCode0612.nextGreaterElement(ary[i]);
            System.out.println("** ans **");
            System.out.println(Integer.toUnsignedLong(i1));
        }
    }

    }
