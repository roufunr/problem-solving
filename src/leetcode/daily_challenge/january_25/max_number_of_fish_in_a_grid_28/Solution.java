package leetcode.daily_challenge.january_25.max_number_of_fish_in_a_grid_28;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int bfs(int x, int y, boolean[][] visited, int[][] grid) {
        int totalFish = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        totalFish += grid[x][y];
        while(!queue.isEmpty()) {
            int[] top = queue.poll();
            for(int[] d : dir) {
                int[] newPos = new int[]{top[0] + d[0], top[1] + d[1]};
                if(newPos[0] < 0 || newPos[0] >= grid.length || newPos[1] < 0 || newPos[1] >= grid[0].length || visited[newPos[0]][newPos[1]]) {
                    continue;
                }
                if(grid[newPos[0]][newPos[1]] != 0) {
                    totalFish += grid[newPos[0]][newPos[1]];
                    queue.offer(newPos);
                    visited[newPos[0]][newPos[1]] = true;
                }
            }
        }
        return totalFish;
    }
    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(visited[i][j] == false && grid[i][j] != 0) {
                    maxFish = Math.max(maxFish, bfs(i, j, visited, grid));
                }
            }
        }
        return maxFish;
    }
}