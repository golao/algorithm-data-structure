package org.golao.com.n2020;

public class LeetCode0628 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum >= s){
                    while (left <= i && sum >= s){
                        ans = Math.min(ans, i - left + 1);
                        sum -= nums[left++];
                    }
                }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
