package leetcode.two_thousand_23.beginners_guide.running_sum_of_1_d_array;

public class Solution {
    // https://leetcode.com/problems/running-sum-of-1d-array/
    public int[] runningSum(int[] nums) {
        // it's a cumulative sum actually
        int cumulative_sum = 0;
        for(int i = 0; i < nums.length; i++) {
            cumulative_sum += nums[i];
            nums[i] = cumulative_sum;
        }
        return nums;
    }
}
