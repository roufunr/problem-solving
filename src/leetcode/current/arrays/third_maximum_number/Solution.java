package leetcode.current.arrays.third_maximum_number;

import java.util.Arrays;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int maxima = nums[nums.length - 1];
        int distinctCount = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] != maxima) {
                distinctCount++;
                maxima = nums[i];
            }
        }
        return distinctCount < 3 ? nums[nums.length - 1] : maxima;
    }
}
