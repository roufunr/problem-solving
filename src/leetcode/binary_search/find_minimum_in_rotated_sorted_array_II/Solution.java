package leetcode.binary_search.find_minimum_in_rotated_sorted_array_II;

public class Solution {
    public int findMin(int[] nums) {
        //https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1033/
        if(nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[left] <= nums[mid]) {
                int midNext = (mid + 1) % nums.length;
                if(nums[mid] > nums[midNext]) {
                    return nums[midNext];
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return nums[0];
    }
}
