package org.golao.com.n2020.m06;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.golao.com.n2020.ListNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode0625 {
    /**
     * 每日一题
     * https://leetcode-cn.com/problems/word-break/
     * medium
     * 139. 单词拆分
     * 思路： 方法一：1. 回溯法
     *                2. 获得字典单词的长度，对s串进行切分
     *                3. 提交超时了，时间复杂度容易到 O(N!)
     *        方法二： BFS 的方式搜索  time out
     *                1.实际上还是枚举了单词组合，最坏情况仍然会是 O(N!)
     *         方法三：前面两种方法，均以单词来组合字符串的方式求解
     *                 ，在最坏情况下，都面临枚举的问题，无法 AC，看了官方题解
     *                 我的基本方向是错的。应该是逐步扩展字符串，最后达到s
     *                 这样长的字符串 s  可以分解为 s1 + s2 的子问题的解
     *                 存储子问题的解
     *         方法一和方法二，进行记忆优化，可以极大缩减搜索规模
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakTimeOut(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Set<Integer> set = wordDict.stream().map(String::length).collect(Collectors.toSet());
        Integer[] lengths = new Integer[set.size()];
        set.toArray(lengths);
        Arrays.sort(lengths);
        for (int i = 0; i < lengths.length; i++) {
            if (match(lengths,i,s,0,words)){
                return true;
            }
        }
        return false;
    }

    private boolean match(Integer[] lengths, int pos,String s , int begin, Set<String> words){
        boolean match = false;
        if (begin > s.length() - 1){
            return true;
        }
        if (pos > lengths.length - 1){
            return false;
        }
        int end = begin + lengths[pos];
        if (end > s.length()){
            return false;
        }
        String word = s.substring(begin,end);
        if (!words.contains(word)){
            return false;
        }
        for (int i = 0; i < lengths.length ; i++) {
            match = match(lengths,i,s,end,words);
            if (match){
                return true;
            }
        }
        return false;
    }

    public boolean wordBreakBFSTimeOut(String s, List<String> wordDict ){
        Deque<String> deque = new LinkedList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)){
                if (s.equals(word)){
                    return true;
                }
                deque.addLast(word);
            }
        }
        while (!deque.isEmpty()){
            String s1 = deque.removeFirst();
            for (String word : wordDict) {
                if (s.startsWith(word,s1.length())){
                    String newWord = s1 + word;
                    if (s.equals(newWord)){
                        return true;
                    }
                    deque.addLast(newWord);
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 拼接 s1 + s2
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    //2020.06.26

    /**
     * 每日一題
     * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
     * easy
     * 面试题 02.01. 移除重复节点
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode ans = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (head.next != null){
            if (set.contains(head.next.val)){
                head.next = head.next.next;
            }else {
                set.add(head.next.val);
                head = head.next;
            }
        }
        return ans;
    }

    /**
     * 每日一題
     * https://leetcode-cn.com/problems/first-missing-positive/
     * hard
     * 41. 缺失的第一个正数
     * 思路 ： 1. 初始化一个 boolean[n+1] 数组，遇到正数，且小于等于 n的，把对应数组元素置为 true
     *         2. 遍历boolean 数组，返回第一个为false 的下标
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 1;
        }
        boolean[] flag = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length){
                flag[nums[i]] = true;
            }
        }
        for (int i = 1; i < flag.length ; i++) {
            if (!flag[i]){
                return i;
            }
        }
        return flag.length;
    }

    /**
     * 使用空间复杂度为 O(1) 的算法
     * 思路： 1.将所有负数变更为 n + 1
     *        2. 遍历数组，遇到小于n的数，更新对应数的下标，将该元素置为 - nums[i]
     *        3. 从头遍历数组，遇到第一个负数的，即返回其下标+1
     * @param nums
     * @return
     */
    public int firstMissingPositiveO1(int[] nums) {
        //TODO
        return 0;
    }
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        Set<Integer> set = new HashSet<>();
    }

}
