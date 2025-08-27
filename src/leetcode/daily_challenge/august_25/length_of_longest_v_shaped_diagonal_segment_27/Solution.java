package leetcode.daily_challenge.august_25.length_of_longest_v_shaped_diagonal_segment_27;

public class Solution {
    private int[][][][] cache;
    private int[][] dir = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    private int m;
    private int n;
    private int[][] grid;
    
    private int maxLen(int x, int y, int d, int turn, int target) {
        if(x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        } else if(grid[x][y] != target) {
            return 0;
        } else if(cache[x][y][d][turn] != -1) {
            return cache[x][y][d][turn];
        } else {
            int len = maxLen(x + dir[d][0], y + dir[d][1], d, turn, 2 - target);
            if(turn == 0) {
                int nd = (d + 1) % 4;
                len = Math.max(len, maxLen(x + dir[nd][0], y + dir[nd][1], nd, turn + 1, 2 - target));
            }
            cache[x][y][d][turn] = 1 + len;
            return 1 + len;
        }
    }
    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int d = 4;
        cache = new int[m][n][d][2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < d; k++) {
                    for(int l = 0; l < 2; l++) {
                        cache[i][j][k][l] = -1;
                    }
                }
            }
        }
        int mLen = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < d; k++) {
                        int len = 1 + maxLen(i + dir[k][0], j + dir[k][1], k, 0, 2);
                        mLen = Math.max(mLen, len);
                    }
                }
            }
        }
        return mLen;
    }
}