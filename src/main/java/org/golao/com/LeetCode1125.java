package org.golao.com;

import java.util.*;

/**
 * Created by golao on 2019/11/25.
 */
public class LeetCode1125 {
    public static void main(String[] args) {
        System.out.println(countLetters("aaaaaaaaaa"));
        //输入：[17,13,11,2,3,5,7]
        //输出：[2,13,3,11,5,17,7]
        int[] ary = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(ary)));
    }

    /**
     * https://leetcode-cn.com/problems/count-substrings-with-only-one-distinct-letter/
     * @param S
     * @return
     */
    public static int countLetters(String S) {
        if (S == null || S.length() == 0){
            return 0;
        }
        int sum = 0;
        int count = 1;
        boolean flag = false;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i+1)){
                count++;
                flag = true;
            }else {
                sum = sum + count * (count + 1) /2;
                count = 1;
                flag = false;
            }
        }
        return flag ? sum + count * (count + 1) / 2 : sum+1;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        if (root.val > val) {
            return searchBST(root.left, val);
        }else {
            return searchBST(root.right,val);
        }
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * https://leetcode-cn.com/problems/merge-two-binary-trees/
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }

    /**
     * https://leetcode-cn.com/problems/reveal-cards-in-increasing-order/
     * @param deck
     * @return
     */
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(deck[deck.length - 1]);
        for (int i = deck.length-2; i >= 0 ; i--) {
            Integer last = deque.pollLast();
            deque.offerFirst(last);
            deque.offerFirst(deck[i]);
        }
        for (int i = 0; i < deck.length; i++) {
            deck[i] = deque.pollFirst();
        }
        return deck;
    }

    /**
     * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，
     * 你将如何优化 kthSmallest 函数？
     * @param node
     * @param k
     * @return
     */

    public int search(TreeNode node , int k){
        if (node.left == null){
            k++;
            return 0;
        }else{
            //TODO
            return 0;
        }
    }

    public int kthSmallest(TreeNode root, int k) {



        return 0;
    }


}
