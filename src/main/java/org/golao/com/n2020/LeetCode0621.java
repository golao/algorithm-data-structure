package org.golao.com.n2020;

public class LeetCode0621 {
    private int ans = Integer.MIN_VALUE;
    private int INF = (int)-1e8;

    /**
     * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
     * hard
     * 题解写在力扣上
     * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/hou-xu-bian-li-by-mack_mabel/
     * @param root
     * @return
     */
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

    /**
     * https://leetcode-cn.com/problems/pattern-matching-lcci/
     * medium
     * 题解: 1. 根据 pattern 推论 value 中应该包含多少个词
     *       2. Xa + Yb = pattern.length X 代表模式 a 的个数，Y 代表模式 b 的个数
     *       3. Xn + Ym = value.length  n 代表模式 a 在 value 中的字符数，m 代表模式
     *          b 在 value 的字符数
     *       4. n 的取值范围 [1, (value.length - Y) / X 整]
     *       5. 将模式套入 value 尝试匹配，成功则返回 true ，尝试完未成功返回 false
     * @param pattern
     * @param value
     * @return
     */
    public boolean patternMatching(String pattern, String value) {
        int patternLength = pattern.length();
        int valueLength = value.length();
        if (valueLength == 0 && patternLength == 0){
            return true;
        }
        if (patternLength == 0){
            return false;
        }
        int a = 0, b = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == 'a') {
                a++;
            } else {
                b++;
            }
        }
        if (valueLength == 0){
            if (a != 0 && b!= 0)
                return false;
        }

        //Xn + Ym = value.length
        int nMax = a != 0 ? valueLength / a : 0;
        int paStart = b != 0 ?  0 : valueLength / a;
        for (int i = paStart; i <= nMax; i++) {
            boolean isInt = true;
            int m =  0;
            if (b != 0){
                isInt = (valueLength - a * i) % b == 0;
                m = (valueLength - a * i) / b;
            }
            if (!isInt){
                continue;
            }
            //开始匹配
            int j = 0 , k = 0;
            boolean match = true;
            String pa = null, pb = null;
            while ( j < patternLength && k < valueLength) {
                if (pattern.charAt(j) == 'a' && k + i <= valueLength){
                    if (pa == null){
                        pa = value.substring(k,k + i);
                    }
                    match = pattern(pa, value, k) && !pa.equals(pb);
                    k += i;
                    if (!match){
                        break;
                    }
                }
                if (pattern.charAt(j) == 'b' && k + m <= valueLength){
                    if (pb == null){
                        pb = value.substring(k,k + m);
                    }
                    match = pattern(pb, value, k) && !pb.equals(pa);
                    k += m;
                    if (!match){
                        break;
                    }
                }
                j++;
            }
            if (match && k  == valueLength){
                return true;
            }
        }
        return false;
    }

    private boolean pattern(String p , String value, int start){
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != value.charAt(start)){
                return false;
            }
            start++;
        }
        return true;
    }

}
