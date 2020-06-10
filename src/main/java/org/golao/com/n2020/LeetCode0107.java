package org.golao.com.n2020;

/**
 * Created by golao on 2020/1/7.
 */
public class LeetCode0107 {
    /**
     * 难度：简单
     * 题解： 通过简单的全局遍历，比较L R，累加即可得出
     *        优化点，L 大于 左子树，则不需要遍历左子树；R小于右子树，则不用遍历右子树
     * https://leetcode-cn.com/problems/range-sum-of-bst/
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if (root == null)
            return sum;
        if (root.val >= L && root.val <= R){
            sum += root.val;
        }
//        if (root.val <= L && root.right != null){
//            sum += rangeSumBST(root.right,L,R);
//        }else if (root.val >= R && root.left != null){
//            sum += rangeSumBST(root.left,L,R);
//        }else {
//            sum += rangeSumBST(root.left,L,R);
//            sum += rangeSumBST(root.right,L,R);
//        }
        // --
        if (L < root.val)
            sum += rangeSumBST(root.left,L,R);
        if (R > root.val)
            sum+= rangeSumBST(root.right,L,R);


        return sum;
    }

    /** 难度：简单
     * 关键点： 顺序遍历，判断 i+2 位置字符是否等于 #
     * https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index ;
            if (s.length() > i + 2 && s.charAt(i+2) == '#'){
                index = Integer.valueOf(s.substring(i,i+2));
                i += 2;
            }else {
                index = Integer.valueOf(s.charAt(i)+"");
            }
            sb.append(alphabets.charAt(index - 1));
        }
        return sb.toString();
    }

    /**
     * 难度：简单
     * https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        int[] result = new int[n];
        for (int i = 1; i < n; i+=2) {
            result[i-1] = i ;
            result[i] = -i;
        }
        return result;
    }







}
