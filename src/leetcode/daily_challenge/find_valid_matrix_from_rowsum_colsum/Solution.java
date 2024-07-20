package leetcode.daily_challenge.find_valid_matrix_from_rowsum_colsum;

public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        int total = 0;
        for (int i = 0; i < rowSum.length; i++) {
            ans[i][0] = rowSum[i];
            total += rowSum[i];
        }
        for (int j = 0; j < colSum.length - 1; j++) {
            int compensate = total - colSum[j];
            total = 0;
            for (int i = 0; i < rowSum.length; i++) {
                if (compensate <= 0) {
                    break;
                }
                if (compensate > ans[i][j]) {
                    ans[i][j] = 0;
                    ans[i][j + 1] = ans[i][j];
                    compensate -= ans[i][j];
                } else {
                    ans[i][j + 1] = ans[i][j] - compensate;
                    ans[i][j] = compensate;
                    compensate = 0;
                }
                total += ans[i][j + 1];
            }
        }
        return ans;
    }
}