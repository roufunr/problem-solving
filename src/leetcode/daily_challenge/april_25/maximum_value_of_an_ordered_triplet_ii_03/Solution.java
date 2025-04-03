package leetcode.daily_challenge.april_25.maximum_value_of_an_ordered_triplet_ii_03;

public class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] prefixMax = new int[nums.length];
        int[] sufixMax = new int[nums.length];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            prefixMax[i] = max;
        }

        max = nums[nums.length - 1];
        for(int i = nums.length - 1; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            sufixMax[i] = max;
        }

        long maxima = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            long u = prefixMax[i];
            long v = nums[i];
            long w = sufixMax[i + 1];
            maxima = Math.max((u - v) * w, maxima);
        }
        return maxima;
    }
}