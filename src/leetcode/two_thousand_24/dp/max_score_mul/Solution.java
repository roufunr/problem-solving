package leetcode.two_thousand_24.dp.max_score_mul;

import java.util.*;

public class Solution {
    private int[] nums;
    private int[] multipliers;
    private Map<String, Integer> cache = new HashMap<>();

    private int fn(int i, int j, int k) {
        if (k == multipliers.length - 1) {
            return Math.max(nums[i] * multipliers[k], nums[j] * multipliers[k]);
        }
        String key = i + "_" + j + "_" + k;
        if (cache.containsKey(key)) {
            System.err.println(key + "   " + cache.get(key));
            return cache.get(key);
        }
        cache.put(key, Math.max(fn(i + 1, j, k + 1) + nums[i] * multipliers[k],
                fn(i, j - 1, k + 1) + nums[j] * multipliers[k]));
        return cache.get(key);
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        int ans = fn(0, nums.length - 1, 0);
        return ans;
    }
}