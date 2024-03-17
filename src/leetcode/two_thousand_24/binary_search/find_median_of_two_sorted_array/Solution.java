package leetcode.two_thousand_24.binary_search.find_median_of_two_sorted_array;

public class Solution {
    private int p1 = 0;
    private int p2 = 0;

    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return (nums1[p1] < nums2[p2]) ? nums1[p1++] : nums2[p2++];
        } else if (p1 >= nums1.length) {
            return nums2[p2++];
        } else if (p2 >= nums2.length) {
            return nums1[p1++];
        } else {
            return -1;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isEven = ((nums1.length + nums2.length) % 2 == 0);
        int midPoint = nums1.length + nums2.length;
        midPoint /= 2;
        if (isEven == true) {
            for (int i = 0; i < midPoint - 1; i++) {
                getMin(nums1, nums2);
            }
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            for (int i = 0; i < midPoint; i++) {
                getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }
}
