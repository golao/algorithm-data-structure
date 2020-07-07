package org.golao.com.algorithm.competition.virtual;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 虚拟赛
 */
public class LeetCodeContestD27 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < target.length; i++){
            map.put(target[i], map.getOrDefault(target[i],0) + 1);
            map.put(arr[i],map.getOrDefault(arr[i],0) - 1);
        }
        for(int n : map.values()){
            if(n != 0){
                return false;
            }
        }
        return true;
    }

    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        int start = 0;
        for(int i = k; i <= s.length(); i++){
            set.add(s.substring(start, i));
            start++;
        }
        return set.size() == (2 << k - 1);
    }
}
