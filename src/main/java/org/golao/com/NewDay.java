package org.golao.com;

import java.util.Arrays;

/**
 * Created by golao on 2019/10/24.
 */
public class NewDay {
    public static void main(String[] args) {
        System.out.println("Now I'm back!");
        System.out.println(removeVowels("aefbc"));
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(calculateTime(keyboard,"cba"));
        // test skyline
        //grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
        int[][] skyline = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(skyline));
        System.out.println(defangIPaddr("1.1.1.1"));
    }
    public  static  String removeVowels(String S) {
        if (S == null || S.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < S.length(); i++) {
            char n = S.charAt(i);
            if (n != 'a' && n != 'i' && n != 'u' && n != 'e' && n != 'o'){
                sb.append(n);
            }
        }
        return sb.toString();
    }
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]){
                count++;
            }
        }
        return count;
    }

    public static  int calculateTime(String keyboard, String word) {
        if (word == null || word.length() == 0){
            return 0;
        }
        int move = 0;
        int cursor = 0;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            int b = keyboard.indexOf(c.toString());//??
            move += Math.abs(cursor - b);
            cursor = b;
        }
        return move;
    }

    /**
     * https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
     * @param grid
     * @return
     */
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] leftToRight = new int[grid.length];
        int[] topToButton = new int[grid.length];
        int start = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                leftToRight[i] = Math.max(grid[i][j],leftToRight[i]);
                topToButton[i] = Math.max(grid[j][i],topToButton[i]);
                start += grid[i][j];
            }

        }
        int skyline = 0;
        for (int i = 0; i < leftToRight.length; i++) {
            for (int j = 0; j < topToButton.length; j++) {
                skyline += leftToRight[i] <= topToButton[j] ? leftToRight[i] : topToButton[j];
            }
        }
        return skyline - start;
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     * https://leetcode-cn.com/problems/maximum-binary-tree/
     * 解法：顺序遍历，第一个元素构造成root，如果比root值大，则新值成为root，原root为新值的左子树
     * ；如果比root值小，该值的位置一定是在root的右边，递归比较右边值直到找到正确位置
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = buildTreeNode(root,nums[i]);
        }
        return root;
    }
    public TreeNode buildTreeNode(TreeNode root,int num){
        TreeNode node = new TreeNode(num);
        if (root == null){
            return node;
        }
        if (num > root.val){
            node.left = root;
            return node;
        }else {
            root.right = buildTreeNode(root.right,num);
            return root;
        }
    }
    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    /**
     * https://leetcode-cn.com/problems/reveal-cards-in-increasing-order/
     * @param deck
     * @return
     * 解法： 先排好数组，接着逆序回放牌显示过程
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] show = new int[deck.length];
        int size = deck.length - 1;
        while(size > 0 ){
            //TODO
            size--;
        }
        return null;
    }
    /**
     * 2019.11.14
     */
    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
//        return address.replaceAll("\\.","[.]");
    }

    //  Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //1-2-3-4  2
    public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;

    }

    /**
     * https://leetcode-cn.com/problems/remove-outermost-parentheses/
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {

        return null;
    }








}
