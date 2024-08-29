package leetcode.daily_challenge.august_24.most_stones_removed_with_same_row_or_column;

import java.util.*;

public class Solution {
    private void dfs(int node, Set<Integer> visited, List<List<Integer>> adj) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (int nei : adj.get(node)) {
            dfs(nei, visited, adj);
        }
    }

    public int removeStones(int[][] stones) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                int[] stone1 = stones[i];
                int[] stone2 = stones[j];
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        int clusterCount = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited.contains(i)) {
                clusterCount++;
                dfs(i, visited, adj);
            }
        }
        int maxCanBeRemoved = stones.length - clusterCount;
        return maxCanBeRemoved;
    }
}
