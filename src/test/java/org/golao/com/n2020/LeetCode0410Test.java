package org.golao.com.n2020;

import org.junit.Test;

import java.util.List;

/**
 * Created by golao on 2020/4/10.
 */
public class LeetCode0410Test {
    private LeetCode0410 leetCode0410 = new LeetCode0410();
    private LeetCode0420 leetCode0420 = new LeetCode0420();
    @Test
    public void test(){
        int[] nums1 = {1,2,4,6};
        int[] nums2 = {3,5,8};
        System.out.println(leetCode0410.findMedianSortedArrays_On(nums1,nums2));
    }
    @Test
    public void test20(){
        List<List<Integer>> generate = leetCode0420.generate(5);
        System.out.println(generate);
    }
}
