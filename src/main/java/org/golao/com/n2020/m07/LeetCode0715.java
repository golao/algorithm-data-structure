package org.golao.com.n2020.m07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode0715 {
    /**
     * 每日一题
     * https://leetcode-cn.com/problems/unique-binary-search-trees/
     * medium
     * 96. 不同的二叉搜索树
     * 思路： 动态规划
     *        1. 这个dp，有意思
     *        2. 首先分析，以 i 为根节点的解，是等于 根节点 从 1 - i 的情况的和
     *           dp[i] = F(1) + F(2) ... + F(i)
     *        3. 以 i 为根节点时， F(i) = dp[i-1] * dp[n-i]
     *        4. 边界  dp[0] = 1, dp[1] = 1
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    /**
     * 7.16 每日一题
     * https://leetcode-cn.com/problems/is-graph-bipartite/
     * 785. 判断二分图
     * 思路：  方法一 ：  DFS
     *                1. 根据二分图的性质，任选一个节点，假设这个节点属于子集A
     *                2. 那么与该节点相连的其他点，应处于二分图的另一个子集B
     *                3. 以DFS方式进行遍历，上一个节点属于A，则当前节点属于B，反之亦然
     *                4. 如果当前节点以及分配了，并且和上一个节点一样，那么返回false
     *                5. 能遍历完毕，则说明分配结束，graph 是二分图
     *                6. 用染色的描述，更具模型化，起始节点染红色，相连的染蓝色，按
     *                    上述逻辑推导
     *                7. 时间复杂度: O(n + m)  点 + 边
     *                8. 空间复杂度: O(n)  记录染色组以及递归调用的栈空间
     * @param graph
     * @return
     */
    private final int UNCOLORED = 0;
    private final int RED = 1;
    private final int BLUE = 2;
    private boolean valida = true;
    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n && this.valida; i++) {
            if (color[i] == UNCOLORED){
                color[i] = RED;
                dfs(i, color, graph);
            }
        }
        return this.valida;
    }
    private void dfs(int node, int[] color, int[][] graph){
        int nextColor = color[node] == RED ? BLUE : RED;
        for (int i = 0; i < graph[node].length && this.valida; i++) {
            int nextNode = graph[node][i];
            if (color[nextNode] == UNCOLORED){
                color[nextNode] = nextColor;
                dfs(nextNode, color, graph);
            }else if (color[nextNode] != nextColor){
                this.valida = false;
                return;
            }
        }
    }

    /**
     *
     * @param graph
     * @return
     */
    public boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == UNCOLORED){
                Queue<Integer> queue = new LinkedList<>();
                color[i] = RED;
                queue.offer(i);
                while (!queue.isEmpty()){
                    Integer node = queue.poll();
                    int nextColor = color[node] == RED ? BLUE : RED;
                    for (int next : graph[node]) {
                        if (color[next] == UNCOLORED){
                            color[next] = nextColor;
                            queue.offer(next);
                        }else if (color[next] != nextColor){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 7.18 每日一题
     * https://leetcode-cn.com/problems/interleaving-string/
     * 97. 交错字符串
     * 思路：   思考了双指针，回溯法，双指针的移动太复杂，马上否定了这一条路径
     *          回溯是可以解的，但计算了一下复杂度 N阶，考虑了一些剪枝方式，但
     *          实现上也是复杂的
     *
     *          1. 这题想动态规划时候，始终没能构思出转移方程，动态规划最难的地方
     *             还是在构建转移方程，构建出来了，问题基本就解决了。
     *          2. 参考了官方题解，用自己语言组织一遍
     *          3. f(i,j) 表示，S1 的前 i 个字符和 S2 的前 j 个字符组成了 S3 的
     *             i + j 个字符。
     *          4. 当 S1[i] = S3[i+j] 时， f(i,j) 能否构成 S3 前 i + j 个字符
     *             取决于 f(i-1,j)； 以及当  S[j] = S3[i+j]时， f(i,j-1)的状态
     *          5. 这样一来，转移方程就很明显了
     *             f(i,j) = (f(i-1,j) && S1[i] == S3[i+j]) || (f(i,j-1) && S2[j] == S3[i+j])
     *          6. 初始值  f(0,0) = true;
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0){
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(p));
                }
                if (j > 0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(p));
                }
            }
        }
        return dp[m][n];
    }



}
