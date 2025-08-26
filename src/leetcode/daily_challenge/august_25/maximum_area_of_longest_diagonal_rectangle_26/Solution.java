package leetcode.daily_challenge.august_25.maximum_area_of_longest_diagonal_rectangle_26;
import java.util.Arrays;
public class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        Arrays.sort(dimensions, (a, b) -> {
            int x = (a[0] * a[0] + a[1] * a[1]);
            int y = (b[0] * b[0] + b[1] * b[1]);
            if(x == y) {
                return Integer.compare(b[0] * b[1], a[0] * a[1]);
            } else {
                return Integer.compare(y, x);
            }
        });
        return dimensions[0][0] * dimensions[0][1];
    }

    public int areaOfMaxDiagonalV2(int[][] dimensions) {
        int maxArea = Integer.MIN_VALUE;
        int maxDiagonal = Integer.MIN_VALUE;
        for(int[] dim : dimensions) {
            int diagonal = dim[0] * dim[0] + dim[1] * dim[1];
            int area = dim[0] * dim[1];
            if(maxDiagonal <  diagonal || (maxDiagonal ==  diagonal && area > maxArea)) {
                maxArea = area;
                maxDiagonal = diagonal;
            }
        }
        return maxArea;
    }
}