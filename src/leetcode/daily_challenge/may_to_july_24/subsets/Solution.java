package leetcode.daily_challenge.may_to_july_24.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 13
    // 13 -> 6 1
    // 6 -> 3 0
    // 3 -> 1 1
    // 1 -> 0 1
    private List<Integer> getSubset(int[] nums, int serial) {
        List<Integer> subset = new ArrayList<>();
        int reminder = 0;
        int dividend = serial;
        int i = 0;
        while (dividend != 0) {
            reminder = dividend % 2;
            dividend = dividend / 2;
            if (reminder == 1) {
                subset.add(nums[i]);
            }
            i++;
        }
        return subset;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int totalSubsets = (int) Math.pow(2, nums.length);
        if (totalSubsets == 1) {
            return ans;
        }
        for (int i = 0; i < totalSubsets; i++) {
            ans.add(getSubset(nums, i));
        }
        return ans;
    }
}
