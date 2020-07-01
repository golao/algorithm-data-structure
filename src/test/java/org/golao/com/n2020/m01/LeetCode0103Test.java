package org.golao.com.n2020.m01;

import org.golao.com.n2020.m01.LeetCode0103;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by golao on 2020/1/3.
 */
public class LeetCode0103Test {
    private LeetCode0103 leetCode0103 = new LeetCode0103();

    @Test
    public void findNumbers() {
        int[] numbers = {23,222,55555,898900};
        int count = leetCode0103.findNumbers(numbers);
        Assert.assertEquals(2,count);
    }

    @Test
    public void subtractProductAndSum(){
        int s = leetCode0103.subtractProductAndSum(234);
        Assert.assertEquals(15,s);
    }

    @Test
    public void minTimeToVisitAllPoints(){
        int[][] points = {{1,1},{3,4},{-1,0}};
        int time = leetCode0103.minTimeToVisitAllPoints(points);
        Assert.assertEquals(7,time);
    }

}
