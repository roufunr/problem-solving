package leetcode.two_thousand_23.binary_search.search_in_rotated_sorted_array;

public class Solution {
    private int findPivot(int[] nums) {
        // finding pivot is the main task
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else if (nums[mid] < nums[nums.length - 1]) {
                right = mid;
            } else {
                break;
            }
        }
        return left;
    }
    public int search(int[] nums, int target) {
        int pivotIdx = findPivot(nums);
        if(nums[pivotIdx] == target) {
            return pivotIdx;
        }
        int left = nums[pivotIdx] > target ? 0 : pivotIdx + 1;
        int right = nums[pivotIdx] > target ? pivotIdx - 1: nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
