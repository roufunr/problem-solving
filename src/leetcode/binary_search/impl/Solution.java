package leetcode.binary_search.impl;
//https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
public class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (hi + lo) / 2;
        int idx = -1;
        while (hi>=lo) {
            if(nums[mid] == target) {
               idx = mid;
               break;
            } else if(nums[mid] > target) {
                hi = mid - 1;
            } else if(nums[mid] < target) {
                lo = mid + 1;
            }
            mid = (hi + lo) / 2;
        }
        return idx;
    }
}
