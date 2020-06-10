package org.golao.com.algorithm.dp;

public class LeetCode0605 {
    /**
     * 来源： 《数据结构与算法》P289
     * @param n
     * @return
     */
    public double eval(int n){
        double dp_sum = 1;
        double c = 0.0;
        for (int i = 2; i <= n; i++) {
            c = dp_sum * (i/2.0) + i;
            dp_sum += c;
        }
        return c;
    }
}
