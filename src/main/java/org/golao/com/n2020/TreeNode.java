package org.golao.com.n2020;

/**
 * Created by golao on 2020/1/3.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode createTreeNode() {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(7);
        return node;
    }
    public static void innerOrderPrint(TreeNode node){
        if (node == null){
            return;
        }
        innerOrderPrint(node.left);
        System.out.print(node.val);
        innerOrderPrint(node.right);
    }
}
