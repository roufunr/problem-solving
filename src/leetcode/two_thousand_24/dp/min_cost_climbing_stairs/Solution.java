package leetcode.two_thousand_24.dp.min_cost_climbing_stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution { // recursive solution
    public Map<Integer, Integer> dp;

    private int fn(int[] cost, int currentStair) {
        if (currentStair == 0 || currentStair == 1) {
            return 0;
        } else if (!dp.containsKey(currentStair)) {
            dp.put(currentStair, Math.min(fn(cost, currentStair - 1) + cost[currentStair - 1],
                    fn(cost, currentStair - 2) + cost[currentStair - 2]));
        }
        return dp.get(currentStair);

    }

    public int minCostClimbingStairs(int[] cost) {
        dp = new HashMap<>();
        return fn(cost, cost.length); // fn means required cost to reach at n
    }
}