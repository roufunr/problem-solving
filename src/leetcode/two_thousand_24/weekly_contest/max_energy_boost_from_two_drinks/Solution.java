package leetcode.two_thousand_24.weekly_contest.max_energy_boost_from_two_drinks;

public class Solution {
    private int[][] matrix;
    private long[][] dp;

    private long solve(int idx, int drink) {
        if (idx >= matrix.length) {
            return 0;
        }
        if (dp[idx][drink] != -1) {
            return dp[idx][drink];
        }
        long option1 = matrix[idx][drink] + solve(idx + 1, drink);
        long option2 = matrix[idx][drink] + solve(idx + 2, (drink + 1) % 2);
        dp[idx][drink] = Math.max(option1, option2);
        return dp[idx][drink];
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        matrix = new int[energyDrinkA.length][2];
        dp = new long[energyDrinkA.length][2];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = energyDrinkA[i];
            matrix[i][1] = energyDrinkB[i];
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        return Math.max(solve(0, 0), solve(0, 1));
    }
}
