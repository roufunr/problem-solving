package lc_others.maximum_difference_between_increasing_elements;

public class Solution {
    public int maximumDifference(int[] nums) {
        int minVal = nums[0];
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - minVal;
            minVal = Math.min(minVal, nums[i]);
            if (diff <= 0) {
                continue;
            }
            maxDiff = Math.max(diff, maxDiff);
        }
        return maxDiff == Integer.MIN_VALUE ? -1 : maxDiff;
    }
}
