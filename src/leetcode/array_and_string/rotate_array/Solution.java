package leetcode.array_and_string.rotate_array;

public class Solution {
    public void reverse(int[] nums, int fromIdx, int toIdx) {
        int mid = (toIdx + fromIdx) / 2;
        int k = 0;
        for(int i = fromIdx; i <= mid; i++) {
            int temp = nums[i];
            nums[i] = nums[toIdx - k];
            nums[toIdx - k] = temp;
            k++;
        }

    }
    public void rotate(int[] nums, int k) {
        //https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/
        k = k % nums.length;
        if(k != 0) {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length-1);
        }
    }
}
