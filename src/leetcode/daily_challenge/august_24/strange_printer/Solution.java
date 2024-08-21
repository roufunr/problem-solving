package leetcode.daily_challenge.august_24.strange_printer;

public class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        char[] sChar = s.toCharArray();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = len;

                for (int k = i; k < j; k++) {
                    int total = dp[i][k] + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], total);
                }

                if (sChar[i] == sChar[j]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
