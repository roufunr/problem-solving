package leetcode.daily_challenge.august_24.maximum_number_of_points_with_cost;

public class Solution {
    public long maxPoints(int[][] points) {
        long[] dp = new long[points[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = points[0][i];
        }
        for (int i = 1; i < points.length; i++) {
            long[] left = new long[dp.length];
            long[] right = new long[dp.length];
            for(int k = 0; k < dp.length; k++) {
                if(k == 0) {
                    left[k] = dp[k];
                } else {
                    left[k] = Math.max(dp[k], left[k - 1] - 1);
                }
            }
            for(int k = dp.length - 1; k >= 0; k--) {
                if(k == dp.length - 1) {
                    right[k] = dp[k];
                } else {
                    right[k] = Math.max(dp[k], right[k + 1] - 1);
                }
            }
            long[] newDp = new long[dp.length];
            for (int j = 0; j < points[0].length; j++) {
                newDp[j] = Math.max(left[j], right[j]) + points[i][j];
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