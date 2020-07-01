package org.golao.com.n2020.m03;

/**
 * Created by golao on 2020/3/25.
 */
public class LeetCode0325 {
    /**
     * https://leetcode-cn.com/problems/reverse-integer/
     * 难度：简单
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0 ;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10){
                return 0;
            }else if(rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10){
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int z = 1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

}
