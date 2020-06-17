package org.golao.com.n2020;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;


public class LeetCode0616Test {
    private LeetCode0616 leetCode0616 = new LeetCode0616();
    private LeetCode0616.Codec codec = leetCode0616.new Codec();

    public TreeNode createTree(){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        return tree;
    }
    public TreeNode createTree32(){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.left.left = new TreeNode(4);
        tree.left.left.left.left = new TreeNode(5);
        tree.left.left.left.left.left = new TreeNode(6);
        tree.left.left.left.left.left.left = new TreeNode(7);
        tree.left.left.left.left.left.left.left = new TreeNode(8);
        tree.left.left.left.left.left.left.left.left = new TreeNode(9);
        return tree;
    }

    @Test
    public void test1(){
        String serialize = codec.serialize(createTree32());
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(codec.serialize(deserialize));
    }

    private LeetCode0610 leetCode0610 = new LeetCode0610();
    @Test
    public void test0610(){
        int[][] ary = {
                {1,2,1,2,3},
                {1,2,1,3,4},
                {2,2,1,2,2,2,1,1}
        };
        int[] k = {2,3,2};
        int[] ans = {7,3,23};
        for (int i = 0; i < ary.length; i++) {
            int kDistinct = leetCode0610.subarraysWithKDistinct(ary[i], k[i]);
            Assert.assertEquals(ans[i], kDistinct);
        }
    }
    @Test
    public void test0615(){
        String[] ary = {
                "eceba",
                "ccaabbb"
        };
        int[] ans = {3,5};
        for (int i = 0; i < ary.length; i++) {
            int i1 = leetCode0616.lengthOfLongestSubstringTwoDistinctLeetCode(ary[i]);
            Assert.assertEquals(ans[i], i1);
        }
    }

    @Test
    public void test0616(){
        String[] ary = {
                "eceba",
                "aa",
                "ccaabbb",
                "leeetcoooooode"

        };
        int[] k = {2,1,2,3};
        int[] ans = {3,2,5,8};
        for (int i = 0; i < ary.length; i++) {
            int i1 = leetCode0616.lengthOfLongestSubstringKDistinct(ary[i],k[i]);
            Assert.assertEquals(ans[i], i1);
        }
    }

}
