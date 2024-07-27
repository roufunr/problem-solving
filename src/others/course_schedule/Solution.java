package others.course_schedule;

import java.util.*;
public class Solution {
    private List<List<Integer>> adj = new ArrayList<>();

    private void constructGraph(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }
    }
    private boolean hasCycle(Set<Integer> path, Set<Integer> visited, int node) {
        if(path.contains(node)) {
            return true;
        }
        if(visited.contains(node)) {
            return false;
        }
        path.add(node);
        visited.add(node);
        
        boolean cycle = false;
        for(int nei : adj.get(node)) {
            cycle |= hasCycle(path, visited, nei);
        }
        path.remove(node);
        return cycle;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        constructGraph(numCourses, prerequisites);
        for(int i = 0; i < numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> path = new HashSet<>();
            if(hasCycle(path, visited, i)) {
                return false;
            }
        }
        return true;
    }
}

