package leetcode.two_thousand_23.arrays_and_strings.find_pivot_index;

public class Solution {
    // https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
    public int pivotIndex(int[] nums) {
        int[] cumulativeSum = new int[nums.length];
        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
            cumulativeSum[i] = total;
        }
        for(int i = 0; i < nums.length; i++) {
            int leftSum = i >= 1 ? cumulativeSum[i-1] : 0;
            int rightSum = total - leftSum - nums[i];
            if(leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
