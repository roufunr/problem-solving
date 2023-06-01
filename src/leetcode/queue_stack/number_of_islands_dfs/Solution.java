package leetcode.queue_stack.number_of_islands_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[][] directions = {
            {0, 1}, // up
            {0, -1}, //down
            {1, 0}, //left
            {-1, 0} //right
    };

    public void calculateIsland(char[][] grid, int[] node) {
        for(int k = 0; k < directions.length; k++) {
            int x = node[0] + directions[k][0];
            int y = node[1] + directions[k][1];
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
                continue;
            }
            grid[x][y] = '0';
            calculateIsland(grid, new int[]{x,y});
        }
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int islandCount = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    islandCount++;
                    calculateIsland(grid, new int[]{i, j});
                }
            }
        }
        return islandCount;
    }
}
