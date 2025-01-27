package leetcode.daily_challenge.january_25.count_servers_that_communicate_23;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int count(int[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        visited[x][y] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int j = 0; j < grid[0].length; j++) {
                if (top[1] != j && grid[top[0]][j] == 1 && !visited[top[0]][j]) {
                    queue.offer(new int[] { top[0], j });
                    visited[top[0]][j] = true;
                    cnt++;
                }
            }
            for (int i = 0; i < grid.length; i++) {
                if (top[0] != i && grid[i][top[1]] == 1 && !visited[i][top[1]]) {
                    queue.offer(new int[] { i, top[1] });
                    visited[i][top[1]] = true;
                    cnt++;
                }
            }
        }
        return cnt > 0 ? cnt + 1 : cnt;
    }

    public int countServers(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans += count(grid, visited, i, j);
                }
            }
        }
        return ans;
    }
}