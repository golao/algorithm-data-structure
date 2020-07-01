package org.golao.com.n2020.m03;

import org.golao.com.n2020.m03.LeetCode0304;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by golao on 2020/3/4.
 */
public class LeetCode0304Test {
    private LeetCode0304 leetCode0304 = new LeetCode0304();
    @Test
    public void test1(){
        char[] cs = "abcdef".toCharArray();
        leetCode0304.reverseString(cs);
        System.out.println(Arrays.toString(cs));
    }
}
