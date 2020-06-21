package org.golao.com.n2020;

public class LeetCode0621 {
    private int ans = Integer.MIN_VALUE;
    private int INF = (int)-1e8;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return ans;
    }
    private int pathSum(TreeNode root){
        int r = root.val;
        int lv = INF;
        int rv = INF;
        if (root.left != null){
            lv = pathSum(root.left);
        }
        if (root.right != null){
            rv = pathSum(root.right);
        }
        int result = Math.max(Math.max(r + rv,r + lv),r);
        int max = Math.max(lv + rv + r, Math.max(lv,rv));
        ans = Math.max(result,ans);
        ans = Math.max(max,ans);
        return result;
    }
}
