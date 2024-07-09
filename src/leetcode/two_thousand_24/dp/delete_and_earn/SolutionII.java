package leetcode.two_thousand_24.dp.delete_and_earn;

import java.util.*;

public class SolutionII { // dp solution top down
    Map<Integer, Integer> values = new HashMap<>();
    Map<Integer, Integer> dp = new HashMap<>();

    private int fn(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return values.getOrDefault(num, 0);
        } else if (dp.containsKey(num)) {
            return dp.get(num);
        }

        int gain = values.getOrDefault(num, 0);
        dp.put(num, Math.max(gain + fn(num - 2), fn(num - 1)));
        return dp.get(num);
    }

    public int deleteAndEarn(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int n : nums) {
            values.put(n, values.getOrDefault(n, 0) + n);
            maxVal = Math.max(maxVal, n);
        }
        return fn(maxVal);
    }
}
