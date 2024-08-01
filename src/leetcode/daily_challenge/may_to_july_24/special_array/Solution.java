package leetcode.daily_challenge.may_to_july_24.special_array;

import java.util.Arrays;

public class Solution {
    public int specialArray(int[] nums) {
        int[] counts = new int[nums.length + 1];

        for (int j = 0; j <= nums.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= j) {
                    counts[j]++;
                }
            }
        }

        for (int i = 0; i <= nums.length; i++) {
            if (counts[i] == i) {
                return i;
            }
        }

        return -1;
    }
}
