package org.golao.com.algorithm.competition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeetCodeContest200 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int ij = Math.abs(arr[i] - arr[j]);
                if (ij > a) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    int ik = Math.abs(arr[i] - arr[k]);
                    int jk = Math.abs(arr[j] - arr[k]);
                    if (ik > c || jk > b) {
                        continue;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        if (k >= n){
            return max;
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[0] == max){
                return max;
            }
            if (arr[0] > arr[i]){
                count++;
                if (count == k){
                    return arr[0];
                }
            }else {
                count = 1;
                if (count == k){  // 细节
                    return arr[i];
                }
                arr[0] = arr[i];
            }
        }
        return max;
    }

    public int maxSum(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i],i);
        }
        Queue<Node> queue = new LinkedList<>();
        int max = nums1[0] > nums2[0] ? nums1[0] : nums2[0];
        queue.add(new Node(nums1[0],0, true));
        queue.add(new Node(nums2[0],0, false));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if (node.isN1){
                int next = node.index + 1;
                if (next < nums1.length){
                    Node n1 = new Node(node.sum, nums1[next], next, true);
                    queue.offer(n1);

                }else {
                    max = Math.max(max, node.sum);
                }
                Integer i2 = map2.get(nums1[node.index]);
                if (i2 != null && i2 + 1 < nums2.length){
                    Node n2 = new Node(node.sum , nums2[i2 + 1], i2 + 1, false);
                    queue.offer(n2);
                }
            }else {
                int next = node.index + 1;
                if (next < nums2.length){
                    Node n2 = new Node(node.sum , nums2[next],next, false);
                    queue.offer(n2);

                }else {
                    max = Math.max(max, node.sum);
                }
                Integer i1 = map1.get(nums2[node.index]);
                if (i1 != null && i1 + 1 < nums1.length){
                    Node n1 = new Node(node.sum , nums1[i1 + 1], i1 + 1, true);
                    queue.offer(n1);
                }
            }
        }
        return max;
    }

    class Node{
        int sum;
        int index;
        boolean isN1;
        Node(){}
        Node(int n1, int n2, int index, boolean isN1){
            this(0, index, isN1);
            int INF = 1000000007;
            this.sum = (n1 % INF + n2 % INF) % INF;
        }
        Node(int sum, int index, boolean isN1){
            this.sum = sum;
            this.index = index;
            this.isN1 = isN1;
        }

    }
}
