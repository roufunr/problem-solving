package leetcode.two_thousand_23.binary_search.find_peak_element;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // freezing condition is when left reaches to some local maxima where
        // where right may be reached to that point or previously pointed at that point
        // this is the break condition of the loop
        // so technically left or right is the peak element
        // the intuition is when both reach same point that infers the local maxima
        return right;
    }
}

