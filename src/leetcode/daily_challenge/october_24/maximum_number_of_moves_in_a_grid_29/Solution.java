package leetcode.daily_challenge.october_24.maximum_number_of_moves_in_a_grid_29;

public class Solution {
    private int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};
    private int ROWS;
    private int COLS;
    private int[][] matrix;
    private Integer[][] cache;
    private int dfs(int x, int y, int moveCount, int currentMax) {
        if(x >= ROWS || x < 0 || y >= COLS) {
            return currentMax;
        }
        if(cache[x][y] != null) {
            return cache[x][y];
        }
        currentMax = Math.max(currentMax, moveCount);
        for(int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX >= ROWS || newX < 0 || newY >= COLS || matrix[newX][newY] <= matrix[x][y]) {
                continue;
            } else {
                currentMax = Math.max(dfs(newX, newY, moveCount + 1, currentMax), currentMax);
            }
        }
        cache[x][y] = currentMax;
        return currentMax;
    }
    public int maxMoves(int[][] grid) {
        this.matrix = grid;
        this.ROWS = grid.length;
        this.COLS = grid[0].length;
        this.cache = new Integer[ROWS][COLS];
        int max = 0;
        for(int i = 0; i < ROWS; i++) {
            max = Math.max(dfs(i, 0, 0, 0), max);
        }
        return max;
    }
}