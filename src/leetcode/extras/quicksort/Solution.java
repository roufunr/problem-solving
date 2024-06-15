package leetcode.extras.quicksort;

public class Solution {
    private void qSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pivotIdx = partition(nums, lo, hi);
            qSort(nums, lo, pivotIdx - 1);
            qSort(nums, pivotIdx, hi);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivotItem = nums[hi];
        int i = lo;
        for (int j = lo; j <= hi; j++) {
            if (nums[j] < pivotItem) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = nums[hi];
        nums[hi] = temp;
        return i;
    }

    public void quickSort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }
}
