package org.golao.com.n2020;

import org.golao.com.algorithm.competition.LeetCodeContest194;
import org.golao.com.algorithm.competition.LeetCodeContestD28;
import org.golao.com.algorithm.competition.virtual.LeetCodeContest188;
import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode0620Test {
    private LeetCodeContestD28 leetCodeContestD28 = new LeetCodeContestD28();
    @Test
    public void testMinDistance(){
        int[][] input1 = {{1,8,12,10,3},{1,4,8,10,20},{2,3,5,12,18},{7,4,6,1},{3,6,14,10}};
        int[] input2 = {3,3,2,1,4};
        int[] ans = {4,5,9,8,0};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCodeContestD28.minDistance(input1[i], input2[i]);
            Assert.assertEquals(ans[i], result);
        }
    }

    private LeetCode0619 leetCode0619 = new LeetCode0619();
    @Test
    public void maxSubArray(){
        int[][] intput = {{-2,1,-3,4,-1,2,1,-5,4},{-1,0,-2}};
        int[] ans = {6,0};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0619.maxSubArray(intput[i]);
            System.out.println(result);
        }
    }
    private LeetCodeContest194 leetCodeContest194 = new LeetCodeContest194();
    @Test
    public void test194_1(){
        int xorOperation = leetCodeContest194.xorOperation(5, 0);
        System.out.println(xorOperation);
    }
    @Test
    public void test194_2(){
        String[][] input = {{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"},{"pes","fifa","gta","gta(1)","gta(3)","gta","pes(2019)"},{"gta","gta(1)","gta","avalon"}
        ,{"kaido","kaido(1)","kaido","kaido(1)"}};
        String[][] output = {{"kaido","kaido(1)","kaido(2)","kaido(1)(1)","kaido(2)(1)"},{"pes","fifa","gta","gta(1)","gta(3)","gta(2)","pes(2019)"},{"gta","gta(1)","gta(2)","avalon"},
                {"kaido","kaido(1)","kaido(2)","kaido(1)(1)"}};
        for (int i = 0; i < input.length; i++) {
            String[] folderNames = leetCodeContest194.getFolderNames(input[i]);
            Assert.assertArrayEquals(output[i],input[i]);
        }
    }

    @Test
    public void test194_3(){
        int[][] input = {{1,2,3,4},{1,2,0,0,2,1},{1,2,0,1,2},{69,0,0,0,69},{10,20,20}};
        int[][] ans = {{-1,-1,-1,-1},{-1,-1,2,1,-1,-1},{},{-1,69,1,1,-1},{}};
        for (int i = 0; i < ans.length; i++) {
            int[] avoidFlood = leetCodeContest194.avoidFlood(input[i]);
            Assert.assertArrayEquals(ans[i], avoidFlood);
        }
    }

    private LeetCode0621 leetCode0621 = new LeetCode0621();
    @Test
    public void testPathSum(){
        String[] input = {"[1,2,3]","[-10,9,20,null,null,15,7]"};
        int[] ans = {6,42};
        for (int i = 0; i < ans.length; i++) {
            TreeNode node = TreeNode.parseStr(input[i]);
            int result = leetCode0621.maxPathSum(node);
            Assert.assertEquals(ans[i],result);
        }
    }
    @Test
    public void testPattern(){
        String[] patterns = {"ab","a","","","bbbaa","abba","abba","abba","aaaa"};
        String[] values = {"","","abc","","xxxxxx","dogcatcatdog","dogcatcatfish","dogdogdogdog", "dogcatcatdog"};
        boolean[] ans = {false,true,false,true,true,true,false,true,false};
        for (int i = 0; i < ans.length; i++) {
            boolean result = leetCode0621.patternMatching(patterns[i], values[i]);
            Assert.assertEquals(ans[i], result);
        }
    }

    private LeetCodeContest188 leetCodeContest188 = new LeetCodeContest188();
    @Test
    public void test188_1(){
        int[] ary = {1,3,4,6,7,8};
        int n = 9;
        List<String> strings = leetCodeContest188.buildArray(ary, n);
        System.out.println(strings);
    }

    @Test
    public void test188_2(){
        int[][] input = {{7,11,12,9,5,2,7,17,22},{1,3,5,7,9},{2,3},{2,3,1,6,7},{1,1,1,1,1}};
        int[] ans = {8,3,0,4,10};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCodeContest188.countTriplets(input[i]);
            Assert.assertEquals(ans[i], result);
        }
    }

    @Test
    public void testBd(){
        String[] input = {"a","aab","aaabb","aabbb"};
        int[] ans = {0,2,2,4};
        for (int i = 0; i < ans.length; i++) {
            int result = leetCode0621.findOdd(input[i]);
            Assert.assertEquals(ans[i], result);
        }
    }
    @Test
    public void testMerge(){
        //[[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
        int[][][] input = {{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}},{{1,4},{4,5}},{{1,3},{2,6},{9,10}}};
        int[][][]  output = {{{1,3},{4,7}},{{1,5}},{{1,6},{9,10}}};
        for (int i = 0; i < output.length; i++) {
            int[][] merge = leetCode0621.merge(input[i]);
            Assert.assertArrayEquals(output[i],merge);
        }

    }

    public static void main(String[] args) {
        System.out.println(5 ^ 5);
    }

}
