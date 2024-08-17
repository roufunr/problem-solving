package leetcode.daily_challenge.august_24.maximum_number_of_points_with_cost;

public class Solution {
    public long maxPoints(int[][] points) {
        long[] dp = new long[points[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = points[0][i];
        }
        for (int i = 1; i < points.length; i++) {
            long[] newDp = new long[dp.length];
            for (int j = 0; j < points[0].length; j++) {
                long max = points[i][j] + dp[0] - Math.abs(j - 0);
                for (int k = 1; k < dp.length; k++) {
                    max = Math.max(points[i][j] + dp[k] - Math.abs(j - k), max);
                }
                newDp[j] = max;
            }
            dp = newDp;
        }

        long max = Long.MIN_VALUE;
        for (long v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }
}