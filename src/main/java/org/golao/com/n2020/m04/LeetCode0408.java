package org.golao.com.n2020.m04;

import org.golao.com.n2020.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by golao on 2020/4/8.
 */
public class LeetCode0408 {
    class AutoMatch {
        final String START = "start";
        final String SIGNED = "signed";
        final String IN_NUM = "in_num";
        final String END = "end";
        int sign = 1;
        long ans = 0;
        String state = START;
        private Map<String, String[]> map;

        public AutoMatch() {
            this.map = new HashMap<>();
            map.put(START, new String[]{START, SIGNED, IN_NUM, END});
            map.put(SIGNED, new String[]{END, END, IN_NUM, END});
            map.put(IN_NUM, new String[]{END, END, IN_NUM, END});
            map.put(END, new String[]{END, END, END, END});
        }

        public int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (c >= '0' && c <= '9') {
                return 2;
            }
            return 3;
        }

        public void get(char c) {
            state = map.get(state)[getCol(c)];
        }

        public int match(String str) {
            for (char c : str.toCharArray()) {
                get(c);
                if (state.equals(SIGNED)){
                    sign = c == '+' ? 1 : -1;
                }else if (state.equals(IN_NUM)){
                    ans = ans * 10 + c - '0';
                    ans = sign ==1 ? Math.min(ans,Integer.MAX_VALUE) : Math.max(-ans,Integer.MIN_VALUE) * sign;
                }
            }
            return (int)ans * sign;
        }
    }

    /**
     * *https://leetcode-cn.com/problems/string-to-integer-atoi/
     * 难度：中等
     * 题解： 学习了官方的有限状态机解法
     * @param str
     * @return
     */
    public int myAtoi(String str){
        AutoMatch autoMatch = new AutoMatch();
        return autoMatch.match(str);
    }

    /**
     * https://leetcode-cn.com/problems/recover-binary-search-tree/
     * 难度： 困难
     * 题解： 分三个步骤
     *    1. 将树放入数组，形成一个大致升序的数组(除被交换了的两个数外有序)
     *    2. 从数组中找出这两个被交换的数字
     *    3. 遍历一次recover 回去
     * @param root
     */
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        innerOrder(root,nums);
        int[] swapNumber = findSwapNumber(nums);
        recover(root,2,swapNumber[0],swapNumber[1]);
    }
    private void innerOrder(TreeNode node , List<Integer> nums){
        if (node == null){
            return;
        }
        innerOrder(node.left,nums);
        nums.add(node.val);
        innerOrder(node.right,nums);
    }
    private int[] findSwapNumber(List<Integer> nums){
        int x = -1, y = -1;
        // x 在左，y在右
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i+1) < nums.get(i)){
                y = nums.get(i + 1);
                if (x == -1){
                    x = nums.get(i);
                }else {
                    break;
                }
            }
        }
        return new int[]{x,y};
    }
    //必需使用前序遍历，要先操作 count;
    private void recover(TreeNode node , int count ,int x ,int y){
        if (node != null && count != 0 ) {
            if (node.val == x | node.val == y){
                node.val = node.val == x ? y : x;
                count--;
            }
            recover(node.left, count, x, y);
            recover(node.right, count, x, y);
        }
    }


}
