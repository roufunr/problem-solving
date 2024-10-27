package leetcode.daily_challenge.october_24.count_square_submatrices_with_all_ones_27;

class Solution {
    Integer[][] cache;
    int[][] matrix;
    private int dp(int i, int j) {
        if(i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0) {
            return 0;
        }
        if(cache[i][j] != null) {
            return cache[i][j];
        }
        int bottom = dp(i + 1, j);
        int right = dp(i, j + 1);
        int bottomDiag = dp(i + 1, j + 1);
        cache[i][j] = Math.min(Math.min(bottom, right), bottomDiag) + 1;
        return cache[i][j];
    }
    public int countSquares(int[][] matrix) {
        cache =  new Integer[matrix.length][matrix[0].length];
        this.matrix = matrix;
        int result = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                result += cache[i][j] = dp(i, j);
            }
        }
        return result;
    }
}