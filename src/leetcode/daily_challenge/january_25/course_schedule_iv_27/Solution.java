package leetcode.daily_challenge.january_25.course_schedule_iv_27;

import java.util.*;

public class Solution {
    List<Integer>[] graph;
    private Set<Integer> bfs( int source) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        set.add(source);
        while(!queue.isEmpty()) {
            int top = queue.poll();
            for(int nei : graph[top]) {
                if(!set.contains(nei)) {
                    set.add(nei);
                    queue.offer(nei);
                }
            }
        }
        return set;
    }
    @SuppressWarnings("unchecked")
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] preq : prerequisites) {
            graph[preq[1]].add(preq[0]);
        }
        List<Boolean> ans = new ArrayList<>();
        List<Set<Integer>> sets = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            sets.add(bfs(i));
        }
        for(int[] query : queries) {
            ans.add(sets.get(query[1]).contains(query[0]));
        }
        return ans;
    }
}
