package org.golao.com.n2020;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by golao on 2020/1/6.
 */
public class LeetCode0106Test {
    private LeetCode0106 lc = new LeetCode0106();

    @Test
    public void getDecimalValue(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        int result = lc.getDecimalValue(node);
        Assert.assertEquals(5,result);
    }

    @Test
    public void balancedStringSplit(){
        String s = "RLLLLRRRLR";
        int result = lc.balancedStringSplitBetter(s);
        Assert.assertEquals(3,result);

    }



}
