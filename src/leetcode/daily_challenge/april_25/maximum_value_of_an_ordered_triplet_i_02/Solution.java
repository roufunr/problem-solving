package leetcode.daily_challenge.april_25.maximum_value_of_an_ordered_triplet_i_02;

public class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    long x = (long) nums[i];
                    long y = (long) nums[j];
                    long z = (long) nums[k];
                    max = Math.max(max, (x - y) * z);
                }
            }
        }
        return max;
    }
}