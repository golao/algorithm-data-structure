package org.golao.com.n2020.m01;

import org.golao.com.n2020.TreeNode;
import org.golao.com.n2020.m01.LeetCode0109;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by golao on 2020/1/9.
 */
public class LeetCode0109Test {
    private LeetCode0109 lc = new LeetCode0109();

    @Test
    public void replaceElements(){
        int[] t1 = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(lc.replaceElements(t1)));
    }

    @Test
    public void deepestLeavesSum(){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.right = new TreeNode(5);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(6);
        node.right.right.right = new TreeNode(9);

        System.out.println(lc.deepestLeavesSum(node));
    }

    @Test
    public void groupSize(){
//        int[] gs = {3,3,3,3,3,1,3};
        int[] gs = {2,1,3,3,3,2};
        List<List<Integer>> lists = lc.groupThePeople(gs);
        System.out.println(lists);
    }



}
