package org.golao.com.n2020.m06;

import java.util.Arrays;
//64391
public class LeetCode0614 {
    /**
     * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
     * 难度： medium
     * 题解： 1. 先排序
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] prefix = new int[arr.length + 1];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        int low = 0 , upper = arr[arr.length -1];
        int ans = -1, ansIndex = -1;
        while (low <= upper){
            int mid = (low + upper) >> 1;
            int index = Arrays.binarySearch(arr, mid);
            if (index < 0){
                index = -index - 1;
            }
            int cur = prefix[index] + (arr.length - index) * mid;
            if (cur <= target){
                ans = mid;
                ansIndex = index;
                low = mid + 1;
            }else {
                upper = mid - 1;
            }
        }
        int smallSum = checkMin(arr, ans);
        int bigSum = checkMin(arr, ans + 1);
        return Math.abs(smallSum - target) <= Math.abs(bigSum - target) ? ans : ans + 1;
    }

    private int checkMin(int[] ary, int value){
        int sum = 0;
        for (int a : ary) {
            sum += Math.min(a, value);
        }
        return sum;
    }


}
