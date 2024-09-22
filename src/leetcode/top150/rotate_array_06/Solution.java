package leetcode.top150.rotate_array_06;

public class Solution {
    private void reverse(int[] nums, int fromIdx, int toIdx) {
        int mid = ((fromIdx + toIdx) / 2 )  -  fromIdx;
        for(int i = 0; i <= mid; i++) {
            int temp = nums[fromIdx + i];
            nums[fromIdx + i] = nums[toIdx - i];
            nums[toIdx - i] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int fromIdx1 = 0;
        int toIdx1 = nums.length - k - 1;
        int fromIdx2 = nums.length - k;
        int toIdx2 = nums.length - 1;
        reverse(nums, fromIdx1, toIdx1);
        reverse(nums, fromIdx2, toIdx2);
        reverse(nums, 0, nums.length - 1);
    }
}