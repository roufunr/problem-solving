package leetcode.two_thousand_23.binary_search.search_in_rotated_sorted_array_updated;

public class Soluiton {
    public int getPivotIdx(int[] nums) {
        int pivotIdx = 0;
        int left = 0;
        int right = nums.length - 1;
        int lastElement = nums[nums.length - 1];
        while(left < right) {
            int mid = left + (right -left) / 2;
            if(nums[mid] < lastElement) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        pivotIdx = left;
        return pivotIdx;
    }

    public int binary_search(int nums[], int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int pivotIdx = getPivotIdx(nums);
        int leftHalf = binary_search(nums, 0, pivotIdx - 1, target);
        return leftHalf > -1 ? leftHalf : binary_search(nums, pivotIdx, nums.length - 1, target);
    }
}

