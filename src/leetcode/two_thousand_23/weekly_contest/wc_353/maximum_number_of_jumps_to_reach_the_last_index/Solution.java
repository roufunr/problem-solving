package leetcode.two_thousand_23.weekly_contest.wc_353.maximum_number_of_jumps_to_reach_the_last_index;

public class Solution {
    // https://leetcode.com/contest/weekly-contest-353/problems/maximum-number-of-jumps-to-reach-the-last-index/
    // 6899. Maximum Number of Jumps to Reach the Last Index
    public int maximumJumps(int[] nums, int target) {
        int[] dpArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dpArray[i] = -1;
        }
        dpArray[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            int soFarMaxNumberOfJump = -1;
            for(int j = 0; j < i; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                if(diff <= target && soFarMaxNumberOfJump < dpArray[j]) {
                    soFarMaxNumberOfJump = dpArray[j];
                }
            }
            dpArray[i] = soFarMaxNumberOfJump == -1 ? -1 : soFarMaxNumberOfJump + 1;
        }
        return dpArray[nums.length - 1];
    }
}
