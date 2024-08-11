package lc_others.count_number_of_rectangles_containing_each_point;

import java.util.Arrays;

public class SolutionII {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[][] combined = new int[rectangles.length + points.length][];
        for(int i = 0; i < rectangles.length; i++) {
            combined[i] = rectangles[i];
        }
        for(int i = 0; i < points.length; i++) {
            combined[rectangles.length + i] = new int[]{points[i][0], points[i][1], i};
        }
        Arrays.sort(combined, (x, y)-> {
            if(x[0] != y[0]) {
                return y[0] - x[0]; // descending order
            }
            return x.length - y.length; // rect first then points
        });
        int[] counts = new int[101];
        int[] ans = new int[points.length];
        for(int i = 0; i < combined.length; i++) {
            if(combined[i].length == 2) {
                for(int k = 0; k <= combined[i][1]; k++) {
                    counts[k]++;
                }
            } else {
                ans[combined[i][2]] = counts[combined[i][1]];
            }
        }
        return ans;
    }
}