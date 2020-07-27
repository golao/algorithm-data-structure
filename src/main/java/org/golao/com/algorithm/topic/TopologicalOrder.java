package org.golao.com.algorithm.topic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序专题
 */
public class TopologicalOrder {
    /**
     * https://leetcode-cn.com/problems/course-schedule/
     * medium
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        //[0,1] 代表 1 是 0 的前置
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;// 入度
            adjList.get(pre[1]).add(pre[0]); // 出度
        }
        //将入度为 0 的顶点加入到队列中
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            Integer vertex = queue.poll();
            numCourses--;
            List<Integer> edges = adjList.get(vertex);
            for (int e : edges) {
                if(--indegree[e] == 0){
                    queue.offer(e);
                }
            }
        }
        return numCourses == 0;
    }

    /**
     * https://leetcode-cn.com/problems/course-schedule-ii/
     * 210. 课程表 II
     * 思路：  与上题思路一致，只是返回值不同
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return null;
    }

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        s = s.trim();
        int index = s.lastIndexOf(" ");

        return s.length() - index - 1;
    }
}
