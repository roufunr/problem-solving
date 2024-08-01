package leetcode.daily_challenge.may_to_july_24.lucky_number_in_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] minValues = new int[matrix.length];
        int[] maxValues = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            minValues[i] = min;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            maxValues[j] = max;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == minValues[i] && matrix[i][j] == maxValues[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}