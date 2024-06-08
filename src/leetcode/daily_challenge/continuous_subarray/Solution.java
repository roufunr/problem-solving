package leetcode.daily_challenge.continuous_subarray;

import java.util.HashMap;
import java.util.Map;

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


    // order of N solution 
    // accepted
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int remainder = prefixSum[i] % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1)
                    return true;
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}