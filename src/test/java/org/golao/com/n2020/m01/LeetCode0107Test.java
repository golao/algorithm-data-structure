package org.golao.com.n2020.m01;

import org.golao.com.n2020.m01.LeetCode0107;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by golao on 2020/1/7.
 */
public class LeetCode0107Test {
    private LeetCode0107 lc = new LeetCode0107();
    @Test
    public void freqAlphabets() {
        String numbers = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        String s = lc.freqAlphabets(numbers);
        Assert.assertTrue("abcdefghijklmnopqrstuvwxyz".equals(s));
    }
    @Test
    public void sumZero(){
        int[] ints = lc.sumZero(4);
        System.out.println(Arrays.toString(ints));
    }
}
