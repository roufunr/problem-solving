package leetcode.daily_challenge.january_25.first_painted_column_or_row_20;

import java.util.*;

public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer[]> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j], new Integer[]{i, j});
            }
        }
        int[] colCount = new int[mat[0].length];
        Arrays.fill(colCount, mat.length);
        int[] rowCount = new int[mat.length];
        Arrays.fill(rowCount, mat[0].length);
        for(int i = 0; i < arr.length; i++) {
            Integer[] pos = map.get(arr[i]);
            colCount[pos[1]]--;
            rowCount[pos[0]]--;
            if(colCount[pos[1]] == 0 || rowCount[pos[0]] == 0) {
                return i;
            }
        }
        return -1;
    }
}