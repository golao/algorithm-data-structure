package org.golao.com.algorithm.competition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCodeContestD31 {
    public int numSplits(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            set.add(s.charAt(i));
            Integer times = map.get(s.charAt(i));
            if (times == 1){
                map.remove(s.charAt(i));
            }else{
                map.put(s.charAt(i), times - 1);
            }
            if(set.size() == map.size()){
                ans++;
            }
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
     * 5459. 形成目标数组的子数组最少增加次数
     * @param target
     * @return
     */
    public int minNumberOperations(int[] target) {
        int ans = 0;
        ans = target[0];
        for (int i = 1; i < target.length; i++) {
            ans += Math.max(target[i] - target[i-1], 0);
        }
        return ans;
    }
}
