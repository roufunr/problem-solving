package leetcode.daily_challenge.september_24.longest_subarray_with_max_bitwise_AND_14;

public class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            max = Math.max(n, max);
        }
        int currentStreak = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == max) {
                if(currentStreak == 0) {
                    currentStreak = 1;
                } else {
                    currentStreak++;
                }
                
            } else {
                currentStreak = 0;
            }
            ans = Math.max(currentStreak, ans);
        }
        return ans;
    }
}