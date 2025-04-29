package leetcode.random.random_exercise.network_delay_time;
import java.util.*;

class Pair {
    public int node;
    public int distance;
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
} 
class Solution {
    private int dijkstra(List<List<Pair>> adj, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        queue.offer(new Pair(k, 0));
        dist[k] = 0;
        while(!queue.isEmpty()) {
            Pair closestPair = queue.poll();
            int u = closestPair.node;
            int distance = closestPair.distance;
            System.out.println(u + "-> " + distance);
            if(distance > dist[u]) {
                continue;
            }
            for(Pair vPair : adj.get(u)) {
                if(dist[u] + vPair.distance < dist[vPair.node]) {
                    dist[vPair.node] = dist[u] + vPair.distance;
                    queue.offer(new Pair(vPair.node, dist[vPair.node]));
                }
            }
        }
        int min = 0;
        for(int i = 1; i < dist.length; i++) {
            if(i == k) {
                continue;
            }
            int d = dist[i];
            if(d == Integer.MAX_VALUE) {
                return -1;
            }
            min = Math.max(min, d);
        }
        return min;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }
        return dijkstra(adj, n, k);
    }
}