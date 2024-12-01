package leetcode.daily_challenge.november_24.valid_arrangement_of_pairs_30;
import java.util.*;
public class Solution {
    private void calculateInAndOutCount(Map<Integer, Integer> inCount, Map<Integer, Integer> outCount, int[][] pairs) {
        for(int[] pair : pairs) {
            inCount.put(pair[1], inCount.getOrDefault(pair[1], 0) + 1);
            outCount.put(pair[0], outCount.getOrDefault(pair[0], 0) + 1);
        }
    }
    private int findInitialNode(Map<Integer, Integer> inCount, Map<Integer, Integer> outCount) {
        for(int key : outCount.keySet()) {
            if(outCount.get(key) - inCount.getOrDefault(key, 0) == 1) {
                return key;
            }
        }
        return outCount.keySet().iterator().next();
    }
    private Map<Integer, List<Integer>> generateGraph(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] pair : pairs) {
            if(!graph.containsKey(pair[0])) {
                graph.put(pair[0], new ArrayList<>());
            }
            graph.get(pair[0]).add(pair[1]);
        }
        return graph;
    }
    private void dfs(int fromNode, Map<Integer, List<Integer>> graph, List<Integer> path, Map<Integer, Integer> outCount) {
        if(outCount.containsKey(fromNode)) {
            while(outCount.get(fromNode) > 0) {
                outCount.put(fromNode, outCount.get(fromNode) - 1);
                int nextNode = graph.get(fromNode).get(outCount.get(fromNode));
                dfs(nextNode, graph, path, outCount);
            }
        }
        path.add(fromNode);
    }
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Integer> inCount = new HashMap<>();
        Map<Integer, Integer> outCount = new HashMap<>();
        calculateInAndOutCount(inCount, outCount, pairs);
        int fromNode = findInitialNode(inCount, outCount);
        Map<Integer, List<Integer>> graph = generateGraph(pairs);
        List<Integer> path = new ArrayList<>(); 
        dfs(fromNode, graph, path, outCount);
        int[][] ans = new int[pairs.length][2];
        int j = 0;
        for(int i = path.size() - 1; i > 0; i--) {
            ans[j++] = new int[]{path.get(i), path.get(i - 1)};
        }
        return ans;
    }
}