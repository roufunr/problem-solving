package lc_others.paths_in_matrix_whose_sum_is_divisible_by_k;

// Solved the problem but got TLE
public class Solution {
    private int[][] dir = { { 0, 1 }, { 1, 0 } };
    private int[][] grid;
    private int k;
    private int ans;
    private int BIG_CONST = 1000 * 1000 * 1000 + 7;

    private void dfs(int x, int y, int sum) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            if ((sum + grid[x][y]) % k == 0) {
                ans = (ans + 1) % (BIG_CONST);
            }
            return;
        }
        for (int[] d : dir) {
            int xi = x + d[0];
            int yi = y + d[1];
            if (xi < grid.length && yi < grid[0].length) {
                dfs(xi, yi, sum + grid[x][y]);
            }
        }
    }

    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        this.ans = 0;
        dfs(0, 0, 0);
        return ans;
    }
}