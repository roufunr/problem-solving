package lc_others.count_number_of_rectangles_containing_each_point;

public class Solution {
    // time limit exceeds solution
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] count = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < rectangles.length; j++) {
                if (points[i][0] <= rectangles[j][0] && points[i][1] <= rectangles[j][1]) {
                    count[i]++;
                }
            }
        }
        return count;
    }
}