package leetcode.daily_challenge.march_25.longest_nice_subarray_18;

public class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int ans = 1;
        int orMask = 0;

        while (end < nums.length) {
            while ((orMask & nums[end]) != 0) {  
                orMask ^= nums[start];
                start++;
            }
            orMask |= nums[end];
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}

