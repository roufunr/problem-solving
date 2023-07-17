package leetcode.two_thousand_23.arrays_and_strings.largest_number_at_least_twice_of_others;

public class Solution {
    // https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
    public int dominantIndex(int[] nums) {
        for(int i = 0 ; i < nums.length; i++) {
            boolean isDominantElement = true;
            for(int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if((2 * nums[j]) > nums[i]) {
                    isDominantElement = false;
                    break;
                }
            }
            if (isDominantElement) {
                return i;
            }
        }
        return -1;
    }
}
