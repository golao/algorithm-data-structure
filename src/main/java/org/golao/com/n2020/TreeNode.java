package org.golao.com.n2020;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
//        node.left = new TreeNode(2);
        node.right = new TreeNode(6);

//        node.left.left = new TreeNode(1);
//        node.left.right = new TreeNode(3);

        node.right.left = new TreeNode(5);
//        node.right.right = new TreeNode(7);
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
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        print(sb, this);
        sb.append("]");
        return sb.toString();
    }
    private StringBuilder print(StringBuilder sb, TreeNode tree){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = tree;
        queue.add(node);
        int noNull = 1;//标记队列中剩余的是否全为null
        boolean isFirst = true;
        while (!queue.isEmpty() && noNull >= 0){
            while (noNull > 0 && !queue.isEmpty()){
                node = queue.remove();
                if (node == null){
                    sb.append(",null");
                }else {
                    if (isFirst){
                        sb.append(node.val);
                        isFirst = false;
                    }else {
                        sb.append("," + node.val);
                    }
                    break;
                }
            }
            noNull--;
            if (node.left != null){
                noNull++;
            }
            if (node.right != null){
                noNull++;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb;
    }
    public static TreeNode parseStr(String leetcodeTreeSeq){

        return null;
    }
}
