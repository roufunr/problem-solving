package leetcode.array_and_string.array_partition;

import java.util.Arrays;

public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1154/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
