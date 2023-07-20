package leetcode.two_thousand_23.arrays_and_strings.pascal_triangle;

import java.util.ArrayList;
import java.util.List;
public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
    public List<List<Integer>> generate(int numRows) {
        int[][] mat = new int[numRows][numRows];
        for(int i = 0; i < numRows; i++) {
            mat[i][0] = 1;
            mat[0][i] = 1;
        }
        for(int i = 1; i < numRows; i++) {
            for(int j = 1; j < numRows - i; j++) {
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        }
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for(int j = i; j >= 0; j--) {
                rows.add(mat[j][i-j]);

            }
            pascalTriangle.add(rows);
        }
        return pascalTriangle;
    }
}
