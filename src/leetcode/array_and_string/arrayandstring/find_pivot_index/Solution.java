package leetcode.array_and_string.arrayandstring.find_pivot_index;

public class Solution {
    public int pivotIndex(int[] nums) {
        //https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }

        int soFarSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int leftSum = soFarSum;
            int rightSum = sum - n - soFarSum;
            if(leftSum == rightSum) {
                return i;
            } else {
                soFarSum += n;
            }
        }
        return -1;
    }
}
