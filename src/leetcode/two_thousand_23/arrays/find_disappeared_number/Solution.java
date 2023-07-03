package leetcode.two_thousand_23.arrays.find_disappeared_number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] < 0
                    ? nums[Math.abs(nums[i]) - 1]
                    : nums[Math.abs(nums[i]) - 1] * (-1);
        }
        List<Integer> disappearedNumbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                disappearedNumbers.add(i+1);
            }
        }
        return disappearedNumbers;
    }
}
