package leetcode.two_thousand_23.arrays_and_strings.minimum_size_subarray;

import java.util.Arrays;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int sa_size = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= target) {
                sa_size = sa_size > i - left + 1 ? i - left + 1 : sa_size;
                sum-=nums[left++];
            }
        }
        return sa_size == Integer.MAX_VALUE ? 0 : sa_size;
    }
}
