package leetcode.daily_challenge.may_to_july_24.find_valid_matrix_from_rowsum_colsum;

public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        long[][] ans = new long[rowSum.length][colSum.length];
        long total = 0;
        for (int i = 0; i < rowSum.length; i++) {
            ans[i][0] = rowSum[i];
            total += rowSum[i];
        }
        System.out.println(total);
        for (int j = 0; j < colSum.length - 1; j++) {
            long compensate = total - colSum[j];
            total -= colSum[j];
            for (int i = 0; i < rowSum.length; i++) {
                if (compensate <= 0) {
                    break;
                }
                if (compensate > ans[i][j]) {
                    ans[i][j + 1] = ans[i][j];
                    ans[i][j] = 0;
                    compensate -= ans[i][j + 1];
                } else {
                    ans[i][j + 1] = compensate;
                    ans[i][j] -= compensate;
                    compensate = 0;
                }
            }
        }
        int[][] result = new int[ans.length][ans[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = (int) ans[i][j];
            }
        }
        return result;
    }
}