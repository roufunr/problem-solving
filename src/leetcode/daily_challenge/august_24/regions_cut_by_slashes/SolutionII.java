package leetcode.daily_challenge.august_24.regions_cut_by_slashes;

public class SolutionII {
    // this is not viable because we can't traverse the matrix diagonally
    // grid = ["//","/ "]

    // matrix looks like this
    // 0 1 0 1
    // 1 0 1 0
    // 0 1 0 0
    // 1 0 0 0

    // if you pick 2 instead of 3
    // then this code will return 5
    // but actual answer is 3

    private int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private void dfs(int x, int y, boolean[][] matrix) {
        if (matrix[x][y] == true) {
            return;
        }
        matrix[x][y] = true;
        for (int[] d : dir) {
            int i = x + d[0];
            int j = y + d[1];
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
                dfs(i, j, matrix);
            }
        }
    }

    public int regionsBySlashes(String[] grid) {
        boolean[][] matrix = new boolean[grid.length * 2][grid.length * 2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    int x = i * 2;
                    int y = j * 2;
                    for (int k = 0; k < 2; k++) {
                        matrix[x + k][y + 2 - k - 1] = true;
                    }
                } else if (c == '\\') {
                    int x = i * 2;
                    int y = j * 2;
                    for (int k = 0; k < 2; k++) {
                        matrix[x + k][y + k] = true;
                    }
                }
            }
        }

        int regionCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == false) {
                    regionCount++;
                    dfs(i, j, matrix);
                }
            }
        }
        return regionCount;
    }
}
