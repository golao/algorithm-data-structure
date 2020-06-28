package org.golao.com.algorithm.competition;

import java.util.*;

public class LeetCodeContest195 {
    /**
     * 1
     * @param path
     * @return
     */
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Set<Integer> zero = new HashSet<>();
        zero.add(0);
        map.put(0,zero);
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N')
                y += 1;
            if (path.charAt(i) == 'S')
                y -= 1;
            if (path.charAt(i) == 'E')
                x += 1;
            if (path.charAt(i) == 'W')
                x -= 1;
            Set<Integer> set = map.computeIfAbsent(x, k -> new HashSet<>());
            if (set.contains(y)){
                return true;
            }else {
                set.add(y);
            }
        }
        return false;
    }

    /**
     * 2
     * 思路：  1. 对arr[i] 进行取模
     *         2. 关键一步： 如果取模为负数，要转换成  k + mod ，才能统一处理
     *         3. 对 mod = 0 的情况进行处理，只有两个mod = 0 的数相加才能整除
     *         4. 今天就是卡在这个知识点上，没有成功ac
     * @param arr
     * @param k
     * @return
     */
    public boolean canArrange(int[] arr, int k) {
        if(k == 0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i]  = arr[i] % k;
            if (arr[i] < 0){
                arr[i] += k;
            }
            int m = arr[i] == 0 ? 0 : k - arr[i];
            Integer times = map.getOrDefault(m, 0);
            if (times > 0){
                map.put(m,times - 1);
            }else {
                map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
            }
        }
        for (int v : map.values()) {
            if (v > 0) {
                return false;
            }
            }
        return true;
    }

}
