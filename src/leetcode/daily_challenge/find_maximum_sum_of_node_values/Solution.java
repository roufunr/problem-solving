package leetcode.daily_challenge.find_maximum_sum_of_node_values;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        List<Integer> positiveImpactIdx = new ArrayList<>();
        List<Integer> negativeImpactIdx = new ArrayList<>();
        long maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] ^ k) >= nums[i]) {
                positiveImpactIdx.add(i);
                maxSum += (nums[i] ^ k);
            } else {
                maxSum += nums[i];
                negativeImpactIdx.add(i);
            }
        }
        if (positiveImpactIdx.size() % 2 == 1) {
            int minIdx = -1;
            int minImpact = Integer.MAX_VALUE;
            for (int i = 0; i < positiveImpactIdx.size(); i++) {
                if ((nums[positiveImpactIdx.get(i)] ^ k) < minImpact) {
                    minIdx = positiveImpactIdx.get(i);
                    minImpact = (nums[minIdx] ^ k) - nums[minIdx];
                }
            }
            // maxSum = maxSum + nums[minIdx] - minImpact;
            int negMinIdx = -1;
            int negMinImpact = Integer.MAX_VALUE;
            for (int i = 0; i < negativeImpactIdx.size(); i++) {
                int absVal = Math.abs((nums[negativeImpactIdx.get(i)] ^ k) - nums[negativeImpactIdx.get(i)]);
                if (absVal < negMinImpact) {
                    negMinIdx = negativeImpactIdx.get(i);
                    negMinImpact = absVal;
                }
            }

            if (minImpact - negMinImpact >= 0) {
                maxSum -= negMinImpact;
            }
        }
        return maxSum;
    }
}
