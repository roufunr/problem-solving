package leetcode.current.arrays.remove_element;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
    public int removeElement(int[] nums, int val) {
        int newLength = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[newLength++] = nums[i];
            }
        }
        return newLength;
    }
}
