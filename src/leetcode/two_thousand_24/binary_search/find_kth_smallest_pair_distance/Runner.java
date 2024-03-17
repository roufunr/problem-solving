package leetcode.two_thousand_24.binary_search.find_kth_smallest_pair_distance;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 1, 3 };
        int k = 1;
        System.out.println(new Solution().smallestDistancePair(nums, k));
        // Arrays.sort(nums);
        // int lo = 0;
        // int hi = nums[nums.length - 1] - nums[0];
        // for (int i = lo; i <= hi; i++) {
        // System.out.println("dist: " + i + " --> " + new Solution().getCount(nums,
        // i));
        // }
    }
}
