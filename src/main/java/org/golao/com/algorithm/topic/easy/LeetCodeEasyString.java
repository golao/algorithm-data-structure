package org.golao.com.algorithm.topic.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串专题
 */
public class LeetCodeEasyString {

    /**
     * https://leetcode-cn.com/problems/reverse-string/
     * 344. 反转字符串
     * 思路： 头尾交换
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right){
            char c = s[left];
            s[left++] = s[right];
            s[right--] = c;
        }
    }

    /**
     * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
     * 387. 字符串中的第一个唯一字符
     * 思路： 1. 第一遍循环，统计s中字符出现的次数
     *        2. 第二次循环，找出第一个出现次数为 1 的字符，进行返回
     *        3. 时间复杂度 O(n)
     *        4. 空间复杂度 O(n)
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i< s.length(); i++){
            int n = map.get(s.charAt(i));
            if(n == 1){
                return i;
            }
        }
        return -1;
    }

    /**
     * https://leetcode-cn.com/problems/reverse-integer/
     * 7. 整数反转
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        long l = (long)x;
        if(x < 0){
            l = -l;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(l);
        long reverse = Long.parseLong(builder.reverse().toString());
        if(-reverse < (long)Integer.MIN_VALUE || reverse > (long)Integer.MAX_VALUE){
            return 0;
        }
        return x < 0 ? (int)-reverse : (int)reverse;
    }

    /**
     * https://leetcode-cn.com/problems/valid-anagram/
     * 242. 有效的字母异位词
     * 思路： 方法一：1. 用 map 存储 s 中的字符出现的次数
     *                2. 遍历 t，并减少 map 中对应的字符次数
     *                3. 最后检查 map 的values ，存在不等于 0 的则返回false
     *         方法二： 因为输入的字符串都是小写字母 ，可以用一个数组存储字符出现的次数
     *                 count[26]
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()){
            int times = map.getOrDefault(c, 0);
            map.put(c, times - 1);
        }
        for(int n : map.values()){
            if(n != 0){
                return false;
            }
        }
        return true;
    }

    /**
     *https://leetcode-cn.com/problems/valid-palindrome/
     * 125. 验证回文串
     * 思路： 9天前做过这题
     *        1. 双指针，左右移动到有效字符位置上，进行比较
     *        2. 需要留意，题目规定空串是有效的回文
     *        3. 左右指针进行字符比较时，需要先判断 left < right 因为可能已经遍历结束了，就不用比较了
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
       if (s == null || s.length() == 0){
           return true;
       }
       int left = 0, right = s.length() - 1;
       while (left < right){
           while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
               left++;
           }
           while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
               right--;
           }
           if (left < right){
               char lc = s.charAt(left);
               char rc = s.charAt(right);
               if (Character.toUpperCase(lc) != Character.toUpperCase(rc)){
                   return false;
               }
           }
           left++;
           right--;
       }
        return true;
    }




    }
