package leetcode.array_and_string.largest_unique_number;

public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
    public int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            if(max < n) {
                max = n;
            }
        }
        return max;
    }
    public int dominantIndex(int[] nums) {
        int max = getMax(nums);
        int sameCounter = 0;
        int idx = -1;
        for(int i = 0; i < nums.length; i++) {
            if(max == nums[i] && sameCounter == 1) {
                return -1;
            } else if(max == nums[i] && sameCounter == 0) {
                sameCounter++;
                idx = i;
            } else {
                if(max < 2 * nums[i]) {
                    return -1;
                }
            }
        }
        return idx;
    }
}
