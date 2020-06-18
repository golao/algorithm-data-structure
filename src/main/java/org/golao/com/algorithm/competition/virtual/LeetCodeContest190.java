package org.golao.com.algorithm.competition.virtual;

import org.golao.com.n2020.TreeNode;

import java.util.*;

/**
 * 打虚拟竞赛，提升编码速度
 */
public class LeetCodeContest190 {
    /**
     * 1
     * @param sentence
     * @param searchWord
     * @return
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }

    /**
     * 2
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        String v = "aeiou";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < v.length(); i++) {
            set.add(v.charAt(i));
        }
        int left = 0;
        int right = 0;
        int ans = 0;
        int cur = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            if (set.contains(c)){
                cur++;
            }
            if (right -left >= k){
                if (set.contains(s.charAt(left))){
                    cur--;
                }
                left++;
            }
            ans = Math.max(ans, cur);
            right++;
        }
        return ans;
    }

    /**
     * 3
     * 题解： 先序遍历 + 回溯
     * @param root
     * @return
     */
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] nums = new int[10];
        return com(root, nums);
    }
    //判断是否形成回文，nums总数为奇数时，奇数组只能有一个  nums 为偶数时，必需全是偶数组
    private boolean isPalindromicPath(int[] nums){
        int odd = 0;
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] % 2 != 0){
                odd++;
            }
        }
        return sum % 2 == 0 ? odd == 0 : odd == 1;
    }
    private int com(TreeNode node, int[] times){
        times[node.val]++;
        if (node.left == null && node.right == null){
            int result = isPalindromicPath(times) ? 1 : 0;
            times[node.val]--;//回溯
            return result;
        }
        int left = 0;
        int right = 0;
        if (node.left != null){
            left = com(node.left, times);
        }
        if (node.right != null){
            right = com(node.right, times);
        }
        times[node.val]--;//回溯
        return left + right;
    }


    public static void main(String[] args) {
        LeetCodeContest190 leetCodeContest190 = new LeetCodeContest190();
//        int prefixOfWord = leetCodeContest190.isPrefixOfWord("hello aa", "aa");
//        System.out.println(prefixOfWord);
        String[] ary = {
                "abciiidef","aeiou","leetcode"
        };
//        int[] k = {3,2,3};
//        int[] ans = {3};
//        for (int i = 0; i < ary.length; i++) {
//            int i1 = leetCodeContest190.maxVowels(ary[i], k[i]);
//            System.out.println(i1);
//        }

        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(9);
        node.right = new TreeNode(6);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(9);
        node.right.right.right = new TreeNode(2);
        node.right.right.right.left = new TreeNode(8);

        int i = leetCodeContest190.pseudoPalindromicPaths(node);
        System.out.println(i);
    }
}
