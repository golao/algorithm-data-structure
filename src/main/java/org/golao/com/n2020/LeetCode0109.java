package org.golao.com.n2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by golao on 2020/1/9.
 */
public class LeetCode0109 {
    /**
     * 难度：简单
     *  一种方式是 判断是否为大写字母，然后 + 32 得到小写字母
     *  一种是调用库函数 toLowerCase
     * https://leetcode-cn.com/problems/to-lower-case/
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /**
     * 难度：简单
     * 先用暴力解决
     * 优化解法参考此人的方法三 https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix/solution/ti-jie-1252-qi-shu-zhi-dan-yuan-ge-de-shu-mu-by-ze/
     * https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix/
     *
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public int oddCells(int n, int m, int[][] indices) {
        int[][] arc = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            for (int j = 0; j < m; j++) {
                arc[row][j]++;
            }
            int c = indices[i][1];
            for (int j = 0; j < n; j++) {
                arc[j][c]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arc[i][j] % 2 == 1){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 难度：简单
     * 类似冒泡排序，把右边最大值比较出来，替换
     * 优化点： 如果后一个值不等于max值，直接替换到该max值前的一位
     * 更优解： 从右往左遍历，维护当前max值
     * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            int index = -1;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] >= max){
                    max = arr[j];
                    index = j;
                }
            }
            if (index != i){
                for (int j = i - 1; j < index; j++) {
                    arr[j] = max;
                }
                i = index - 1;
            }else {
                arr[i-1] = max;
            }
            max = 0;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    /**
     * 倒序
     * @param arr
     * @return
     */
    public int[] replaceElementsBatter(int[] arr){
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp,max);
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    /**
     * 难度：中等
     * 题解： 先深度遍历得到树的最大深度，再次遍历时，将最大深度节点的值相加
     * https://leetcode-cn.com/problems/deepest-leaves-sum/
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = depth(root,0);
        return depthValue(root,0,0,maxDepth);
    }
    private int depth(TreeNode node, int depth){
        depth++;
        int left = depth;
        int right = depth;
        if (node.left != null){
            left = depth(node.left,depth);
        }
        if (node.right != null){
            right = depth(node.right,depth);
        }
        return Math.max(left,right);
    }
    private int depthValue(TreeNode node , int depth,int sum,int max){
        depth++;
        if (depth == max){
            sum += node.val;
            return sum;
        }
        if (node.left != null){
            sum = depthValue(node.left,depth,sum,max);
        }
        if (node.right != null){
            sum = depthValue(node.right,depth,sum,max);
        }
        return sum;
    }
    //TODO 更优版 ： 各写一个dfs 和 一个 bfs，要点是边遍历边计算深度，和同深度的节点值的和


    /**
     * 难度： 中等
     * 题解： 如果 groupSize = 1 ，比如是一个人一组；
     *        groupSize > 1 ,则寻找值一样的人，归入一组
     * https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to/
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.get(groupSizes[i]);
            if (list != null && list.size() < groupSizes[i] ){
                list.add(i);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(groupSizes[i],l);
            }
            list = map.get(groupSizes[i]);
            if (list.size() == groupSizes[i]){
                result.add(list);
                map.remove(groupSizes[i]);
            }
        }
        return result;
    }

}
