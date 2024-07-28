package leetcode.daily_challenge.second_min_time;

import java.util.*;

public class Solution {
    private List<List<Integer>> adj = new ArrayList<>();

    private void construct(int n, int[][] edges) {
        for (int i = 1; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0] - 1).add(edge[1] - 1);
            adj.get(edge[1] - 1).add(edge[0] - 1);
        }
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        construct(n, edges);
        Map<Integer, List<Integer>> visited = new HashMap<>();
        for (int i = 0; i < n; i++) {
            visited.put(i, new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean onceVisited = false;
        int currentTime = 0;
        
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            for(int i = 0; i < currentLevelSize; i++) {
                int curNode = queue.poll();
                if (curNode == n - 1) {
                    if (onceVisited == false) {
                        onceVisited = true;
                    } else {
                        return currentTime;
                    }
                }
                for (int nei : adj.get(curNode)) {
                    if (visited.get(nei).size() == 0) {
                        visited.get(nei).add(currentTime);
                        queue.offer(nei);
                    } else if (visited.get(nei).size() == 1 && visited.get(nei).get(0) != currentTime) {
                        visited.get(nei).add(currentTime);
                        queue.offer(nei);
                    }
                }
            }
            if ((currentTime / change) % 2 == 1) {
                currentTime += change - (currentTime % change);
            }
            currentTime += time;
            
        }
        return -1;
    }
}