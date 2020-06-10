package org.golao.com.n2020;

import java.util.*;

/**
 * Created by golao on 2020/3/27.
 * 每日寄语：一种人做事，一种人给别人找事做；待在第一种人中间，那里的竞争会少得多
 */
public class LeetCode0327 {
    /**
     * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
     * 难度：简单
     * 题解： 我只考虑了相同牌型分一个组，没考虑这种情况[1,1,2,2,2,2] 混合牌型
     * -- 这里也理解错了，组内的牌必需一致
     * 其他牌型的，是最少牌型的整数倍时，才能顺利分组
     * 又被爆了，没考虑这种情况：[1,1,1,1,2,2,2,2,2,2]
     * 到这我想明白了，这个题本质是找出牌型数量的最小公约数
     * 总结： 要仔细审题
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            Integer n = map.get(deck[i]);
            n = n == null ? 1 : n + 1;
            map.put(deck[i], n);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            min = Math.min(min, entry.getValue());
        }
        // 分解质因数 min
        Set<Integer> prime = new HashSet<>();
        for (int i = min; i > 1; i--) {
            if (min % i == 0) {
                prime.add(i);
            }
        }
        //求公约数
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Iterator<Integer> iterator = prime.iterator();
            boolean flag = false;
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (entry.getValue() % next == 0) {
                    flag = true;
                } else {
                    iterator.remove();
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public boolean hasGroupsSizeXLCO(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            Integer n = map.get(deck[i]);
            n = n == null ? 1 : n + 1;
            map.put(deck[i], n);
        }
        int g = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (g == -1){
                g = entry.getValue();
            }else {
                g = gcd(g,entry.getValue());
            }
        }
        return g >= 2;
    }
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    /**
     * https://leetcode-cn.com/problems/friends-of-appropriate-ages/
     * 难度：中等
     * 题解：1. 暴力解，每个都遍历   时间复杂度 O(n²)
     *       暴力解，提交后，通过了73个例子，lc搞了一个两万的数组，直接超出时间限制了
     *       2.看了官方题解，先将每个年龄一样的划入一个组，再执行组与组直接的判断，可加则按
     *         数量相乘
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {
        int[] groups = new int[121];
        for (int i = 0; i < ages.length; i++) {
            groups[ages[i]]++;
        }
        int sum = 0;
        for (int i = 1; i < groups.length; i++) {
            for (int j = i; j < groups.length ; j++) {
                if (addFriend(j,i) || addFriend(i,j)){
                    sum = sum + groups[i] * groups[j];
                    if (i == j){
                        sum = sum - groups[i];
                    }
                }
            }
        }
        return sum;
    }

    /**
     * age[B] <= 0.5 * age[A] + 7
     age[B] > age[A]
     age[B] > 100 && age[A] < 100
     * @param A
     * @param B
     * @return
     */
    private boolean addFriend(int A , int B) {
        return !(B <= 0.5 * A + 7) && B <= A && !(B > 100 && A < 100);
    }




}
