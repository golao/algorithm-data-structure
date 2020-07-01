package org.golao.com.n2020.m02;

/**
 * Created by golao on 2020/2/20.
 */
public class LeetCode0220 {
    /**
     * https://leetcode-cn.com/problems/divisor-game/
     * 难度：简单
     * 解析： 1. 只要保证爱丽丝回合的数始终是偶数，给鲍勃的始终是奇数，即可获胜。
     *        因为奇数的约数是奇数，奇数相减得偶数，到最后就是2和1
     *        2. 动态规划思维：?
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
    public boolean divisorGameDp(int N) {
        return N % 2 == 0;
    }
}
