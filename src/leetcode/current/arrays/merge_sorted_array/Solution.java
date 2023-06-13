package leetcode.current.arrays.merge_sorted_array;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];
        int k = 0;
        int l = 0;
        for(int i = 0; i < (m + n); i++) {
            if(k < m && l <n) {
                if(nums1[k] < nums2[l]) {
                    mergedArray[i] = nums1[k++];
                } else {
                    mergedArray[i] = nums2[l++];
                }
            } else if (k < m && l >= n) {
                mergedArray[i] = nums1[k++];
            } else if (k >= m && l < n) {
                mergedArray[i] = nums2[l++];
            } else {
                break;
            }
        }

        for(int i = 0; i < (m + n); i++) {
            nums1[i] = mergedArray[i];
        }
    }
}
