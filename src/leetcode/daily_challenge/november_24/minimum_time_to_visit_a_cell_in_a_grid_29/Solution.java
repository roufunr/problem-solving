package leetcode.daily_challenge.november_24.minimum_time_to_visit_a_cell_in_a_grid_29;


import java.util.*;
class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        queue.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!queue.isEmpty()) {
            int[] top = queue.poll();
            int currentTime = top[0];
            int x = top[1];
            int y = top[2];
            if(x == n - 1 && y == m - 1) {
                return currentTime;
            }
            for(int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m && visited[newX][newY] == false) {
                    int newTime = currentTime;
                    if(currentTime >= grid[newX][newY]) {
                        newTime = currentTime + 1;
                    } else {
                        int diff = grid[newX][newY] - currentTime;
                        if(diff % 2 == 1) {
                            newTime = grid[newX][newY];
                        } else {
                            newTime = grid[newX][newY] + 1;
                        }
                    }
                    queue.offer(new int[]{newTime, newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }
}