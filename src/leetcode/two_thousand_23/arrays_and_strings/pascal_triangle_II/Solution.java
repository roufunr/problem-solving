package leetcode.two_thousand_23.arrays_and_strings.pascal_triangle_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int[][] matrix = new int[rowIndex + 1][rowIndex + 1];
        for(int i = 0; i <= rowIndex; i++) {
            matrix[i][0] = 1;
            matrix[0][i] = 1;
        }
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = 1; j <= (rowIndex - i); j++) {
                matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
            }
        }
        for(int i = 0;i <= rowIndex; i++) {
            ans.add(matrix[rowIndex-i][i]);
        }
        return ans;
    }
}
