package org.golao.com.algorithm.dp;

import java.util.Arrays;

/**
 * 动态规划 dynamic programming
 */
public class LeetCode0604 {
    /**
     * https://leetcode-cn.com/problems/new-21-game/
     * 难度： 中等
     * 题解： 分析问题是个难点，如果正序分析，概率计算就很头大，使用反序求解，当抽到 k-1 点时
     *        ，下一次抽小于N 的概率是多少。然后用动态规划，反序推到起点，积分为0时的胜率。
     *        dp[x] = (dp[x+1] + dp[x+2] + ... + dp[x+w]) / w; -- 通用方程
     *        对相邻项计算差分，得到：
     *        dp[x] - dp[x+1] = (dp[x+1] - dp[x+w+1]) / w 其中 0 <= x < k-1
     *        得到新的状态转移方程：
     *        dp[x] = dp[x+1] + (dp[x+1] - dp[x+w+1]) / w  其中 0 <= x < k-1
     *        当 x = k-1 时，上述方程不适用，因为 k-1 和之后的概率值，都不依赖更前面的概率，
     *        而需要通过通用方程来求解
     *        dp[k-1] = (dp[k] + dp[k+2] + ... + dp[k+w-1]) / w
     *        而只有当 K <= x < min(N,K+W-1) 时，dp[x] 才等于 1 所以
     *        dp[k-1] = (min(N,K+W-1) - K + 1) / W = (min(N-K+1,W)) / W
     *        而dp[k-2]  到  dp[0]  可以通过简化的状态转移方程得到
     *  编码时候注意边界的判断，dp的初始化边界
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        //判断特例，为0时，不用抽牌，只要N不是负数，即获胜
        if (K == 0){
            return 1.0;
        }
        //初始化 dp 数组
        double[] dp = new double[K+W];
        for (int i = K; i <= Math.min(K+W,N); i++) {
            dp[i] = 1.0;
        }
        // 求状态方程中起始值  dp[k-1]
        //dp[k-1] = (min(N,K+W-1) - K + 1) / W = (min(N-K+1,W)) / W
        dp[K-1] = Math.min(N-K+1,W) / (W*1.0);
        //反序求解到 dp[0]
        //dp[x] = dp[x+1] + (dp[x+1] - dp[x+w+1]) / w
        for (int i = K-2; i >=0; i--) {
            dp[i] = dp[i+1] + (dp[i+1] - dp[i+W+1])/(W * 1.0);
        }
        return dp[0];
    }

    /**
     * https://leetcode-cn.com/problems/product-of-array-except-self/
     * 难度： 中等
     * 题解： 关键在不许用除法，而且时间复杂度要求在O(n)，进阶的要求还要常数空间
     *        这道题我想到了使用dp，但没想到要使用两个dp，切分成左前缀和右前缀
     *        乘积即左右相乘，分为左右之后，dp就有用武之地了。
     *        后续进阶常数空间，则是把这两个dp空间，利用返回的answer数组，和一个
     *        变量来承载前缀空间即可
     *
     *        把两边都变得，分成左右，这样可利用dp思想进行解，是这道题的关键
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        //特例处理
        //左前缀乘积
        int[] dp_l = new int[nums.length];
        dp_l[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp_l[i] = dp_l[i-1] * nums[i-1];
        }
        //右后缀乘积
        int[] dp_r = new int[nums.length];
        dp_r[nums.length-1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            dp_r[i] = dp_r[i+1] * nums[i+1];
        }
        //左右相乘
        for (int i = 0; i < nums.length; i++) {
            dp_l[i] = dp_l[i] * dp_r[i];
        }
        return dp_l;
    }

    /**
     * 进阶，将空间常数化，用返回数组存储 左前缀乘积，用r常量存储右前缀乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelfMore(int[] nums) {
        int[] result = new int[nums.length];
        //左前缀乘积
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        //右后缀用常量 r 存储，合并结果到 result中
        int r = 1;
        for (int i = nums.length - 1; i >= 0;i--) {
            result[i] = result[i] * r;
            r = r * nums[i];
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/trapping-rain-water/
     * 难度： 困难
     * 题解： 更像是用状态机来处理
     *         思考一下最本质的问题：怎么才算是可以装水？
     *         1.两头高，有个窝，就可以装水了。所以基本思想是，先找到第一块高的，
     *         入栈，接着渡过洼地，寻找第二块高的，计算这两者中间的储水量。
     *         2.如果第二块比第一块高，那么第一块出栈，把第二块压入栈，前面的记入总水量中
     *         3.继续寻找洼地，和高地，计算储水量
     *         4.到数组尽头结束，，返回累积的水量
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        return 0;
    }

    /**
     * https://leetcode-cn.com/problems/trapping-rain-water/
     * 难度： 困难
     * {@link LeetCode0604#trap(int[])}这是自己的胡思乱想过程，不够本质
     * 题解： 参见了LC官方题解
     *        1. 本质上是把每一个 height[i] 当做底部，看看这个柱子能装多少水
     *        2. height[i] 当bottom，往左边找一个最高的 leftMax，和往右边找一个最高的 rightMax
     *        3. 积水公式为  ans = ans + Max(Min(leftMax,rightMax),height[i]) - height[i]
     *        4. 用动态规划求解，存储两个数组， leftMax[] ,rightMax[]
     *        5. 遍历 height 数组，并与 leftMax[],rightMax[] 求得 ans
     * @param height
     * @return
     */
    public int trapLC(int[] height) {
        //特例处理
        if (height == null || height.length < 3){
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i-1], leftMax[i - 1]);
        }
        for (int i = height.length-2; i >= 0 ; i--) {
            rightMax[i] = Math.max(height[i+1], rightMax[i + 1]);
        }
        //3. 积水公式为  ans = ans + Max(Min(leftMax,rightMax),height[i]) - height[i]
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.max(Math.min(leftMax[i],rightMax[i]),height[i]) - height[i];
        }
        return ans;
    }

    //https://leetcode-cn.com/problems/trapping-rain-water-ii/  TODO 三维版接雨水

    /**
     * https://leetcode-cn.com/problems/maximum-product-subarray/
     * 难度：中等
     * 题解：状态转移方程，因为存在负数，所以涉及到维护最大和最小两个值
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        //设置初始值
        int maxf = nums[0];
        int minf = nums[0];
        int ans = nums[0];
        //状态转移
        for (int i = 1; i < nums.length; i++) {
            int temp = maxf;
            maxf = Math.max(nums[i], Math.max(maxf * nums[i],minf * nums[i]));
            minf = Math.min(nums[i], Math.min(temp * nums[i],minf * nums[i]));
            ans = Math.max(maxf,ans);
        }
        return ans;
    }



    public static void main(String[] args) {
        LeetCode0604 leetCode0604 = new LeetCode0604();
        double game = leetCode0604.new21Game(21, 17, 10);
        System.out.println(game);
        int[] nums = {1,2,3,4};
        int[] ints = leetCode0604.productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(leetCode0604.productExceptSelfMore(nums)));
        ;

    }
}
