package leetcode.current.arrays.remove_element;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                // this number should be deleted
                for(int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j+1];
                }
                k--;
                i++;
            }
        }
        return k;
    }
}
