package leetcode.two_thousand_24.binary_search.find_kth_smallest_pair_distance;

import java.util.Arrays;

public class Solution {
    public int getCount(int[] nums, int mi) {
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
                // we are pretty certain that the result is not found from lo to mi
                // that is why we set the lo to mi + 1
                // because result only can be be found between mi + 1 to hi
                lo = mi + 1;
            } else {
                // because count might equal to k but it doesn't ensure that mi is the optimal
                // that is why we further check from lo to hi in next iteration
                hi = mi;
            }
        }
        return lo;
    }
}