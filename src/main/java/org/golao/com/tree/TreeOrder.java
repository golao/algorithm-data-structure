package org.golao.com.tree;

import org.golao.com.n2020.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by golao on 2020/4/8.
 */
public class TreeOrder {
    public void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void innerOrder(TreeNode node){
        if (node == null){
            return;
        }
        innerOrder(node.left);
        System.out.print(node.val);
        innerOrder(node.right);
    }

    public void postOrder(TreeNode node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        TreeOrder treeOrder = new TreeOrder();
        System.out.println("pre order");
        treeOrder.preOrder(node);
        System.out.println("\ninner order");
        treeOrder.innerOrder(node);
        System.out.println("\npost order");
        treeOrder.postOrder(node);

    }
}
