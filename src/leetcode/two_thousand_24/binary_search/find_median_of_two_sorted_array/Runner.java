package leetcode.two_thousand_24.binary_search.find_median_of_two_sorted_array;

public class Runner {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 5, 7, 10 };
        int[] nums2 = { 3, 4 };
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
