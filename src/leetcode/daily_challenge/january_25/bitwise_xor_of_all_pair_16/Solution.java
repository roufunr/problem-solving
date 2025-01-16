package leetcode.daily_challenge.january_25.bitwise_xor_of_all_pair_16;

public class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        if (nums2.length % 2 == 1) {
            for (int n : nums1) {
                ans ^= n;
            }
        }
        if (nums1.length % 2 == 1) {
            for (int n : nums2) {
                ans ^= n;
            }
        }
        return ans;
    }
}