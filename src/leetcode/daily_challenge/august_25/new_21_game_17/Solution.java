package leetcode.daily_challenge.august_25.new_21_game_17;

public class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) return 1.0;
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double window = 1.0; 
        double ans = 0.0;
        for (int i = 1; i <= n; i++) {
            dp[i] = window / maxPts;
            if (i < k) {
                window += dp[i];
            } else {
                ans += dp[i];
            }
            int j = i - maxPts;
            if (j >= 0 && j < k) {
                window -= dp[j];
            }
        }
        return ans;
    }
}
