package leetcode.daily_challenge.lucky_number_in_matrix;

import java.util.ArrayList;
import java.util.List;

public class SolutionII {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rowsMaxOfMins = Integer.MIN_VALUE;
        int colsMinOfMaxs = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            rowsMaxOfMins = Math.max(min, rowsMaxOfMins);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            colsMinOfMaxs = Math.min(max, colsMinOfMaxs);
        }
        List<Integer> ans = new ArrayList<>();
        if(rowsMaxOfMins == colsMinOfMaxs) {
            ans.add(colsMinOfMaxs);
        }
        return ans;
    }
}
