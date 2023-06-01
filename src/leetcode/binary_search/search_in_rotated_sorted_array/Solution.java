package leetcode.binary_search.search_in_rotated_sorted_array;
//https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/
public class Solution {
    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        do {
            mid = left + (right - left) / 2 ;
            if(mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                break;
            } else if(nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } while (left <= right);
        return (mid + 1) % nums.length;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int left;
        int right;

        if(nums[0] <= target) {
            left = 0;
            right = (nums.length +  pivot - 1) % nums.length;
        } else {
            left = pivot;
            right = nums.length - 1;
        }

        do {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } while (left <= right);
        return -1;
    }
}
