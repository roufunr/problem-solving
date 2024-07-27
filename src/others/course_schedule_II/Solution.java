package others.course_schedule_II;

import java.util.*;

public class Solution {
    private List<List<Integer>> adj = new ArrayList<>();
    private boolean hasCycle = false;

    private void constructGraph(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
    }

    private void topSort(Set<Integer> path, Set<Integer> visited, Stack<Integer> stack, int node) {
        if (path.contains(node)) {
            hasCycle = true;
            return;
        }
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        path.add(node);
        for (int nei : adj.get(node)) {
            topSort(path, visited, stack, nei);
        }
        stack.push(node);
        path.remove(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        constructGraph(numCourses, prerequisites);
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            topSort(path, visited, stack, i);
        }
        if (hasCycle) {
            return new int[0];
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }
}