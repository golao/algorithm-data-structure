package org.golao.com;

import com.google.common.collect.Lists;
import org.golao.com.algorithm.BackTracking;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BackTrackingTest {
    private BackTracking backTracking = new BackTracking();
    @Test
    public void test(){
        List<Integer> dist = Lists.newArrayList(1,2,2,2,3,3,3,4,5,5,5,6,7,8,10);
        int[] turnpike = backTracking.turnpike(dist, 6);
        System.out.println(Arrays.toString(turnpike));
    }
}
