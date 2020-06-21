package org.golao.com.algorithm.competition;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeContest194 {
    /**
     * 1
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans = ans ^ (start + 2 * i) ;
        }
        return ans;
    }

    /**
     * 2
     * @param names
     * @return
     */
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> map = new HashMap<>();
        for (int i=0; i < names.length; i++) {
            String s = find(names[i], map);
            names[i] = s;
        }
        return names;
    }
    private String find(String name, Map<String,Integer> map){
        Integer min = map.get(name);
        if (min == null){
            map.put(name,1);
            return name;
        }
        int start = min;
        String temp = name + "(" + start + ")";
        while (map.containsKey(temp)){
            start +=1;
            temp = name + "(" + start + ")";
        }
        map.put(temp,start);

        return temp;
    }

    /**
     * 3
     * @param rains
     * @return
     */
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        int[] zero = new int[rains.length];
        Arrays.fill(ans,-1);
        Arrays.fill(zero,-1);

        Map<Integer, Integer> map = new HashMap<>();
        int drop = 0,start = -1;
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0){
                zero[drop] = i;
                drop++;
                continue;
            }
            Integer times = map.getOrDefault(rains[i],0);
            times++;
            if (times >= 2){
                if (drop <= 0 || zero[start + 1] == -1) {
                    return new int[]{};
                }
                start++;
                ans[zero[start]] = rains[i];
                times--;
            }
            map.put(rains[i],times);
        }
        if (drop - start > 1){
            for (int i = start + 1; i < drop; i++) {
                ans[zero[i]] = 1;
            }
        }
        return ans;
    }

}
