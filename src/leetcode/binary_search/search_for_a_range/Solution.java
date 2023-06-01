package leetcode.binary_search.search_for_a_range;

import java.util.Objects;

public class Solution {
    //https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/
    int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2 ;
            if(nums[mid] == target) {
                if(isFirst) {
                    if(left == mid || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if(right == mid || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {findBound(nums, target, true), findBound(nums, target, false)};
        return ans;
    }
}
