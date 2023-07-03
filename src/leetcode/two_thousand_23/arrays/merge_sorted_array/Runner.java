package leetcode.two_thousand_23.arrays.merge_sorted_array;

public class Runner {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
    }
}
