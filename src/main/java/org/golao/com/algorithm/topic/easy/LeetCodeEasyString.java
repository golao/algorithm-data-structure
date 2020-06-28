package org.golao.com.algorithm.topic.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串专题
 */
public class LeetCodeEasyString {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right){
            char c = s[left];
            s[left++] = s[right];
            s[right--] = c;
        }
    }
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

}
