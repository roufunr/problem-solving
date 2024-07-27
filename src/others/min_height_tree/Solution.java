package others.min_height_tree;
import java.util.*;

public class Solution { // got TLE
    private List<List<Integer>> adj = new ArrayList<>();
    private void construct(int n, int[][] edges) {
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    }
    private int getHeight(int src) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(src, 0);
        int maxHeight = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()) {
            int top = queue.poll();
            maxHeight = Math.max(maxHeight, map.get(top));
            for(int nei : adj.get(top)) {
                if(!map.containsKey(nei)) {
                    map.put(nei, map.get(top) + 1);
                    queue.offer(nei);
                }
            }
        }
        return maxHeight;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0) {
            return new ArrayList<>(Arrays.asList(0));
        }
        if(edges.length == 1) {
            return new ArrayList<>(Arrays.asList(edges[0][0], edges[0][1]));
        }
        construct(n, edges);
        int minHeight = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int minDegree = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            minDegree = Math.min(minDegree, adj.get(i).size());
        }
        for(int i = 0; i < n; i++) {
            if(minDegree != adj.get(i).size()) {
                map.put(i, getHeight(i));
                minHeight = Math.min(minHeight, map.get(i));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer i : map.keySet()) {
            if(minHeight == map.get(i)) {
                ans.add(i);
            } 
        }
        return ans;
    }
}