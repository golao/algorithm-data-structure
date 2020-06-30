package org.golao.com.algorithm.topic.easy;

import org.golao.com.n2020.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 专题： 树
 */
public class LeetCodeEasyTree {
    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * 104. 二叉树的最大深度
     * 思路： 递归，先序遍历
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = maxDepth(root.left);
        int rightLevel = maxDepth(root.right);
        return Math.max(leftLevel, rightLevel) + 1;
    }

    /**
     * https://leetcode-cn.com/problems/validate-binary-search-tree/
     * 题解：之前做过，需要注意边界问题，二叉搜索树，子节点不能和根节点相等
     * 方法一：1. 中序遍历，存入数组，利用中序遍历 二叉搜索树，获得的是一个升序数组的性质
     * 2. 比较数组，是否有序
     * 3. 时间复杂度: O(n)
     * 4. 空间复杂度: O(n)  数组开销与递归的栈开销
     * 方法二：递归，带入上下界，
     * 1. 左子树的上界 是根节点的值
     * 2. 左子树的下界 是根节点的下界值
     * 3. 右子树的上界  是根节点的上界
     * 4. 右子树的下界  是根节点的值
     * 5. 使用 null 而不是 Integer.MAX_VALUE  Integer.MIN_VALUE 作为起始值
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }
    private boolean isValidBST(TreeNode node, Integer upper, Integer lower){
        if (node == null) return true;
        if (upper != null && node.val >= upper) return false;
        if (lower != null && node.val <= lower) return false;
        if (!isValidBST(node.left,node.val,lower)) return false;
        return isValidBST(node.right,upper, node.val);
    }

    /**
     * https://leetcode-cn.com/problems/symmetric-tree/
     * 101. 对称二叉树
     * 思路： 方法一： 递归的检查两边是否是镜像
     *        方法二： 迭代，仿 BFS {@link LeetCodeEasyTree#isSymmetricII(TreeNode)}
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        if (!isSymmetric(left.left,right.right)){
            return false;
        }
        return isSymmetric(left.right,right.left);
    }

    public boolean isSymmetricII(TreeNode root){
        if (root == null){
            return true;
        }
        return check(root.left, root.right);
    }
    private boolean check(TreeNode left, TreeNode right){
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(left);
        deque.addLast(right);
        while (!deque.isEmpty()){
            TreeNode l = deque.removeFirst();
            TreeNode r = deque.removeFirst();
            if (l == null && r == null){
                continue;
            }
            if (l == null || r == null){
                return false;
            }
            if (l.val != r.val){
                return false;
            }
            deque.addLast(l.left);
            deque.addLast(r.right);

            deque.addLast(l.right);
            deque.addLast(r.left);
        }
        return true;
    }

}