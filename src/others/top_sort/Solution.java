package others.top_sort;

import java.util.*;

public class Solution {
    private List<List<Integer>> adj = new ArrayList<>();

    private void sort(Stack<Integer> stack, Set<Integer> visited, int node) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (int nei : adj.get(node)) {
            sort(stack, visited, nei);
        }
        stack.push(node);
    }

    public int[] topSort(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sort(stack, visited, i);
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }
}
