package leetcode.two_thousand_23.arrays.remove_duplicates_from_sorted_array;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3258/
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
