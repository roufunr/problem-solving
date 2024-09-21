package leetcode.top150.remove_duplicates_from_sorted_array_03;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int newLen = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[newLen] != nums[i]) {
                newLen++;
                nums[newLen] = nums[i];
            }
        }
        return newLen + 1;
    }
}
