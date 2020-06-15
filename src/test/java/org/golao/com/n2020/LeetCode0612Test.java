package org.golao.com.n2020;

import org.golao.com.algorithm.competition.LeetCodeContestD28;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode0612Test {
    private LeetCode0612 leetCode0612 = new LeetCode0612();
    @Test
    public void test1(){
//        int[] ary = {-1,-2,0,1,Integer.MIN_VALUE,Integer.MAX_VALUE};
        int[] ary = {1024321,1,12,21,987654321,123456,1234321,2147483647};
        int[] ans = {1031224,-1,21,-1,-1,123465,1241233,-1};
        for (int i = 0; i < ary.length; i++) {
            System.out.println("ary[i] = " + ary[i] + " binary = " + Integer.toBinaryString( ary[i]));
        System.out.println("long " + Integer.toUnsignedLong( ary[i]));
            int i1 = leetCode0612.nextGreaterElementI(ary[i]);
            System.out.println("int = "+ i1 + " long = " + Integer.toUnsignedLong(i1));
            Assert.assertEquals(ans[i],i1);
            System.out.println("*******");
        }
        /*
        System.out.println(Integer.toUnsignedLong(-2));
        System.out.println(Integer.toUnsignedLong(1));
        System.out.println(Integer.toUnsignedLong(0));
        System.out.println(Integer.toUnsignedLong(Integer.MIN_VALUE));
        */
    }
    @Test
    public void test2(){
        int a = -1;
        System.out.println((long)a);
        System.out.println(Long.toBinaryString(a));
        System.out.println(Long.toBinaryString(0xffffffffL));
        long l = ((long) a) & 0xffffffffL;

        System.out.println(l);
        System.out.println((int)(l*2));
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

    @Test
    public void testChar(){
        char[] c = new char[10];
        System.out.println(Arrays.toString(c));
        System.out.println((int)c[0]);
        c[0] = '0';
        System.out.println((int)c[0]);
    }
    @Test
    public void testAry(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        System.out.println(linkedList);
        linkedList.add(2,2);
        System.out.println(linkedList);

    }

    private LeetCodeContestD28 leetCodeContestD28 = new LeetCodeContestD28();

    @Test
    public void testD28_1(){
        int[][] ary = {
                {8,4,6,2,3},
                {1,2,3,4,5},
                {10,1,1,6},
                {1,10,11,3}
        };
        int[][] ans = {
                {4,2,4,2,3},
                {1,2,3,4,5},
                {9,0,1,6},
                {1,7,8,3}
        };
        for (int j = 0; j < ary.length; j++) {
                int[] ints = leetCodeContestD28.finalPrices(ary[j]);
                Assert.assertArrayEquals(ints, ans[j]);
                System.out.println(ints);
        }
    }

    @Test
    public void test5(){
        int a = 6, b = 4;
        int c = a + b >> 1;
        System.out.println(c);
    }

}
