package org.golao.com.algorithm.topic.easy;

import org.golao.com.n2020.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * medium
     * 102. 二叉树的层序遍历
     * 思路： 方法一
     *          1. 层序遍历，基本就是 BFS
     *          2. cur 标记当前层，next 标记下一层的节点数
     *          3. 当 cur 读取完毕时， cur 切换为 next 的值
     *          4. 判断和交换 cur next 值是，应放在最后操作
     *          5. 时间复杂度: O(n)
     *          6. 空间复杂度: O(1) 返回空间不计入复杂度
     *
     *         方法二：官方题解
     *          1. 与方法一类似，但使用了 队列的长度来衡量树层级的节点数，更为简洁和巧妙
     *          2. while 里层用 for 循环，每次取出同一层的所有节点  i < currentSize
     *          3. 实现 {@link LeetCodeEasyTree#levelOrderII(TreeNode)}
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        int next = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.removeFirst();
            cur--;
            list.add(node.val);
            if (node.left != null){
                deque.addLast(node.left);
                next++;
            }
            if (node.right != null){
                deque.addLast(node.right);
                next++;
            }
            if (cur == 0){
                cur = next;
                next = 0;
                ans.add(list);
                list = new ArrayList<>();
            }
        }
        return ans;
    }
    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int currentSize = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = deque.removeFirst();
                list.add(node.val);
                if (node.left != null){
                    deque.addLast(node.left);
                }
                if (node.right != null){
                    deque.addLast(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

}