package leetcode.daily_challenge.april_25.count_subarrays_of_length_three_with_a_condition_27;

public class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for(int i = 2; i < nums.length; i++) {
            if((nums[i - 2] + nums[i]) * 2 == nums[i - 1]) {
                count++;
            }
        }
        return count;
    }
}