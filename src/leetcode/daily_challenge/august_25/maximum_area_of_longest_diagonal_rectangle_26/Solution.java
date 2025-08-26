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
}