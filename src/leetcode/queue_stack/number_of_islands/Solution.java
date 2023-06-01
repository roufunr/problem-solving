package leetcode.queue_stack.number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[][] directions = {
            {0, 1}, // up
            {0, -1}, //down
            {1, 0}, //left
            {-1, 0} //right
    };

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int islandCount = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {

                    islandCount++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()) {
                        int[] node = queue.remove();
                        grid[node[0]][node[1]] = '0';
                        for(int k = 0; k < directions.length; k++) {

                            int x = node[0] + directions[k][0];
                            int y = node[1] + directions[k][1];
                            if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') {
                                continue;
                            }

                            queue.add(new int[]{x, y});
                            grid[x][y] = '0';
                            //i = x > i ? x : i;
                            //j = y > j ? y : j;
                        }
                    }
                }
            }
        }
        return islandCount;
    }
}
