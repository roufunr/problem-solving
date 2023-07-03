package leetcode.two_thousand_23.arrays.move_zeros;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/
    public void moveZeroesV1(int[] nums) {
        int newLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(nums[newLen] == 0) {
                    int temp = nums[newLen];
                    nums[newLen] = nums[i];
                    nums[i] = temp;
                }
                newLen++;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        int newLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[newLen++] = nums[i];
            }
        }
        while(newLen < nums.length) {
            nums[newLen++] = 0;
        }
    }
}
