package lc_others.longest_increasing_path_in_matrix;

public class Solution {
    private int[][] memo;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private int dfs(int i, int j, int[][] matrix) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int maxPath = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                int pathLen = 1 + dfs(x, y, matrix);
                maxPath = Math.max(maxPath, pathLen);
            }
        }
        memo[i][j] = maxPath;
        return memo[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        int ans = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, dfs(i, j, matrix));
            }
        }
        return ans;
    }
}