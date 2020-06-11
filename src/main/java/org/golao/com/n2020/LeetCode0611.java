package org.golao.com.n2020;

import java.util.*;

public class LeetCode0611 {
    /**
     * https://leetcode-cn.com/problems/daily-temperatures/
     * 难度: medium
     * 题解： 1. 暴力法，找到最近的比当前值大的数，计算距离
     *            时间复杂度： O(n²)
     *        2. 逆序，从右边遍历，始终维护一个递增队列
     *           见{@link #dailyTemperaturesOpt(int[])}}
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 1) {
            return new int[]{0};
        }
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i+1; j < T.length; j++) {
                if (T[i] < T[j]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 题解： 逆序遍历，额外维护一个递增队列，当前值如大于队列头部值，则移除队列值
     *        直到找到队列中大于当前值的点，或者队列为空，则停止，队列最多操作 N 次
     *        所以该算法时间复杂度为 O(n) , 空间复杂度为 O(n), 力扣一般不把返回的ans
     *        数组计算到空间复杂度中
     * @param T
     * @return
     */
    public int[] dailyTemperaturesOpt(int[] T) {
        int[] ans = new int[T.length];
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.addFirst(new Node(T[T.length - 1], T.length - 1));
        for (int i = T.length - 2; i >= 0; i--) {
            //小于等于时，要移除队列的值，直到找到大于或者队列为空时，最后加入队列
            while (!linkedList.isEmpty() && linkedList.getFirst().value <= T[i]){
                linkedList.removeFirst();
            }
            if (!linkedList.isEmpty()){
                ans[i] = linkedList.getFirst().index - i;
            }
            linkedList.addFirst(new Node(T[i],i));
        }
        return ans;
    }
    static class Node{
        int value;
        int index;
        Node(int v, int i){
            this.index = i;
            this.value = v;
        }
    }

    /**
     * 对{@link #dailyTemperaturesOpt(int[])}进行优化，栈只存储下标，不用额外 Node 结构
     * @param T
     * @return
     */
    public int[] dailyTemperaturesOptI(int[] T) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while(!deque.isEmpty() && T[i] >= T[deque.getFirst()]){
                deque.removeFirst();
            }
            if (!deque.isEmpty()){
                ans[i] = deque.getFirst() - i;
            }
            deque.addFirst(i);
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/next-greater-element-i/
     * 难度： easy
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0){
            return new int[]{};
        }
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!deque.isEmpty() && nums2[i] > deque.getFirst()){
                Integer index = map.get(deque.removeFirst());
                ans[index] = nums2[i];
            }
            if (map.containsKey(nums2[i])){
                deque.addFirst(nums2[i]);
            }
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/next-greater-element-ii/
     * 难度： medium
     * @param nums
     * @return
     */
    public int[] nextGreaterElementsII(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        int[] back = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
             while (!deque.isEmpty() && nums[i] > nums[deque.getFirst()]){
                 int index = deque.removeFirst();
                 ans[index] = nums[i];
             }
             deque.addFirst(i);
        }
        Deque<Integer> deque2 = new LinkedList<>();
        while (!deque.isEmpty()){
            while (!deque2.isEmpty() && nums[deque.getFirst()] > nums[deque2.getFirst()]) {
                Integer index = deque2.removeFirst();
                ans[index] = nums[deque.getFirst()];
            }
            deque2.addFirst(deque.removeFirst());
        }
        return ans;
    }


}
