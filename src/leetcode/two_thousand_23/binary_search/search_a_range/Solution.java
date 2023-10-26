package leetcode.two_thousand_23.binary_search.search_a_range;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        if(nums == null || nums.length == 0) {
            return ans;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                if(nums[mid + 1] != target) {
                    ans[1] = mid;
                    break;
                } else {
                    left = mid;
                }
            } else if(nums[mid] < target ) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(nums[right] == target) {
            ans[1] = right;
        } else if(right > 0 && nums[right - 1] == target){
            ans[1] = right - 1;
        }
        


        left = 0;
        right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                if(nums[mid - 1] != target) {
                    ans[0] = mid;
                    break;
                } else {
                    right = mid;
                }
            } else if(nums[mid] < target ) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(nums[left] == target) {
            ans[0] = left;
        } else if(left + 1 < nums.length && nums[left + 1] == target) {
            ans[0] = left + 1;
        }
        
        return ans;
    }
}
