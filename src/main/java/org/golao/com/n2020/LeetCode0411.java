package org.golao.com.n2020;

import java.util.*;

/**
 * Created by golao on 2020/4/11.
 * 今日目标： 两道中等 + 两道困难
 * 附加： 写出归并排序，把昨天的题目做到 O(log(m+n)) 复杂度
 */
public class LeetCode0411 {
    /**
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * 难度： 中等
     * 题解： 中序递归很简单，挑战一下迭代方式
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        innerOrder(root,nums);
        return nums;
    }
    private void innerOrder(TreeNode node,List<Integer> nums){
        if (node == null)
            return;
        innerOrder(node.left,nums);
        nums.add(node.val);
        innerOrder(node.right,nums);
    }

    /**
     * https://leetcode-cn.com/problems/accounts-merge/
     * 难度： 中等
     * 题解： email 作为key 存入map中，用O(N)空间换取 O(1)比较速度
     *        value 为 List<accout>  如果存在，则合并
     *        最后剩余的list即已合并完毕的
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,List<String>> map = new HashMap<>();
        Iterator<List<String>> acsIterator = accounts.iterator();
        while (acsIterator.hasNext()){
            List<String> acc = acsIterator.next();
            Iterator<String> iterator = acc.iterator();
            iterator.next();//jump the name
            while (iterator.hasNext()){
                String email = iterator.next();
                List<String> l1 = map.get(email);
                if (l1 != null){
                    //merge

                }else {
                    map.put(email,acc);
//                    map.computeIfAbsent()
                }
            }
        }
        return null;
    }
    private void mergeTwoList(List<String> result , List<String> target){

    }
}
