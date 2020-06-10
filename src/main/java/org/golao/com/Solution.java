package org.golao.com;

/**
 * Created by golao on 2018/4/2.
 */

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //递归牛逼了，还可以使用BFS来
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public int findContentChildren(int[] g,int[] s){
        int res = 0 ;
        int indexG = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[indexG]){
                res++;
                indexG++;
                if (indexG >= g.length){
                    break;
                }
            }
        }
        return res;
    }

    public int[] findSubArrayWithSum(int[] ary,int target){
        int sum = 0;
        int[] index = new int[2];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < ary.length; i++) {
            sum += ary[i];
            if ( sum == target){
                endIndex = i;
                break;
            }else if (sum > target){
                sum = sum - ary[startIndex];
                if (sum == target){
                    endIndex = i;
                    startIndex++;
                    break;
                }
            }
        }
        index[0] = startIndex + 1;
        index[1] = endIndex + 1;
        return index;
    }

    public List<String> findAllPairsWithGivenSum(int[] a, int[] b,int sum){
        Set<Integer> bSet = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            bSet.add(b[i]);
        }
        for (int i = 0; i < a.length; i++) {
            int pair = sum - a[i];
            if (bSet.contains(pair)){
                result.add(a[i] + " " + pair);
            }
        }
        return result;
    }

    /**
     * 学会思考问题的根本
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int profix = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i-1];
            if (temp > 0)
                profix += temp;
        }
        return profix;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0){
            return new int[]{};
        }
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        if (result.isEmpty()){
            return new int[]{};
        }
        int[] ary = new int[result.size()];
        int index = 0;
        for (Integer n : result) {
            ary[index++] = n;
        }
        return ary;
    }

    /**
     * 宝石与石头
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

     J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J,String S){
        //异常检查
        if (J == null || J.length() == 0 || S == null || S.length() == 0){
            return 0;
        }
        int sum = 0;
        Set<Character> jewels = new HashSet<>();
        for (char c : J.toCharArray()){
            jewels.add(c);
        }
        for (char c : S.toCharArray()){
            if (jewels.contains(c)){
                sum++;
            }
        }
        return sum;
    }

    /**
     * 判断线路成圈
     * 初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，换言之就是判断它是否会移回到原来的位置。

     移动顺序由一个字符串表示。每一个动作都是由一个字符来表示的。机器人有效的动作有 R（右），L（左），U（上）和 D（下）。输出应为 true 或 false，表示机器人移动路线是否成圈。
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves){
        if (moves == null || moves.length() == 0)
            return true;
        int rl = 0;
        int ud = 0;
        for (char c : moves.toCharArray()){
            if (c == 'R'){
                rl++;
            }
            if (c == 'L'){
                rl--;
            }
            if (c == 'U'){
                ud++;
            }
            if (c == 'D'){
                ud--;
            }
        }
        return rl == 0 && ud == 0;
    }

    /**
     * 翻转图像
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

     水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

     反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A){
        int[][] B = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                B[i][A[i].length - 1 - j] = A[i][j] == 0 ? 1 : 0;
            }
        }
        return B;
    }

    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length-2; i++) {
            if (A[i] < A[i+1] && A[i+1] > A[i+2]){
                return i+1;
            }
        }
        return -1;
    }
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val = t1.val + t2.val;
        TreeNode left1 = t1.left;
        TreeNode left2 = t2.left;
        //TODO


        return null;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }







    public static void main(String[] args) {
//        Solution solution = new Solution();
//        TreeNode tn = new TreeNode(1);
//        tn.left = new TreeNode(2);
//        tn.left.right = new TreeNode(3);
//        System.out.println(solution.maxDepth(tn));
//        int[] ary = {1,2,3,4,5,6,7,8,9,10};
        int[] ary = {1,2,3,7,5};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findSubArrayWithSum(ary,12)));
        System.out.println("------------------------------------");
        int[] a = {-1,-2,4,-6,5,7};
        int[] b = {6,3,4,0};
        System.out.println(solution.findAllPairsWithGivenSum(a,b,8));

        a = new int[]{1,2,4,5,7};
        b = new int[]{5,6,3,4,8};
        System.out.println(solution.findAllPairsWithGivenSum(a,b,9));
        
    }

}
