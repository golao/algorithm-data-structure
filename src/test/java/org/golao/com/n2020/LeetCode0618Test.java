package org.golao.com.n2020;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeetCode0618Test {
    @Test
    public void testTreeNode(){
        TreeNode treeNode = TreeNode.createTreeNode();
        String s = treeNode.toString();
        System.out.println(s);
        TreeNode node = TreeNode.parseStr(s);
        System.out.println(node.toString());
    }

    @Test
    public void testStr(){
        String s = "1-401--349---90--88";
        String s1 = s.replace("-"," ");
        String[] split = s.split("\\-+");
        System.out.println(Arrays.toString(split));
        System.out.println(split.length);
    }

    private LeetCode0617 leetCode0617 = new LeetCode0617();
    @Test
    public void testRecoverFromPreorder(){
        String[] input = {
                "1-2--3--4-5--6--7",
                "1-2--3---4-5--6---7",
                "1-401--349---90--88"
        };
        String[] output = {
                "[1,2,5,3,4,6,7]",
                "[1,2,5,3,null,6,null,4,null,7]",
                "[1,401,null,349,88,90]"
        };
        for (int i = 0; i < input.length; i++) {
            TreeNode node = leetCode0617.recoverFromPreorder(input[i]);
            TreeNode node2 = leetCode0617.recoverFromPreorderLeetCode(input[i]);
            Assert.assertEquals(output[i], node.toString());
            System.out.println(node2);
            Assert.assertEquals(node, node2);
            System.out.println(node.toString());
        }

    }

    @Test
    public void testMaxDotProduct(){
        int[][] nums1 = {
                {5,-4,-3},
                {2,1,-2,5},
                {-1,-1},
                {3,-2}
        };
        int[][] nums2 = {
                {-4,-3,0,-4,2},
                {3,0,-6},
                {1,1},
                {2,-6,7}
        };
        int[] ans = {28,18,-1,21};
        for (int i = 0; i < ans.length; i++) {
            int maxDotProduct = leetCode0617.maxDotProduct(nums1[i], nums2[i]);
            Assert.assertEquals(ans[i], maxDotProduct);
        }
        // Integer.MIN_VALUE 再加负数会溢出，变成正的了
    }
}
