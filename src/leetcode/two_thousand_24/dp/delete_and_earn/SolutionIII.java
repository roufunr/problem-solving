package leetcode.two_thousand_24.dp.delete_and_earn;

import java.util.HashMap;
import java.util.Map;

public class SolutionIII {

    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[nums.length + 1][multipliers.length];
        for(int i = 1; i < dp.length; i++) {
            dp[i][multipliers.length - 1] = nums[i - 1] * multipliers[multipliers.length - 1];
        }
        for(int i = dp.length - 1; i > 0; i--) {
            for(int j = multipliers.length - 2; j >= 0; j--) {
                dp[i][j] = Math.max(dp[i - 1][j + 1] + nums[i - 2] * multipliers[j + 1], dp[i][j + 1] + nums[i + j - nums.length - 1] * multipliers[j + 1]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int[] dprow : dp) {
            for(int n : dprow) {
                max = Math.max(n, max);
            }
        }
        return max;
    }
}
