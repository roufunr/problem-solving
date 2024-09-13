package leetcode.top150.jump_game_II_10;

import java.util.*;

public class Solution {
    private int bfs(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        int[] parent = new int[adj.size()];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        parent[0] = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int nei : adj.get(top)) {
                if (nei < visited.length && visited[nei] == false) {
                    parent[nei] = top;
                    visited[nei] = true;
                    queue.offer(nei);
                }
            }
        }
        int pathLen = 0;
        int itr = adj.size() - 1;
        while (itr != 0) {
            pathLen++;
            itr = parent[itr];
        }
        return pathLen;
    }

    public int jump(int[] nums) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                if(i + j + 1 < nums.length) adj.get(i).add(i + j + 1);
            }
        }
        return bfs(adj);
    }
}
