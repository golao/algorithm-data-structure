package org.golao.com.n2020;

import org.junit.Test;

/**
 * Created by golao on 2020/4/8.
 */
public class LeetCode0408Test {
    private LeetCode0408 leetCode0408 = new LeetCode0408();
    private LeetCode0403 leetCode0403 = new LeetCode0403();
    private LeetCode0409 leetCode0409 = new LeetCode0409();
    @Test
    public void test1(){
        String c = "  -345dcd";
        System.out.println(leetCode0403.myAtoi(c));
    }
    @Test
    public void test08(){
        TreeNode treeNode = TreeNode.createTreeNode();
        TreeNode.innerOrderPrint(treeNode);
        System.out.println("\n处理后");
        leetCode0408.recoverTree(treeNode);
        TreeNode.innerOrderPrint(treeNode);
    }

    @Test
    public void test09(){
        TreeNode treeNode = TreeNode.createTreeNode();
        boolean validBST = leetCode0409.isValidBST(treeNode);
        System.out.println(validBST);
        boolean validBST_01 = leetCode0409.isValidBST_01(treeNode);
        System.out.println(validBST_01);
    }

}
