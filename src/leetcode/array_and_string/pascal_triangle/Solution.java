package leetcode.array_and_string.pascal_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
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

        for(int i = 0; i < numRows; i++) {
            int x = i;
            int y = 0;
            List<Integer> eachLine = new ArrayList<>();
            do {
                eachLine.add(mat[x][y]);
                x--;
                y++;
            } while(x >= 0 && y < numRows);
            pascalTriangle.add(eachLine);
        }
        return pascalTriangle;
    }
}
