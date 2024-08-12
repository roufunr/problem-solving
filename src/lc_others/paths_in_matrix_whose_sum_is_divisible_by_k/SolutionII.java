package lc_others.paths_in_matrix_whose_sum_is_divisible_by_k;

public class SolutionII { // top down approach 
    private Integer[][][] memo;
    private int[][] grid;
    private int k;
    private int MOD_CONST = (1000 * 1000 * 1000) + 7;

    private int calculatePath(int i, int j, int curSum) {
        if (i == grid.length || j == grid[0].length) {
            return 0;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return (curSum + grid[i][j]) % k == 0 ? 1 : 0;
        }
        if (memo[i][j][curSum] != null) {
            return memo[i][j][curSum];
        }
        int newSum = (curSum + grid[i][j]) % k;
        memo[i][j][curSum] = (calculatePath(i + 1, j, newSum) + calculatePath(i, j + 1, newSum)) % MOD_CONST;
        return memo[i][j][curSum];
    }

    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        this.memo = new Integer[grid.length][grid[0].length][k];
        return calculatePath(0, 0, 0);
    }
}