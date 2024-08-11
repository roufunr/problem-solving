package leetcode.daily_challenge.august_24.minimum_number_of_days_to_disconnect_island;

public class Solution {
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void dfs(int x, int y, int[][] grid, boolean[][] visited) {
        if(visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for(int[] d : dir) {
            int i = x + d[0];
            int j = y + d[1];
            if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                dfs(i, j, grid, visited);
            }
        }
    }
    private boolean isConnected(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && visited[i][j] == false) {
                    if(count > 0) {
                        return false;
                    } else {
                        count++;
                        dfs(i, j, grid, visited);
                    }
                }
            }
        }
        return count == 0 ? false : true;
    }
    public int minDays(int[][] grid) {
        if(!isConnected(grid)) {
            return 0;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(!isConnected(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}