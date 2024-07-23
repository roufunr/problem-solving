package leetcode.two_thousand_24.dp.max_score_mul;

import java.util.HashMap;
import java.util.Map;

public class SolutionII { // reduced the state variable to 1
    private int[] nums;
    private int[] multipliers;
    private Map<String, Integer> cache = new HashMap<>();

    private int fn(int i, int k) {
        if (k == multipliers.length) {
            return 0;
        }
        String key = i + "_" + k;
        
        if (cache.containsKey(key)) {
            System.out.println(key);
            // System.err.println(key + " " + cache.get(key));
            return cache.get(key);
        }
        cache.put(key, Math.max(
                fn(i + 1, k + 1) + nums[i] * multipliers[k],
                fn(i, k + 1) + nums[nums.length - k + i - 1] * multipliers[k]));
        return cache.get(key);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        int ans = fn(0, 0);
        return ans;
    }
}
