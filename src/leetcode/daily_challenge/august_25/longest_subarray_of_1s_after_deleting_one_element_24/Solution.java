package leetcode.daily_challenge.august_25.longest_subarray_of_1s_after_deleting_one_element_24;

public class Solution {
    public int longestSubarray(int[] nums) {
        int right = 0;
        int left = 0;
        int countZero = 0;
        int ans = 0;
        while(right < nums.length) {
            if(nums[right] == 0) {
                countZero++;
            }
            while(left <= right && countZero > 1) {
                if(nums[left] == 0) {
                    countZero--;
                }
                left++;
            }
            ans = Math.max(right - left, ans);
            right++;
        }
        return ans;
    }
}