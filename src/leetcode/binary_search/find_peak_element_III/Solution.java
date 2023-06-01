package leetcode.binary_search.find_peak_element_III;

public class Solution {
    //https://leetcode.com/explore/learn/card/binary-search/135/template-iii/946/
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
