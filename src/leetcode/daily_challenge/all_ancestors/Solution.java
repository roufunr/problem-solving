package leetcode.daily_challenge.all_ancestors;

import java.util.*;

public class Solution {
    public void bfs(int i, List<List<Integer>> adjList, boolean[] parents) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int v : adjList.get(top)) {
                if (parents[v]) {
                    continue;
                } else {
                    parents[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean[] parents = new boolean[n];
            bfs(i, adjList, parents);
            List<Integer> ancestors = new ArrayList<>();
            for (int j = 0; j < parents.length; j++) {
                if (parents[j]) {
                    ancestors.add(j);
                }
            }
            ans.add(ancestors);
        }
        return ans;
    }
}