package leetcode.two_thousand_24.binary_search.find_the_duplicate_number;

public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] < 0 ? (-1) * (nums[i]) : nums[i];
            idx--;
            if (nums[idx] < 0) {
                return nums[i] < 0 ? -1 * nums[i] : nums[i];
            } else {
                nums[idx] = (-1) * nums[idx];
            }
        }
        return -1;
    }
}
