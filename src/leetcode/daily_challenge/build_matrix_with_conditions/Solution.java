package leetcode.daily_challenge.build_matrix_with_conditions;

import java.util.*;
public class Solution {
    private boolean dfs(int src, List<List<Integer>> adj, Set<Integer> visited, Set<Integer> path, List<Integer> orderedList) {
        if(path.contains(src)) {
            return false;
        }
        if(visited.contains(src)) {
            return true;
        }
        path.add(src);
        visited.add(src);
        for(int n : adj.get(src)) {
            if(!dfs(n, adj, visited, path, orderedList)) {
                return false;
            }
        }
        path.remove(src);
        orderedList.add(src);
        return true;
    }

    private List<Integer> topSort(int[][] conditions, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : conditions) {
            adj.get(edge[0] - 1).add(edge[1] - 1);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        List<Integer> orderedList = new ArrayList<>();
        for(int i = 0; i < adj.size(); i++) {
            if(!dfs(i, adj, visited, path, orderedList)) {
                return new ArrayList<>();
            }
        }
        for(int i = 0; i < orderedList.size(); i++) {
            orderedList.set(i, orderedList.get(i) + 1);
        }
        Collections.reverse(orderedList);
        return orderedList;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> orderedRow = topSort(rowConditions, k);
        List<Integer> orderedCol = topSort(colConditions, k);
        if(orderedRow.size() == 0 || orderedCol.size() == 0) {
            return new int[0][0];
        }
        Map<Integer, Integer> rowMap = new HashMap<>();
        for(int i = 0; i < orderedRow.size(); i++) {
            rowMap.put(orderedRow.get(i), i);
        }
        int[][] ans = new int[k][k]; 
        for(int i = 0; i < orderedCol.size(); i++) {
            int rowIdx = rowMap.get(orderedCol.get(i));
            int colIdx = i;
            ans[rowIdx][colIdx] = orderedCol.get(i);
        }
        return ans;
    }
}