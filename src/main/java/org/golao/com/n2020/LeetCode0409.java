package org.golao.com.n2020;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by golao on 2020/4/9.
 */
public class LeetCode0409 {
    /**
     * https://leetcode-cn.com/problems/validate-binary-search-tree/
     * 难度：中等
     * 题解： 先用中序遍历存入数组，再比较数组是否是升序
     *         注意边界条件，第一次提交时，忽略了相等的情况 被[1,1]爆了
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        innerOrder(nums,root);
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i+1) <= nums.get(i)){
                return false;
            }
        }
        return true;
    }
    private void innerOrder(List<Integer> nums,TreeNode node){
        if (node == null)
            return;
        innerOrder(nums,node.left);
        nums.add(node.val);
        innerOrder(nums,node.right);
    }
    /**
     * 官方题解01 ： 递归，并在递归的过程中，带入上下界，
     *          时间复杂度：O(N)
     *          空间复杂度：O(N)
     */
    public boolean isValidBST_01(TreeNode root){
        return helper(root,null,null);
    }
    private boolean helper(TreeNode node , Integer lower,Integer upper){
        if (node == null)
            return true;
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;
        if (!helper(node.left,lower,node.val)) return false;
        if (!helper(node.right,node.val,upper)) return false;
        return true;
    }
}
