package org.golao.com.n2020;

/**
 * Created by golao on 2020/1/3.
 *  今日需要完成 简单的 3 道   中等的 2 道
 */
public class LeetCode0103 {
    /**
     * 难度: 简单
     * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        if (nums == null || nums.length <= 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int even = 0;
            while (nums[i] > 0){
                nums[i] = nums[i] / 10;
                even++;
            }
            if (even % 2 == 0){
                count++;
            }
        }
        return count;
    }

    /**
     *  难度: 简单
     * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
     * 用10取模，再除以10  循环
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        int product = 1,sum = 0;
        while (n > 0 ){
            int m = n % 10;
            product *= m;
            sum += m;
            n = n / 10;
        }
        return product - sum;
    }


    /**
     * 难度: 简单
     * https://leetcode-cn.com/problems/minimum-time-visiting-all-points/
     * 简单分析，两个点之间移动的时间等于两坐标相减的绝对值最大的值
     * @param points
     * @return
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int times = 0;
        for (int i = 0; i < points.length -1; i++) {
            int x = points[i+1][0] - points[i][0];
            int y = points[i+1][1] - points[i][1];
            times += Math.max(Math.abs(x),Math.abs(y));
        }
        return times;
    }

    /**
     * https://leetcode-cn.com/problems/deepest-leaves-sum/
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        
        return 0;
    }



}
