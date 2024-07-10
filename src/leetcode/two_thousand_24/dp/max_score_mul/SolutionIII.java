package leetcode.two_thousand_24.dp.max_score_mul;



public class SolutionIII {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[nums.length + 1][multipliers.length + 1];
        for(int i = 2; i < dp.length; i++) {
            for(int j = dp[0].length - 2; j >= 0; j--) {
                dp[i][j] = Math.max(
                    dp[i - 1][j + 1] + nums[i - 1] * multipliers[j + 1],
                    dp[i - 2][j + 1] + nums[nums.length - j + i - 1] * multipliers[j + 1]
                );
            }
        }
        return dp[nums.length][0];
    }
}
