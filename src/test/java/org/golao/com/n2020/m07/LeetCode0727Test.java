package org.golao.com.n2020.m07;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeetCode0727Test {
    private LeetCode0727 leetCode0727 = new LeetCode0727();
    @Test
    public void test(){
        String[] input = {"adkkk","acb","abc"};
        String t = "adkdbkjklc";
        boolean[] ans = {true,false,true};
        for (int i = 0; i < ans.length; i++) {
            boolean subsequenceII = leetCode0727.isSubsequenceDp(input[i], t);
            Assert.assertEquals(ans[i], subsequenceII);
        }

    }
}
