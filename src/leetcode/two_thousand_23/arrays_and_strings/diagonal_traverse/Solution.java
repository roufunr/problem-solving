package leetcode.two_thousand_23.arrays_and_strings.diagonal_traverse;

public class Solution {
    // https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
    public int[] findDiagonalOrder(int[][] mat) {
        boolean upward = true;
        int i = 0;
        int j = 0;
        int rows = mat.length;
        int columns = mat[0].length;
        int[] ans = new int[rows * columns];
        int k = 0;
        while(true) {
            ans[k++] = mat[i][j];
            if(i == rows - 1 && j == columns - 1) {
                break;
            }
            if(upward) {
                i--;
                j++;
            } else {
                i++;
                j--;
            }
            boolean case1 = i < 0;
            boolean case2 = j >= columns;
            boolean case3 = j < 0;
            boolean case4 = i >= rows;

            if(case1 || case2 || case3 || case4) {
                if(upward) {
                    i++;
                    j--;

                    if(case1 && j + 1 < columns) {
                        j++;
                    } else if (case2 && i + 1 < rows) {
                        i++;
                    }
                } else {
                    i--;
                    j++;

                    if(case3 && i + 1 < rows) {
                        i++;
                    } else if (case4 && j + 1 < columns) {
                        j++;
                    }
                }
                upward = upward == false ? true : false;
            }
        }
        return ans;
    }
}
