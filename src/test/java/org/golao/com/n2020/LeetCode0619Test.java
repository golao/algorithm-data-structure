package org.golao.com.n2020;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.golao.com.algorithm.competition.virtual.LeetCodeContest189;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0619Test {
    @Test
    public void testStr(){
        String upper  = "ABCDEXYZ";
        String lower =  "abcdexyz";
        for (int i = 0; i < lower.length(); i++) {
            int abs = lower.charAt(i) - upper.charAt(i);
            System.out.println(abs);
        }
        System.out.println((int)'0');
        System.out.println((int)'9');
        System.out.println((int)'A');
        System.out.println((int) 'z');
    }

    private LeetCode0619 leetCode0619 = new LeetCode0619();
    @Test
    public void testPalindromeI(){
        String[] s = {
                "",
                "_)(",
                "A man, a plan, a canal: Panama",
                "race a car",
                "aba",
                "aa",
                "a%78,,87-+=a)(*&",
                "a%78,z,Z87-+=a)(*&"
        };
        boolean[] ans = {true,true, true, false,true,true,true,true};
        for (int i = 0; i < ans.length; i++) {
            boolean palindromeI = leetCode0619.isPalindromeLeetCode(s[i]);
            Assert.assertEquals(ans[i], palindromeI);
        }
    }

    private LeetCodeContest189 leetCodeContest189 = new LeetCodeContest189();
    @Test
    public void testContest189_1(){
        String[] str = {"Leetcode is cool","Abc","Abc abc def abcde"};
        String[] ans = {"Is cool leetcode","Abc","Abc abc def abcde"};
        for (int i = 0; i < str.length; i++) {
            String s = leetCodeContest189.arrangeWords(str[i]);
            Assert.assertEquals(ans[i], s);
        }
    }
    @Test
    public void testContest189_3(){
        List<String> s1 = Lists.newArrayList("leetcode","google","facebook");
        List<String> s2 = Lists.newArrayList("leetcode","amazon");
        List<String> s3 = Lists.newArrayList("facebook","google");
        List<List<String>> lists = Lists.newArrayList(s1,s2,s3);
        List<Integer> list = leetCodeContest189.peopleIndexes(lists);
        System.out.println(list);
    }
    //[["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
    @Test
    public void testContest189_3_1(){
        List<String> s1 = Lists.newArrayList("leetcode","google","facebook");
        List<String> s2 = Lists.newArrayList("google","microsoft");
        List<String> s3 = Lists.newArrayList("google","facebook");
        List<String> s4 = Lists.newArrayList("google");
        List<String> s5 = Lists.newArrayList("amazon");
        List<List<String>> lists = Lists.newArrayList(s1,s2,s3,s4,s5);
        List<Integer> list = leetCodeContest189.peopleIndexes(lists);
        System.out.println(list);
    }
    @Test
    public void testContest189_3_2(){
        String input = "[[\"arrtztkotazhufrsfczr\",\"knzgidixqgtnahamebxf\",\"zibvccaoayyihidztflj\"],[\"cffiqfviuwjowkppdajm\",\"owqvnrhuzwqohquamvsz\"],[\"knzgidixqgtnahamebxf\",\"owqvnrhuzwqohquamvsz\",\"qzeqyrgnbplsrgqnplnl\"],[\"arrtztkotazhufrsfczr\",\"cffiqfviuwjowkppdajm\"],[\"arrtztkotazhufrsfczr\",\"knzgidixqgtnahamebxf\",\"owqvnrhuzwqohquamvsz\",\"qzeqyrgnbplsrgqnplnl\",\"zibvccaoayyihidztflj\"]]\n";
        Object objects = JSONObject.parse(input);
        List<List<String>> lists = (List<List<String>>)objects;
        List<Integer> list = leetCodeContest189.peopleIndexes(lists);
        System.out.println(list);
    }

    @Test
    public void testMinCost(){
        //houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
        int[] houses = {0,0,0,0,0};
        int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int m = 5, n = 2, target = 3;
        int ans = leetCode0619.minCost(houses, cost, m, n, target);
        System.out.println(ans);
//        System.out.println(1e8);
//        double pow = Math.pow(10, 8);
//        System.out.println(pow == 1e8);
    }

}
