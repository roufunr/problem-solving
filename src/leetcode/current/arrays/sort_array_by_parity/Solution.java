package leetcode.current.arrays.sort_array_by_parity;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
    public int[] sortArrayByParity(int[] nums) {
        int newLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                int temp = nums[newLen];
                nums[newLen++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}
