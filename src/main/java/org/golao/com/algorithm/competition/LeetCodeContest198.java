package org.golao.com.algorithm.competition;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeContest198 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty = numBottles / numExchange + numBottles % numExchange;
        ans += numBottles / numExchange;
        while(empty >= numExchange){
            ans += empty / numExchange;
            empty = empty / numExchange + empty % numExchange;
        }
        return ans;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(adjList,0, labels, ans, visited);
        return ans;
    }

    private int[] dfs(List<List<Integer>> adjList,
                      int node, String lables, int[] ans, boolean[] visited){
        int[] count = new int[26];
        int index = lables.charAt(node) - 'a';
        count[index]++;
        if (adjList.get(node).size() == 0){
            ans[node] = 1;
            return count;
        }
        List<Integer> edges = adjList.get(node);
        for (int i = 0; i < edges.size(); i++) {
            if (visited[edges.get(i)]){
                continue;
            }
            visited[edges.get(i)] = true;
            int[] chars = dfs(adjList, edges.get(i), lables, ans, visited);
            for (int j = 0; j < count.length; j++) {
                count[j] += chars[j];
            }
        }
        ans[node] = count[index];
        return count;
    }
}
