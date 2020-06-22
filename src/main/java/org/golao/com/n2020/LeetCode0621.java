package org.golao.com.n2020;

import com.sun.org.apache.xalan.internal.res.XSLTErrorResources;

import java.util.*;

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
     *       --------- 以下为优化版，写在了力扣上----
     *       ### 解题思路
     * 1. 6次 N/A，这题绝对是边界值测试的经典，在 pattern.length > 0 和 value.length > 0 的情况下，这题不复杂，从小到大枚举ab去匹配value即可
     * 2. 理解匹配规则：a b 可以匹配空串 "",a b 必需匹配不同的字符串
     * 3. 规则2意味着，a的匹配长度范围是 aLength ∈ [0,max]
     * 4. max = valueLength / aCount; aCount为0时,max = 0;
     * 5. 对应 bLength = (valueLength - countA * aLength) / countB  ， countB = 0 时， bLength = 0;
     * 6. 处理好边界值之后，就可以进行常规处理了
     * 7. 时间复杂度 valueLength * nMax 即  O(MN)
     * 8. 空间复杂度 O(1)
     * 9. 第一次ac的答案太冗长了，处理了很多次边界条件，经过梳理边界值情况，优化成以下代码，提交后是java 双百
     * 10. 匹配模式只有ab两种，里面的代码抽出单独函数处理还不如枚举简单
     *
     *
     * @param pattern
     * @param value
     * @return
     */
    public boolean patternMatching(String pattern, String value) {
        int patternLength = pattern.length();
        int valueLength = value.length();
        int a = 0, b = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == 'a') {
                a++;
            }
        }
        b = patternLength - a;
        //Xn + Ym = value.length
        int nMax = a != 0 ? valueLength / a : 0;
        int paStart = b != 0 ?  0 : nMax;
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
            while ( j < patternLength && k <= valueLength) {
                if (pattern.charAt(j) == 'a' && k + i <= valueLength){
                    if (pa == null){
                        pa = value.substring(k,k + i);
                    }
                    match = value.startsWith(pa, k) && !pa.equals(pb);
                    k += i;
                    if (!match){
                        break;
                    }
                }
                if (pattern.charAt(j) == 'b' && k + m <= valueLength){
                    if (pb == null){
                        pb = value.substring(k,k + m);
                    }
                    match = value.startsWith(pb, k) && !pb.equals(pa);
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


    /**
     * 字节跳动面试题
     * @param str
     * @return
     */
    public int findOdd(String str){
        int length = str.length();
        if (length == 1){
            return 0;
        }
        for (int i = 0; i + 1< length; i += 2) {
            if (str.charAt(i) != str.charAt(i+1)){
                return i;
            }
        }
        return length - 1;
    }

    /**
     * https://leetcode-cn.com/problems/merge-intervals/
     * 编号：56
     * medium
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.sort((x1,x2) -> x1[0] - x2[0]);
        LinkedList<int[]> ans = new LinkedList<>();
        ans.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int[] ints = list.get(i);
            int[] compare = ans.getLast();
            if (ints[0] <= compare[1]){
                compare[1] = Math.max(ints[1],compare[1]);
            }else {
                ans.add(ints);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

}
