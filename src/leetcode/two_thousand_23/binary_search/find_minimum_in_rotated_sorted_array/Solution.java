package leetcode.two_thousand_23.binary_search.find_minimum_in_rotated_sorted_array;

public class Solution {
    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int lastElement = nums[nums.length - 1];
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > lastElement) {
                if(nums[mid] > nums [mid + 1]) {
                    return mid + 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        return nums[pivot];
    }
}
