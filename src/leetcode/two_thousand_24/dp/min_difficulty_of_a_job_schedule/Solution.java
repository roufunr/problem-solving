package leetcode.two_thousand_24.dp.min_difficulty_of_a_job_schedule;

public class Solution {
    private int[] jobDifficulty;
    private Integer[][] dp;

    private int helper(int idx, int remainingDays) {
        if (idx == jobDifficulty.length) {
            return 0;
        }
        if (dp[idx][remainingDays] != null) {
            return dp[idx][remainingDays];
        }
        int totalDifficulty = Integer.MAX_VALUE;
        int maxDifficulty = Integer.MIN_VALUE;
        for (int i = idx; i < jobDifficulty.length - remainingDays + 1; i++) {
            maxDifficulty = Math.max(jobDifficulty[i], maxDifficulty);
            if (remainingDays > 1) {
                totalDifficulty = Math.min(totalDifficulty, maxDifficulty + helper(i + 1, remainingDays - 1));
            } else {
                totalDifficulty = maxDifficulty;
            }
        }
        dp[idx][remainingDays] = totalDifficulty;
        return dp[idx][remainingDays];
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        dp = new Integer[jobDifficulty.length][d + 1];
        this.jobDifficulty = jobDifficulty;
        return helper(0, d);
    }
}