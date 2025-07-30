package leetcode.daily_challenge.july_25.longest_subarray_with_maximum_bitwise_and_29;

public class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for(int n : nums) {
            maxVal = Math.max(maxVal, n);
        }
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(x != maxVal) {
                continue;
            }
            int j = i;
            int count = 0;
            while(j < nums.length && x == nums[j]) {
                count++;
                j++;
            }
            i = j;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
