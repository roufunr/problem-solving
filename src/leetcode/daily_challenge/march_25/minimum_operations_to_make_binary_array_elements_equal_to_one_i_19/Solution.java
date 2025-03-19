package leetcode.daily_challenge.march_25.minimum_operations_to_make_binary_array_elements_equal_to_one_i_19;

public class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] = (nums[i + 1] + 1) % 2;
                nums[i + 2] = (nums[i + 2] + 1) % 2;
                count++;
            }
        }
        if(nums[nums.length - 2] == 0 || nums[nums.length - 1] == 0) {
            return -1;
        }
        return count;
    }
}