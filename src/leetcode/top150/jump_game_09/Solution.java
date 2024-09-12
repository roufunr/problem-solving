package leetcode.top150.jump_game_09;
import java.util.*;
public class Solution {
    private void dfs(boolean[] visited, List<List<Integer>> adj, int node) {
        if(node < visited.length) {
            if(visited[node]) {
                return;
            }
            visited[node] = true;
            for(int nei : adj.get(node)) {
                dfs(visited, adj, nei);
            }
        }
    }
    public boolean canJump(int[] nums) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i]; j++) {
                adj.get(i).add(i + j + 1);
            }
        }
        boolean[] visited = new boolean[nums.length];
        dfs(visited, adj, 0);
        return visited[nums.length - 1];
    }
}
