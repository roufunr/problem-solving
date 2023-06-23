package leetcode.current.arrays.third_maximum_number;

import java.util.Arrays;

public class Solution {
    // https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
    public int thirdMaxV1(int[] nums) {
        Arrays.sort(nums);
        int maxima = nums[nums.length - 1];
        int distinctCount = 1;
        for(int i = nums.length - 2; i >= 0 && distinctCount < 3; i--) {
            if(nums[i] != maxima) {
                distinctCount++;
                maxima = nums[i];
            }
        }
        return distinctCount < 3 ? nums[nums.length - 1] : maxima;
    }

    public int thirdMax(int[] nums) {
        int[] maxArr = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int i = 0; i < nums.length; i++) {
            boolean found = false;
            for(int j = 0; j < maxArr.length; j++) {
                if(maxArr[j] == nums[i]) {
                    found = true;
                    break;
                }
            }
            if(found == true) continue;

            maxArr[0] = nums[i];
            Arrays.sort(maxArr);
        }
        return maxArr[1] == Integer.MIN_VALUE ? maxArr[3] : maxArr[1];
    }
}
