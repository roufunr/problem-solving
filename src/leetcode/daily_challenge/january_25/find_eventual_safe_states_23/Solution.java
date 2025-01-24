package leetcode.daily_challenge.january_25.find_eventual_safe_states_23;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[][] graph;

    private boolean isCyclicUtil(int u, boolean[] visited, boolean[] recStack) {
        if (!visited[u]) {
            visited[u] = true;
            recStack[u] = true;
            for (int x : graph[u]) {
                if (!visited[x] && isCyclicUtil(x, visited, recStack)) {
                    return true;
                } else if (recStack[x]) {
                    return true;
                }
            }
        }
        recStack[u] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            boolean[] visited = new boolean[graph.length];
            boolean[] recStack = new boolean[graph.length];
            if (!isCyclicUtil(i, visited, recStack)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
