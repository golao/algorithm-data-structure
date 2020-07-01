package org.golao.com.n2020.m04;

import org.golao.com.n2020.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by golao on 2020/4/13.
 */
public class LeetCode0413 {
    /**
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     * 难度：中等
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        preOrder(root,nums);
        return nums;
    }
    private void preOrder(TreeNode node , List<Integer> nums){
        if (node == null)
            return;
        nums.add(node.val);
        preOrder(node.left,nums);
        preOrder(node.right,nums);
    }
}
