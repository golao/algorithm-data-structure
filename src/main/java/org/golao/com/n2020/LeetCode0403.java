package org.golao.com.n2020;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by golao on 2020/4/3.
 */
public class LeetCode0403 {

    /**
     * https://leetcode-cn.com/problems/string-to-integer-atoi/
     * 难度：中等
     * 题解：
     *       1. 把有效数字部分字符串提取出来，如无返回 0
     *       2. 判断是否溢出
     * 官方： 使用有限状态机处理
     *
     * @param str
     * @return
     */
    public int myAtoi(String str){
        AutoMatch autoMatch = new AutoMatch();
        for (char c:str.toCharArray()) {
            autoMatch.get(c);
        }
        return (int)(autoMatch.sign * autoMatch.ans);
    }
    class AutoMatch{
        final String START = "start";
        final String SIGNED = "signed";
        final String IN_NUM = "in_num";
        final String END = "end";
        String state = START;
        Map<String,String[]> map ;
        public int sign = 1;
        public long ans = 0;

        public AutoMatch(){
            map = new HashMap<>();
            map.put(START,new String[]{START,SIGNED,IN_NUM,END});
            map.put(SIGNED,new String[]{END,END,IN_NUM,END});
            map.put(IN_NUM,new String[]{END,END,IN_NUM,END});
            map.put(END,new String[]{END,END,END,END});
        }
        public int getCol(char c){
            if (c == ' '){
                return 0;
            }
            if (c == '+' || c == '-'){
                return 1;
            }
            if (c >= '0' && c <= '9'){
                return 2;
            }
            return 3;
        }
        public void get(char c){
            state = map.get(state)[getCol(c)];
            if (state.equals(IN_NUM)){
                ans = ans * 10 + c - '0';
                if (sign == 1){
                    ans = Math.min(ans,Integer.MAX_VALUE);
                }else {
                    ans = Math.min(ans,-(long)Integer.MIN_VALUE);
                }
            }else if (state.equals(SIGNED)){
                sign = c == '+' ? 1 : -1;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("  ".trim().isEmpty()+ "ab");
    }
}
