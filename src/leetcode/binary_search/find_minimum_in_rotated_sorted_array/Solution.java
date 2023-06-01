package leetcode.binary_search.find_minimum_in_rotated_sorted_array;
//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/
public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length;
        int minIdx = -1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[0] < nums[mid] && nums[mid] > nums[(mid + 1) % nums.length]) {
                minIdx = (mid + 1) % nums.length;
                break;
            } else if (nums[0] > nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if(minIdx == -1 && left < nums.length) {
            return nums[left];
        } else {
            return nums[minIdx];
        }
    }
}
