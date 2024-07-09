package leetcode.two_thousand_24.dp.min_cost_climbing_stairs;

public class SolutionII { // iterative solution // faster
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
