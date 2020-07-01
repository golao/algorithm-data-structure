package org.golao.com.n2020.m06;

import org.golao.com.n2020.TreeNode;

import java.util.*;

/**
 * 60354
 */
public class LeetCode0616 {
    /**
     * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
     * hard
     */
    public class Codec {

        // Encodes a tree to a single string.
        //json {v:1,l:{v:2},r:{v:3,l:{v:4},r:{v:5}}}
        public String serialize(TreeNode root) {
            if (root == null){
                return "null";
            }
            StringBuilder sb = new StringBuilder("");
            preOrder(root, sb);
            return sb.toString();
        }
        private void preOrder(TreeNode node, StringBuilder sb){
            sb.append("{");
            sb.append("v:" + node.val);
            if (node.left != null){
                sb.append(",l:");
                preOrder(node.left, sb);
            }
            if (node.right != null){
                sb.append(",r:");
                preOrder(node.right, sb);
            }
            sb.append("}");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("null".equals(data)){
                return null;
            }
            char[] chars = data.toCharArray();
            Map<Integer, Integer> map = matchBrace(chars);
            return preOrderDecode(chars, map, 0);
        }
        private Map<Integer,Integer> matchBrace(char[] chars){
            Map<Integer,Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '{'){
                    stack.push(i);
                }
                if (chars[i] == '}'){
                    map.put(stack.pop(), i);
                }
            }
            return map;
        }

        private TreeNode preOrderDecode(char[] chars,Map<Integer,Integer> map, int start){
            while (chars[start] != ':'){
                start++;
            }
            int end = start + 1;
            while (chars[end] != ',' && chars[end] != '}') {
                end++;
            }
            int value = Integer.parseInt(new String(chars,start+1,end - start -1));
            TreeNode node = new TreeNode(value);
            if (chars[end] == '}'){
                return node;
            }
            if (chars[end] == ','){
                if (chars[end+1] == 'l'){
                    node.left = preOrderDecode(chars, map,end+3);
                }else {
                    node.right = preOrderDecode(chars,map,end+3);
                }
            }
            Integer pos = map.get(end + 3);
            if (chars[pos+1] != '}'){
                node.right = preOrderDecode(chars, map,pos+4);
            }
            return node;
        }
    }

    //TODO 复习一遍，达到快速写代码实现
    public class CodecII{
        // Encodes a tree to a single string.
        //{v:1,l:{v:2},r:{v:3}}
        //{v1,1{v2},r{v3}}
        //(2)1(3) | X
        public String serialize(TreeNode root) {
            return null;
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return null;
        }
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/
     * medium
     * 题解：1. 滑动窗口 + 散列表
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0;
        Window w = new Window();
        int left = 0;
        int cur = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            w.add(chars[i]);
            cur++;
            if (w.different() <= 2 ){
                continue;
            }
            ans = Math.max(cur-1, ans);
            while (w.different() >= 3){
                w.remove(chars[left++]);
                cur--;
            }
        }
        return Math.max(ans,cur);
    }
    class Window{
        Map<Character,Integer> count = new HashMap<>();
        int nonzero = 0;
        void add(char c){
            Integer times = count.getOrDefault(c, 0);
            count.put(c, times+1);
            if (times == 0){
                nonzero++;
            }
        }
        void remove(char c){
            Integer times = count.get(c);
            count.put(c, times - 1);
            if (times == 1){
                nonzero--;
            }
        }
        int different(){
            return nonzero;
        }
    }

    /**
     * 力扣官方题解
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinctLeetCode(String s) {
        if (s.length() < 3){
            return s.length();
        }
        Map<Character,Integer> map = new HashMap<>();
        int ans = 2;
        int left = 0;
        int right = 0;
        while (right < s.length()){
            if (map.size() < 3){
                map.put(s.charAt(right),right);
            }
            if (map.size() == 3){
                Integer index = map.get(s.charAt(left));
                map.remove(s.charAt(left));
                left = index+1;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/
     * hard
     * 题解： 滑动窗口 + 散列表
     *       1. 双指针确定窗口边界 left = 0 , right = 0
     *       2. map key 存储当前窗口的字符，value 存储字符出现的最右位置
     *       3. 在map.size() <= k 的情况下， right 指针尽量右移， right < s.length()
     *       4. 当 map.size() > k 时，left 指针右移，删除map中下标最小的字符，直到map.size == k 时停止
     *       5. 计算 len
     *       6. 时间复杂度: O(NK) K 为字符串不重复元素个数，一次循环加每次循环中map查找下标最小值
     *       7. 空间复杂度： 额外空间 map ，存储 k 个元素, 可以认为是常数空间 O(1);
     *
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() <= k){
            return k;
        }
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()){
//            if (map.size() <= k){
                map.put(s.charAt(right), right);
//            }
            if (map.size() > k){
                int minIndex = Collections.min(map.values());
                left = minIndex + 1;
                map.remove(s.charAt(minIndex));
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }


}
