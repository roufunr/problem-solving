package leetcode.two_thousand_24.dp.delete_and_earn;

import java.util.HashMap;
import java.util.Map;

public class SolutionIII {

    public int deleteAndEarn(int[] nums) { // iterative approach better for array (NOT MAP)
        Map<Integer, Integer> values = new HashMap<>();

        int maxVal = Integer.MIN_VALUE;
        for (int n : nums) {
            values.put(n, values.getOrDefault(n, 0) + n);
            maxVal = Math.max(maxVal, n);
        }
        int[] dp = new int[maxVal + 1];
        dp[0] = 0;
        dp[1] = values.getOrDefault(1, 0);
        for (int i = 2; i <= maxVal; i++) {
            int gain = values.getOrDefault(i, 0);
            dp[i] = Math.max(gain + dp[i - 2], dp[i - 1]);
        }
        return dp[maxVal];
    }

}
