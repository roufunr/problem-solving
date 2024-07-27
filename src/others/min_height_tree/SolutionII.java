package others.min_height_tree;

import java.util.*;

public class SolutionII {
    // efficient solution with order of O(N)
    // using topsort

    private List<Set<Integer>> adj = new ArrayList<>();

    private void construct(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 2) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            return ans;
        }
        construct(n, edges);
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int leafsNeighbour = adj.get(leaf).iterator().next();
                adj.get(leafsNeighbour).remove(leaf);
                adj.get(leaf).remove(leafsNeighbour);
                if (adj.get(leafsNeighbour).size() == 1) {
                    newLeaves.add(leafsNeighbour);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}