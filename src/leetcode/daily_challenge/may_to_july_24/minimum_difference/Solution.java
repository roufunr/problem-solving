package leetcode.daily_challenge.may_to_july_24.minimum_difference;

import java.util.Arrays;

public class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 4) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 4; i < 4; i++) {
            ans = Math.min(ans, nums[j] - nums[i]);
            j++;
        }
        return ans;
    }
}