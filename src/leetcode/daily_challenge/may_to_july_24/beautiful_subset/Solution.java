package leetcode.daily_challenge.may_to_july_24.beautiful_subset;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int makeSubset(int[] nums, int k, int idx, Map<Integer, Integer> countMap) {
        if (idx == nums.length) {
            return 1;
        }
        int takingThisIndex = 0;
        if (!countMap.containsKey(nums[idx] - k) && !countMap.containsKey(nums[idx] + k)) {
            countMap.put(nums[idx], countMap.getOrDefault(nums[idx], 0) + 1);
            takingThisIndex = makeSubset(nums, k, idx + 1, countMap);
            countMap.put(nums[idx], countMap.get(nums[idx]) - 1);
            if (countMap.get(nums[idx]) == 0) {
                countMap.remove(nums[idx]);
            }
        }
        int notTakingThisIndex = makeSubset(nums, k, idx + 1, countMap);
        return takingThisIndex + notTakingThisIndex;
    }

    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int subsetCount = makeSubset(nums, k, 0, countMap);
        return subsetCount - 1;
    }
}
