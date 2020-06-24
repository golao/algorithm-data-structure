package org.golao.com.n2020;

import com.sun.corba.se.spi.ior.IdentifiableFactory;

import java.util.*;

public class LeetCode0623 {
    /**
     * https://leetcode-cn.com/problems/add-binary/
     * easy   编号：67
     * 模拟相加
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if (a.length() < b.length()){
            return addBinary(b,a);
        }
        StringBuilder add = new StringBuilder();
        int pa =  a.length() -1;
        int pb =  b.length() -1;

        int have = 0;
        while (pb >= 0){
            if (a.charAt(pa) == b.charAt(pb)){
                if (a.charAt(pa) == '1'){
                    have += 2;
                }
            }else {
                have += 1;
            }
            have = add(add, have);
            pa--;
            pb--;
        }
        while (pa >= 0){
            if (a.charAt(pa) == '1'){
                have += 1;
            }
            have = add(add,have);
            pa--;
        }
        if (have > 0){
            add.append(1);
        }
        return add.reverse().toString();
    }

    private int add(StringBuilder add,int have){
        if (have <= 1){
            add.append(have);
            have = 0;
        }else {
            if (have == 3){
                add.append("1");
            }else {
                add.append("0");
            }
            have = 1;
        }
        return have;
    }

    /**
     * 1. 当前位的取值，是根据 a b 相加后的值，对进制进行取模，即 carry % 2
     * 2. carry =  carry / 2
     * 3. 低位对齐， 高位补零，按最长字符串来一次循环，可以少处理一层
     * 4. 最后要查看 carry 位是否还有值，有则要加入结果中,写代码时要先写这个逻辑，以免忘了
     * 5. 这个思路和代码，可以解决大部分大数相加的类型题
     * 6. 我上面的代码，用了模拟和双指针移动，在逻辑判断上，不如补齐方便简洁
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinaryLeetCode(String a, String b){
        StringBuilder add = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            add.append((char)((carry % 2) +  '0'));
            carry /= 2;
        }
        if (carry > 0){
            add.append('1');
        }
        return add.reverse().toString();
    }

    /**
     * https://leetcode-cn.com/problems/continuous-subarray-sum/
     * medium   编号： 523
     * 思路：官方题解
     * //TODO 自己实现一遍
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySumLeetCode(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<> ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/sorted-merge-lcci/
     * easy
     * 面试题 10.01. 合并排序的数组
     * 题解： 1. 新建一个数组空间  temp[A.length]
     *        2. 像归并排序一样，轮流比较两个数组，合并到 temp
     *        3. 将temp 复制到A中
     *  这个解法是需要额外的空间的，面试应该会考察原地排序，要求空间复杂度O(1)的解法
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int[] temp = new int[A.length];
        int i = 0, j = 0, t = 0;
        while (i < m && j < n){
            temp[t++] = A[i] <= B[j] ? A[i++] : B[j++];
        }
        while (i < m){
            temp[t++] = A[i++];
        }
        while (j < n){
            temp[t++] = B[j++];
        }
        System.arraycopy(temp,0,A,0,A.length);
    }

    /**
     * 官方题解： 逆序双指针
     *         1. A的尾部有足够容纳 B组元素空间，所以将元素从大到小，依次填入A的尾部
     *         2. 和顺序双指针，一个思路，但省去了额外空间开销
     *         3. 时间复杂度： O(n)
     *         4. 空间复杂度： O(1)
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void mergeLeetCode(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int t = m + n - 1;
        while (i >= 0 && j >= 0){
            A[t--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (j >= 0){
            A[t--] = B[j--];
        }
    }

    /**
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * easy  编号：21
     * 题解： 双指针，思路上没难度
     *        1. 重点是实现上用哨兵模式，代码会简洁很多，自己写的ac版本
     *           为了返回头结点费力了。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    /**
     * https://leetcode-cn.com/problems/remove-element/
     * easy 编号 27
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0 , right = nums.length - 1;
        int ans = 0;
        while (left <= right){
            while (left <= right && nums[left] != val){
                left++;
            }
            while (left <= right && nums[right] == val){
                right--;
                ans++;
            }
            if (left <= right){
                nums[left] = nums[right];
                ans++;
            }
            left++;
            right--;
        }
        return nums.length - ans;
    }

    /**
     * 思路： 快慢指针法，j 为快指针，i为慢指针
     *        遇到 nums = val 时 跳过，nums[i] 则按顺序
     * @param nums
     * @param val
     * @return
     */
    public int removeElementFastAndSlowPointer(int[] nums, int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    /**
     * https://leetcode-cn.com/problems/same-tree/
     * easy
     * 100. 相同的树
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);
        return left && right;
    }


}
