package leetcode.daily_challenge.february_25.check_if_array_is_sorted_and_rotated_02;

public class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return true;
        int inversionCount = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                ++inversionCount;
            }
        }
        if (nums[0] < nums[n - 1]) {
            ++inversionCount;
        }

        return inversionCount <= 1;
    }
}
