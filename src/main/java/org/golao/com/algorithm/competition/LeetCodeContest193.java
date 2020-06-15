package org.golao.com.algorithm.competition;

import java.util.*;

public class LeetCodeContest193 {
    /**
     * 1
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        if (nums.length == 1){
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }

    /**
     * 2
     * @param arr
     * @param k
     * @return
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer times = map.get(arr[i]);
            times = times == null ? 1 : times + 1;
            map.put(arr[i],times);
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((key,value) -> {
            list.add(value);
        });
        int ans = map.size();
        list.sort((x1,x2) -> x1 - x2);
        for (int i = 0; i < list.size(); i++) {
            k = k - list.get(i);
            if (k >= 0){
                ans--;
            }else {
                break;
            }
        }
        return ans;
    }

    /**
     * 3
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        return 0;
    }

    /**
     * 4
     */
    class TreeAncestor {
        class Node{
            LinkedList<Node> list;
            Node parent;
            Node pre;
            Node next;
            int value;

            Node(int value, Node parent){
                this.value = value;
                this.parent = parent;
            }
        }
        private Node tree;
        private Node findNodeByValue(int value){


            return null;
        }
        public TreeAncestor(int n, int[] parent) {
            this.tree = new Node(0, null);
            int pv = 0;
            n--;
            int i = 1;
            while (n > 0){
                if (parent[i] == pv){
                    
                }else {
                    pv = parent[i];
                }
                i++;
                n--;
            }
        }

        public int getKthAncestor(int node, int k) {
            Node nodeByValue = findNodeByValue(node);
            while (k > 0 && nodeByValue != null){
                nodeByValue = nodeByValue.parent;
                k--;
            }
            return nodeByValue == null ? -1 : nodeByValue.value;
        }
    }
}
