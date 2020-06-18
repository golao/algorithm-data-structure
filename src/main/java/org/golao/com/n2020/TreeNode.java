package org.golao.com.n2020;

import java.util.*;

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
        //[5, 4, 7, 3, null, 2, null, -1, null, 9]
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(7);

        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(-1);
//        node.left.right = new TreeNode(3);

        node.right.left = new TreeNode(2);
        node.right.left.left = new TreeNode(9);
//        node.right.right = new TreeNode(7);
        return node;
    }

    @Override
    public boolean equals(Object node){
        if (node == null){
            return false;
        }
        if (!(node instanceof TreeNode)){
            return false;
        }
        return equals(this, (TreeNode) node);
    }
    private static boolean equals(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        if (node1.val != node2.val){
            return false;
        }
        boolean left = equals(node1.left, node2.left);
        boolean right = equals(node1.right, node2.right);
        return left && right;
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
        if (leetcodeTreeSeq == null){
            return null;
        }
        if (!leetcodeTreeSeq.startsWith("[") || !leetcodeTreeSeq.endsWith("]")){
            throw new IllegalArgumentException("不是正确的 LeetCode 格式");
        }
        if (leetcodeTreeSeq.length() == 2){
            return null;
        }
        String s = leetcodeTreeSeq.substring(1, leetcodeTreeSeq.length() - 1);
        String[] strings = s.split(",");
        //[5,4,7,3,null,2,null,-1,null,9]
        TreeNode tree = new TreeNode(Integer.parseInt(strings[0]));
        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry(tree,true));
        queue.add(new Entry(tree,false));
        for (int i = 1; i < strings.length; i++) {
            Entry entry = queue.remove();
            if (!strings[i].equals("null")){
                TreeNode node = new TreeNode(Integer.parseInt(strings[i]));
                if (entry.left){
                    entry.treeNode.left = node;
                }else {
                    entry.treeNode.right = node;
                }
                queue.add(new Entry(node,true));
                queue.add(new Entry(node,false));
            }
        }
        return tree;
    }
    static class Entry{
        TreeNode treeNode;
        boolean left;
        Entry(TreeNode treeNode, boolean left){
            this.treeNode = treeNode;
            this.left = left;
        }
    }
}
