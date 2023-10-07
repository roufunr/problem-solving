package leetcode.two_thousand_23.binary_search.search_in_rotated_sorted_array;

public class Solution {
    private int findPivot(int[] nums) {
        // finding pivot is the main task
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public int binarySearch(int left, int right, int[] nums, int target) {
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivotIdx = findPivot(nums);
        int ans = binarySearch(0, pivotIdx - 1, nums, target);
        ans = ans == -1 ? binarySearch(pivotIdx, nums.length - 1, nums, target) : ans;
        return ans;

    }
}
