package leetcode.daily_challenge.sum_of_all_subset_xor_total;

import java.util.ArrayList;
import java.util.List;

public class SolutionV1 {
    private int getXORSum(List<Integer> nums) {
        int sum = 0;
        for (int n : nums) {
            sum = sum ^ n;
        }
        return sum;
    }

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

    public int subsetXORSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int totalSubSet = (int) Math.pow(2, nums.length);
        int totalSum = 0;
        for (int i = 0; i < totalSubSet; i++) {

            totalSum += getXORSum(getSubset(nums, i));
        }

        return totalSum;
    }
}
