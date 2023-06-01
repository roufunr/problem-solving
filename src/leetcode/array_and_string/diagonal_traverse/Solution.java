package leetcode.array_and_string.diagonal_traverse;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void append(int[] arr, int currentLen, List<Integer> list, boolean upward) {
        int len = list.size();
        if(upward) {
            for(int i = 0; i < len; i++) {
                arr[currentLen] = list.get(i);
                currentLen++;
            }
        } else {
            for(int i = len - 1; i >= 0; i--) {
                arr[currentLen] = list.get(i);
                currentLen++;
            }
        }
    }

    private List<Integer> getDiagonalList(int[][] mat, int i, int j) {
        List<Integer> dList = new ArrayList<>();
        int column = mat[0].length;
        int x = i, y = j;
        do {
            dList.add(mat[x][y]);
            x--;
            y++;

        } while(x >= 0 && y < column);
        return  dList;
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[] arr = new int[row * column];
        boolean upward = true;
        int k = 0;
        for(int i = 0; i < row; i++) {
            if(i == row-1) {
                for(int j = 0; j < column; j++) {
                    List<Integer> dArr = getDiagonalList(mat,i, j);
                    append(arr, k, dArr, upward);
                    k += dArr.size();
                    upward = upward ? false : true;
                }
            } else {
                List<Integer> dArr = getDiagonalList(mat,i, 0);
                append(arr, k, dArr, upward);
                k += dArr.size();
                upward = upward ? false : true;

            }
        }
        return arr;
    }
}
