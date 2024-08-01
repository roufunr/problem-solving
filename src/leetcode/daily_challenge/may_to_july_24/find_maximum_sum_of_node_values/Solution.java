package leetcode.daily_challenge.may_to_july_24.find_maximum_sum_of_node_values;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long maxSum = 0;
        for (int n : nums) {
            maxSum += n;
        }
        int positiveImpactCount = 0;
        long totalDiff = 0;
        long minNegDiff = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long diff = (nums[i] ^ k) - nums[i];
            if (diff > 0) {
                totalDiff += diff;
                positiveImpactCount++;
            }
            minNegDiff = Math.min(Math.abs(diff), minNegDiff);
        }

        if (positiveImpactCount % 2 == 1) {
            totalDiff -= minNegDiff;
        }
        return maxSum + totalDiff;
    }
}
