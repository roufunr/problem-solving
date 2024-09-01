package leetcode.daily_challenge.september_24.convert_1d_array_into_2d_array_01;

public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if ((m * n) != original.length) {
            return new int[][] {};
        }
        int[][] twoDArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                twoDArr[i][j] = original[i * n + j];
            }
        }
        return twoDArr;
    }
}