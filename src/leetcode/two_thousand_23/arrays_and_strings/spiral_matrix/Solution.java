package leetcode.two_thousand_23.arrays_and_strings.spiral_matrix;

import java.util.*;
public class Solution {
    // https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
    public List<Integer> spiralOrder(int[][] matrix) {
        int direction = 1;
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(true) {
            ans.add(matrix[i][j]);
            flag[i][j] = true;

            if(direction == 1) {
                j++;
            } else if(direction == 2) {
                i++;
            } else if (direction == 3) {
                j--;
            } else if (direction == 4){
                i--;
            }

            if(direction == 1) {
                if(j >= matrix[0].length || flag[i][j] == true) {
                    j--;
                    direction = 2;
                    i++;
                }
            } else if (direction == 2) {
                if(i >= matrix.length || flag[i][j] == true) {
                    i--;
                    direction = 3;
                    j--;
                }
            } else if (direction == 3) {
                if(j < 0 || flag[i][j] == true) {
                    j++;
                    direction = 4;
                    i--;
                }
            } else if(direction ==4) {
                if(i < 0 || flag[i][j] == true) {
                    i++;
                    direction = 1;
                    j++;
                }
            }

            if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length ) {
                break;
            }

            if(flag[i][j]) {
                break;
            }
        }
        return ans;
    }
}
