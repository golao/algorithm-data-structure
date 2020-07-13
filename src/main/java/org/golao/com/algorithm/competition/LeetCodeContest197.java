package org.golao.com.algorithm.competition;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeContest197 {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int[] count = new int[101];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += count[nums[i]]++;
        }
        return ans;
    }

    /**
     * 02
     * 思路：  1. 统计1 出现的次数，每次结算  (count + 1) * count / 2
     *         2. 注意 count 的取值  1e5 ， 整型会溢出
     *         3. 第一次处理大数取模题，
     * @param s
     * @return
     */
    public int numSub(String s) {
        int MOD_INF = (int)1e9 + 7;
        long count = 0;
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && count > 0){
                ans += ((count + 1) * count) / 2L;
                ans %= MOD_INF;
                count = 0;
            }
            if (s.charAt(i) == '1'){
                count++;
            }
        }
        if (count > 0){
            ans += ((count + 1) * count) / 2L;
        }
        return (int)(ans % MOD_INF);
    }
}
