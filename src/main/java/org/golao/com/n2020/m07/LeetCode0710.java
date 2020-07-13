package org.golao.com.n2020.m07;

import java.util.*;

public class LeetCode0710 {
    /**
     * https://leetcode-cn.com/problems/jump-game-iii/
     * 1306. 跳跃游戏 III
     * 思路：   BFS
     * 1. visited 数组，标记已访问过的节点
     * 2. 时间复杂度: O(n)
     * 3. 空间复杂度: O(n)
     * 4. 属于比较简单的 BFS 模式
     *
     * @param arr
     * @param start
     * @return
     */
    public boolean canReach(int[] arr, int start) {
        int len = arr.length;
        boolean[] visited = new boolean[len];
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(start);
        while (!deque.isEmpty()) {
            Integer index = deque.removeFirst();
            if (arr[index] == 0) {
                return true;
            }
            if (!visited[index]) {
                if (index + arr[index] < len) {
                    deque.addLast(index + arr[index]);
                }
                if (index - arr[index] >= 0) {
                    deque.addLast(index - arr[index]);
                }
            }
            visited[index] = true;
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/jump-game-iv/
     * hard
     * 1345. 跳跃游戏 IV
     * 思路： 1. BFS ，只要某层到达了最后一个下标，返回层数
     * 2. 辅助空间 map记录相等元素的下标
     * 3. 时间复杂度: O(n)
     * 4. 空间复杂度: O(n)
     *
     * @param arr
     * @return
     */
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            list.add(i);
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer index = deque.removeFirst();
                if (index == arr.length - 1) {
                    return level;
                }
                if (arr[index] == Integer.MAX_VALUE) {
                    continue;
                }
                if (index + 1 < arr.length && arr[index+1] != arr[index]) {
                    deque.addLast(index + 1);
                }
                if (index - 1 >= 0 && arr[index+1] != arr[index]) {
                    deque.addLast(index - 1);
                }
                List<Integer> list = map.get(arr[index]);
                if (list != null) {
                    list.stream().filter(x -> !index.equals(x))
                                 .forEach(x -> deque.addLast(x));
                    map.remove(arr[index]);
                }

                arr[index] = Integer.MAX_VALUE;
            }
            level++;
        }
        return level;
    }
}
