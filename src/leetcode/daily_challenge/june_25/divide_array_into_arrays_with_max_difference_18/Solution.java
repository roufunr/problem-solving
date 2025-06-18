package leetcode.daily_challenge.june_25.divide_array_into_arrays_with_max_difference_18;

import java.util.Arrays;

public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length/3][3];
        for(int i = 0; i < ans.length; i++) {
            if(Math.abs(nums[i * 3 + 2] - nums[i * 3]) > k) {
                return new int[][]{};
            }
            ans[i][0] = nums[i * 3];
            ans[i][1] = nums[i * 3 + 1];
            ans[i][2] = nums[i * 3 + 2];
        }
        return ans;
    }
}