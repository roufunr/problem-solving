package leetcode.two_thousand_24.bst.contains_duplicate_III;

public class Solution {

    // bruteforce Solution
    // encounters TLE
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int currentIdxDiff = Math.abs(i - j);
                int currentValueDiff = Math.abs(nums[i] - nums[j]);
                if (currentIdxDiff <= indexDiff && currentValueDiff <= valueDiff) {
                    return true;
                }

            }
        }
        return false;
    }
}

// 2 <= nums.length <= 105
// -109 <= nums[i] <= 109
// 1 <= indexDiff <= nums.length
// 0 <= valueDiff <= 109