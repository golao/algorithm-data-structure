package org.golao.com.n2020.m06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode0606 {
    /**
     * https://leetcode-cn.com/problems/longest-consecutive-sequence/
     * 难度：hard
     * 难度在要求时间复杂度在O(n)
     * 题解： 1. 遍历，对每个数对 nums.length 取模，余数存储在map中
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        //特例处理
        if (nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer,Node> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] / nums.length;
            int mod = nums[i] % nums.length;
            Node node = map.get(n);
            if (node == null){
                map.put(n,new Node(mod));
            }else {
                node.insert(mod);
            }
        }
        //所有相邻边界都要连接一下，才能取出最大的连续串
        //不能用TreeMap ，只要涉及排序，时间复杂度肯定超 O(n)
        int max = 0;
        Map.Entry<Integer,Node> maxNode = null;
        for (Map.Entry<Integer, Node> entry: map.entrySet()){
            int maxSeq = mergeAnsFindMaxSeq(entry.getValue(), entry.getKey(), map, nums.length);
            max = Math.max(max,maxSeq);
        }
        return max;
    }

    private Node.Seq getTailSeq(Node node, int nmod, int mod){
        return node == null ? null : nmod > 0 ? node.ary.get(0) : node.ary.get(1 - mod);

    }
    private Node.Seq getHeadSeq(Node node, int nmod, int mod){
        return node == null ? null : nmod >= 0 ? node.ary.get(mod - 1) : node.ary.get(0);
    }


    private int mergeAnsFindMaxSeq(Node node, int nmod,Map<Integer,Node> map,int mod){
        //上界合并
        Node upper = map.get(nmod + 1);
        Node.Seq nodeHeadSeq = getHeadSeq(node, nmod, mod);
        Node.Seq upperTailSeq = getTailSeq(upper, nmod + 1, mod);
        int max = 0;
        if (upperTailSeq != null && nodeHeadSeq != null){
            max = Math.max(max, upperTailSeq.size + nodeHeadSeq.size);
        }
        //下界合并
        Node lower = map.get(nmod - 1);
        Node.Seq nodeTailSeq = getTailSeq(node, nmod, mod);
        Node.Seq lowerHeadSeq = getHeadSeq(lower, nmod - 1, mod);
        if (nodeTailSeq != null && lowerHeadSeq != null){
            max = Math.max(max, nodeTailSeq.size + lowerHeadSeq.size);
        }
        return Math.max(max,node.maxSeq);
    }

    static class Node{
        int maxSeq;
        Map<Integer,Seq> ary;
        Node(){
            maxSeq = 0;
            ary = new HashMap<>();
        }
        Node(int mod){
            this();
            insert(mod);
        }
        public void insert(int index){
            //查询前后界是否存在，存在则加入seq
            Seq seq = this.ary.get(index);
            if (seq != null){
                return;
            }
            Seq pre = this.ary.get(index - 1);
            Seq next = this.ary.get(index + 1);
            //1. 只有上界 2. 只有下界 3. 上下界都有 4 上下界都没有
            if (pre != null){
                if (next == null){//1. 只有上界
                    pre.size += 1;
                    ary.put(index,pre);
                    maxSeq = Math.max(pre.size, maxSeq);
                }else{// 3 .上下界都有
                    merge(pre,next,index);
                }
            }else {
                if (next == null){//4. 上下界都无
                    ary.put(index,new Seq(index));
                    maxSeq = Math.max(maxSeq,1);
                }else{//2. 只有下界
                    next.size += 1;
                    maxSeq = Math.max(maxSeq,next.size);
                    ary.put(index,next);
                }
            }
        }
        //长的合并短的
        private void merge(Seq pre, Seq next,int index){
            this.maxSeq = Math.max(maxSeq,pre.size + next.size + 1);
            if (pre.size >= next.size){
                pre.size += next.size + 1;
                while(next.size > -1){
                    this.ary.put(index++,pre);
                    next.size--;
                }
            }else {
                next.size += pre.size + 1;
                while (pre.size > -1){
                    this.ary.put(index--,next);
                    pre.size--;
                }
            }
        }
        static class Seq{
            int size;
            Seq(int index){
                this.size = 1;
            }
        }
    }

    /**
     * 力扣官方题解
     * 将nums存入set中，遍历nums，对 nums[i],在set中查找 nums[i]+1 是否存在，尽可能长的查找nums[i]+x
     * 减除无效的查找，如存在 nums[i]-1. 则跳过，因为会被其他数查找到，所以无需进行查找
     * 时间复杂度为 O(n)
     * @param nums
     * @return
     */
    public int longestConsecutiveLeetCode(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n :  nums) {
            set.add(n);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)){
                int curentNum = nums[i] + 1;
                int longest = 1;
                while (set.contains(curentNum)){
                    curentNum += 1;
                    longest++;
                }
                max = Math.max(longest, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode0606 leetCode0606 = new LeetCode0606();
//        int[] ary = {1,3,5,2,4};
        int[] ary = {21_4748_3646,-21_4748_3647,0,2,21_4748_3644,-21_4748_3645,21_4748_3645};
        int i = leetCode0606.longestConsecutive(ary);
        System.out.println(i);
    }
}
