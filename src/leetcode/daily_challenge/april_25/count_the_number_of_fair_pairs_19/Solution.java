package leetcode.daily_challenge.april_25.count_the_number_of_fair_pairs_19;

import java.util.Arrays;

public class Solution {
    private int search(int left, int right, int[] nums, int val) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int i = 0;
        for(int n : nums) {
            int Lower = lower - n;
            int Upper = upper - n + 1;

            int leftIdx = search(i + 1, nums.length - 1,nums, Lower);
            int rightIdx = search(i + 1, nums.length - 1,nums, Upper);
            count += (rightIdx - leftIdx);
            i++;
        }
        return count;
    }
}
