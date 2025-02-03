package leetcode.daily_challenge.february_25.longest_strictly_increasing_or_strictly_decreasing_subarray_03;

public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int count = 1;
        int previousVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > previousVal) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 1;
            }
            previousVal = nums[i];
        }
        count = 1;
        previousVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < previousVal) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 1;
            }
            previousVal = nums[i];
        }

        return ans;
    }
}