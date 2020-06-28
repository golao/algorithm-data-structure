package org.golao.com.algorithm.competition;

public class LeetCodeContestD29 {
    /**
     * 1
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            if (salary[i] > max){
               max = salary[i];
            }
            if (salary[i] < min){
                min = salary[i];
            }
        }

        return (sum - max - min) / (1.0 * (salary.length - 2));
    }

    /**
     * 2
     * @param n
     * @param k
     * @return
     */
    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                count++;
            }
            if (count == k){
                return i;
            }
        }
        return -1;
    }

    /**
     * 3
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int left = 0 , right = 0;
        int p = 0;
        int ans = 0;
        while (p < nums.length){
            while (p < nums.length && nums[p] != 0){
                p++;
                right++;
            }
            ans = Math.max(ans, left + right);
            p++;
            left = right;
            right = 0;
        }

        return ans == nums.length ? ans - 1 : ans;
    }

    /**
     * 4
     * @param n
     * @param dependencies
     * @param k
     * @return
     */
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        
        return 0;
    }

}
