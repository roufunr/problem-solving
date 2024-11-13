
package leetcode.daily_challenge.november_24.count_the_number_of_fair_pairs_13;

import java.util.Arrays;

public class Solution {
    private int binary_search(int[] nums, int x, boolean sup) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(sup) {
                if(nums[mid] <= x) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(nums[mid] >= x) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int i = 0;
        for(int n : nums) {
            int leftIdx = binary_search(nums, lower - n, false);
            int rightIdx = binary_search(nums, upper - n, true);
            if(rightIdx == -1 || leftIdx == -1) {
                continue;
            }
            if(leftIdx > rightIdx) {
                continue;
            }
            if(i >= leftIdx && i <= rightIdx) {
                count--;
            } 
            count += (rightIdx - leftIdx + 1);
            i++;
        }
        return count/2;
    }
}
