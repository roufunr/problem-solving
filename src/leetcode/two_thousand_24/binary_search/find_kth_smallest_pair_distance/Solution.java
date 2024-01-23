package leetcode.two_thousand_24.binary_search.find_kth_smallest_pair_distance;

import java.util.Arrays;

public class Solution {
    private int getCount(int[] nums, int mi) {
        int r = 1;
        int count = 0;
        while (r < nums.length) {
            int l = 0;
            while (nums[r] - nums[l] > mi)
                l++;
            count += r - l;
            r++;
        }
        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            int count = getCount(nums, mi);
            if (count < k) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }
}