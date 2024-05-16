package leetcode.two_thousand_24.recursionII.quick_sort;

public class Solution {
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        for (int j = lo; j <= hi; j++) {
            if (nums[j] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[hi];
        nums[hi] = tmp;
        return i;
    }

    private void qSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pIdx = partition(nums, lo, hi);
        qSort(nums, lo, pIdx - 1);
        qSort(nums, pIdx + 1, hi);
    }

    public int[] quickSort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        return nums;
    }
}
