package leetcode.daily_challenge.august_24.spiral_matrix_III;

public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] ans = new int[rows * cols][2];
        int k = 0;
        int i = rStart;
        int j = cStart;
        int l = 1;
        int d = 0;
        while (k < ans.length) {
            for (int o = 0; o < 2; o++) {
                for (int a = 0; a < l; a++) {
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        ans[k][0] = i;
                        ans[k][1] = j;
                        k++;
                    }
                    i += dir[d][0];
                    j += dir[d][1];
                }
                d = (d + 1) % 4;
            }
            l++;
        }
        return ans;
    }
}