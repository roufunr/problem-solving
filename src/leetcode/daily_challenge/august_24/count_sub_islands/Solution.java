package leetcode.daily_challenge.august_24.count_sub_islands;

import java.util.*;

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    private int[][] grid1;
    private int[][] grid2;
    private int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private boolean isSubIsland(boolean[][] visited, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        boolean isIsland = true;
        if (grid1[x][y] == 0) {
            isIsland = false;
        }
        queue.offer(new Pair(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            if (grid1[top.x][top.y] == 0) {
                isIsland = false;
            }
            for (int[] d : dir) {
                int new_x = top.x + d[0];
                int new_y = top.y + d[1];
                if (new_x >= 0
                        && new_x < grid1.length
                        && new_y >= 0
                        && new_y < grid1[0].length
                        && grid2[new_x][new_y] == 1
                        && visited[new_x][new_y] == false) {
                    visited[new_x][new_y] = true;
                    queue.offer(new Pair(new_x, new_y));
                }
            }
        }
        return isIsland;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        boolean[][] visited = new boolean[grid1.length][grid1[0].length];
        int subIslanCount = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1 && !visited[i][j] && isSubIsland(visited, i, j)) {
                    subIslanCount++;
                }
            }
        }
        return subIslanCount;
    }
}