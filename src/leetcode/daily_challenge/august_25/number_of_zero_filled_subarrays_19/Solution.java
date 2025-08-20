package leetcode.daily_challenge.august_25.number_of_zero_filled_subarrays_19;

public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        for(int i = 0; i < nums.length;) {
            int j = i;
            while(j < nums.length && nums[j] == 0) {
                j++;
            }
            long len = (long)(j - i);
            if(len > 0) {
                count += (len * (len + 1)) / 2;
                i = j;
            } else {
                i++;
            }
        }
        return count;
    }
}