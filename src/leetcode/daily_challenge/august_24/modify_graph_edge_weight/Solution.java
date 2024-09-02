package leetcode.daily_challenge.august_24.modify_graph_edge_weight;

import java.util.*;

class Pair {
    public int v;
    public int w;

    public Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

class Solution {
    private List<List<Integer>> dijkstra(List<List<Pair>> adj, int source, int destination) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.w, p2.w);
            }
        });
        int[] dist = new int[adj.size()];
        Integer[] parent = new Integer[adj.size()];
        dist[source] = 0;
        parent[source] = source;
        pq.offer(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            if (top.v == destination) {
                break;
            }
            for (Pair nei : adj.get(top.v)) {
                if (dist[nei.v] > dist[top.v] + nei.w) {
                    dist[nei.v] = dist[top.v] + nei.w;
                    parent[nei.v] = top.v;
                    pq.offer(new Pair(nei.v, dist[nei.v]));
                }
            }
        }
        int itr = destination;
        List<List<Integer>> path = new ArrayList<>();
        while (itr != source) {
            path.add(new ArrayList<>(Arrays.asList(parent[itr], itr)));
            itr = parent[itr];
        }
        return path;
    }

    private List<List<Integer>> bellman(int n, int[][] edges, int source, int destination) {
        int[] dist = new int[n];
        int inf = (int)Math.pow(10, 9) + 1;
        Arrays.fill(dist, inf); // Initialize all parents to -1
        dist[source] = 0;
        int[] parent = new int[n];
        Arrays.fill(parent, -1); // Initialize all parents to -1
        parent[source] = source;
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                }
                if (dist[u] > dist[v] + w) {
                    dist[u] = dist[v] + w;
                    parent[u] = v;
                }
            }
        }
        List<List<Integer>> path = new ArrayList<>();
        int itr = destination;
        if (parent[itr] == -1) {
            return path;
        }
    
        while (itr != source) {
            path.add(new ArrayList<>(Arrays.asList(parent[itr], itr)));
            itr = parent[itr];
        }
    
        Collections.reverse(path);
        return path;
    }

    private int getTotalDistance(List<List<Integer>> path, Map<String, Integer> weightMap) {
        int total = 0;
        for (List<Integer> p : path) {
            total += weightMap.get(p.get(0) + "_" + p.get(1));
        }
        return total;
    }

    private List<Integer> getNegIdx(List<List<Integer>> path, Map<String, Integer> weightMap) {
        List<Integer> negEdgeIdx = new ArrayList<>();
        int i = 0;
        for (List<Integer> p : path) {
            if (weightMap.get(p.get(0) + "_" + p.get(1)) == -1) {
                negEdgeIdx.add(i);
            }
            i++;
        }
        return negEdgeIdx;
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        Map<String, Integer> weightMap = new HashMap<>();
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
            weightMap.put(edge[0] + "_" + edge[1], edge[2]);
            weightMap.put(edge[1] + "_" + edge[0], edge[2]);
        }
        List<List<Integer>> path = bellman(n, edges, source, destination);
        int totalDist = getTotalDistance(path, weightMap);
        List<Integer> negEdgeIdx = getNegIdx(path, weightMap);
        if (totalDist >= target || negEdgeIdx.size() == 0) {
            return new int[][] {};
        }
        if (negEdgeIdx.size() * 2 > (target - totalDist)) {
            return new int[][] {};
        }

        return new int[][] {};

    }
}