package leetcode.daily_challenge.november_24.maximum_matrix_sum_24;

class Solution {

    public long maxMatrixSum(int[][] matrix) {
        long total = 0;
        int minCount = 0;
        int negMin = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                negMin = Math.min(negMin, Math.abs(matrix[i][j]));
                if(matrix[i][j] <= 0) {
                    minCount++;
                }
                total += Math.abs(matrix[i][j]);
            }
        }
        if(minCount % 2 == 0) {
            return total;
        } else {
            return total - (2 * negMin);
        }
    }

}