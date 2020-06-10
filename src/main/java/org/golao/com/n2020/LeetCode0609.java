package org.golao.com.n2020;

public class LeetCode0609 {
    /**
     * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
     * 难度：medium
     * 题解：
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = num + "";
        int[] nums = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            nums[i] = Integer.parseInt(str.charAt(i) + "");
        }
        int dp_0 = 0;
        int dp_1 = 1;
        int ans = dp_0 + dp_1;
        for (int i = 1; i < nums.length; i++) {
            dp_0 = dp_1;
            dp_1 = ans;
            int s = nums[i-1] * 10 + nums[i];
            if (s >= 10 && s <= 25){
                ans = dp_0 + dp_1;
            }else {
                ans = dp_1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        LeetCode0609 leetCode0609 = new LeetCode0609();
        int[] ary = {1,12,121,1212,1212722};
        for (int a : ary) {
            int i = leetCode0609.translateNum(a);
            System.out.println(i);
        }
    }
}
