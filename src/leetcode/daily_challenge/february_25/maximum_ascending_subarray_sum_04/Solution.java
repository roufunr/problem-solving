package leetcode.daily_challenge.february_25.maximum_ascending_subarray_sum_04;

public class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        int prev = nums[0];
        for(int i =0; i < nums.length; i++) {
            if(prev < nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            maxSum = Math.max(sum, maxSum);
            prev = nums[i];
        }
        return maxSum;
    }
}