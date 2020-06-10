package org.golao.com.n2020;

import java.util.*;

/**
 * Created by golao on 2020/2/19.
 */
public class LeetCode0219 {
    /**
     * https://leetcode-cn.com/problems/nim-game/
     * 难度：简单
     * 能被4整除的都是false
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    /**
     * https://leetcode-cn.com/problems/array-partition-i/
     * 难度：简单
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i++];
        }
        return sum;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
     * 难度：简单
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] splits = s.split(" ");
        for (String str : splits) {
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/
     * 难度：中等
     * bfs/dfs 遍历
     * 先序遍历，标记父节点和祖父节点，祖父节点为true时候，节点值累加
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        return preOrder(root,false,false,0);
    }
    private int preOrder(TreeNode node, boolean f, boolean g,int sum) {
        if (node == null) {
            return sum;
        }
        if (g){
            sum += node.val;
        }
        g = f;
        f = node.val % 2 == 0;
        sum += preOrder(node.left,f,g,0);
        sum += preOrder(node.right,f,g,0);
        return sum;
    }

    /**
     * https://leetcode-cn.com/problems/spiral-matrix-ii/
     * 难度：中等
     * 解题思路： left, right, top, button 四个界限 按照 l->r ,t->b,r->l,b->t 顺序填充
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int target = n * n;
        int num = 1;
        int l = 0, r = n-1, t = 0, b = n-1;
        int[][] matrix = new int[n][n];
        while(num <= target){
            // left -> right
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num++;
            }
            t++;
            //top -> button
            for (int i = t; i <= b; i++) {
                matrix[i][r] = num++;
            }
            r--;
            //right -> left
            for (int i = r; i >= l; i--) {
                matrix[b][i] = num++;
            }
            b--;
            //button -> top
            for (int i = b; i >= t; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        return matrix;
    }

    public int[][] generateMatrix2(int n) {
        int num=1,target = n * n;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] matrix = new int[n][n];
        while(num <= target){
            //left -> right
            for (int i = l; i <= r ; i++) {
                matrix[t][i] = num++;
            }
            t++;
            //top -> button
            for (int i = t; i <= b ; i++) {
                matrix[i][r] = num++;
            }
            r--;
            //right -> left
            for (int i = r; i >= l ; i--) {
                matrix[b][i] = num++;
            }
            b--;
            //button -> top
            for (int i = b; i >= t ; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        return matrix;
    }



    public static void main(String[] args) {
        String[] split = "a b c".split(" ");
        System.out.println(Arrays.toString(split));
    }


}
