package org.golao.com.n2020.m07;

import org.golao.com.n2020.TreeNode;

public class LeetCode0707 {
    /**
     * https://leetcode-cn.com/problems/path-sum/
     * easy  每日一题
     * 112. 路径总和
     * 思路：  1. 从根节点到叶子节点，需要遍历树
     *         2. 根序遍历，将和传递到叶子节点，进行比较
     *         3. 官方的实现更优雅，减去当前节点值，往下传递，代码简洁
     *            {@link LeetCode0707#hasPathSumLeetCode(TreeNode, int)}
     *         4. 时间复杂度: O(n)
     *         5. 空间复杂度: O(n)  隐式栈空间调用
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return pathSum(root, sum, 0);
    }
    private boolean pathSum(TreeNode node, int target, int curSum){
        curSum += node.val;
        if (node.left == null && node.right == null){
            return curSum == target;
        }
        boolean left = node.left == null ? false : pathSum(node.left, target, curSum);
        return left || (node.right == null ? false : pathSum(node.right, target, curSum));
    }

    public boolean hasPathSumLeetCode(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
}
