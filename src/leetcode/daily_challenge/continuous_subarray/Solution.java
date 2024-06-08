package leetcode.daily_challenge.continuous_subarray;

public class Solution {
    // got TLE
    public boolean checkSubarraySumV0(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = sum;
            sum += nums[i];
        }
        prefixSum[nums.length] = sum;

        for (int i = 2; i < nums.length + 1; i++) {
            for (int j = 0; j < i - 1; j++) {
                int subArraySum = prefixSum[i] - prefixSum[j];
                if (subArraySum % k == 0) {
                    return true;
                }
            }
        }
        if (nums.length > 1 && prefixSum[2] % k == 0) {
            return true;
        }
        return false;
    }
}