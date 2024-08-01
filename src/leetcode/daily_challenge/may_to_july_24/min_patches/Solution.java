package leetcode.daily_challenge.may_to_july_24.min_patches;

public class Solution {
    public int minPatches(int[] nums, int n) {
        int missingNum = 1;
        int count = 0;
        int i = 0;
        while (missingNum > 0 && missingNum <= n) {
            if (i < nums.length && missingNum >= nums[i]) {
                missingNum += nums[i];
                i++;
            } else {
                missingNum *= 2;
                count++;
            }
        }
        return count;
    }

}