package leetcode.daily_challenge.november_24.shortest_distance_after_road_addition_queries_I_27;
import java.util.*;
public class Solution {
    private int dist(List<List<Integer>> graph, int from, int to) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> dist = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visited.add(from);
        dist.put(from, 0);
        while(!queue.isEmpty()) {
            int top = queue.poll();
            if(top == to) {
                return dist.get(top);
            }
            for(int v : graph.get(top)) {
                if(!visited.contains(v)) {
                    visited.add(v);
                    dist.put(v, dist.get(top) + 1);
                    queue.offer(v);
                }
            }
        }
        return -1;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            graph.add(list);
        }
        for(int i = 1; i < n; i++) {
            int from = i - 1;
            int to = i;
            graph.get(from).add(to);
        }
        int[] ans = new int[queries.length];
        int i = 0;
        for(int[] query : queries) {
            graph.get(query[0]).add(query[1]);
            ans[i++] = dist(graph, 0, n - 1);
        }
        return ans;
    }
}