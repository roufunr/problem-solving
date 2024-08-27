package leetcode.daily_challenge.august_24.path_with_max_probability;

import java.util.*;

class Pair {
    public int val;
    public double prob;

    public Pair(int val, double prob) {
        this.val = val;
        this.prob = prob;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int i = 0;
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], succProb[i]));
            adj.get(edge[1]).add(new Pair(edge[0], succProb[i]));
            i++;
        }
        double[] dist = new double[n];
        dist[start_node] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Double.compare(p2.prob, p1.prob);
            }
        });
        pq.add(new Pair(start_node, 1));
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            for (Pair nei : adj.get(top.val)) {
                if (dist[nei.val] < dist[top.val] * nei.prob) {
                    dist[nei.val] = dist[top.val] * nei.prob;
                    pq.offer(new Pair(nei.val, dist[nei.val]));
                }
            }
        }
        return dist[end_node];
    }
}