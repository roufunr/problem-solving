package leetcode.two_thousand_23.queue_stack.target_sum;

import java.util.*;
public class Solution {

    // bitwise solution
    // got TLE
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int maxNumber = (int) Math.pow(2, len);
        int counter = 0;
        for(int i = 0; i < maxNumber; i++) {
            String binary = Integer.toBinaryString(i);
            int binLen  = binary.length();
            for(int j = 0; j < len - binLen; j++) {
                binary = "0" + binary;
            }

            char[] presents = binary.toCharArray();
            int sum = 0;
            for(int j = 0; j < presents.length; j++) {
                if(presents[j]== '0') {
                    sum += (-1) * (nums[j]);
                } else {
                    sum += (+1) * (nums[j]);
                }
            }
            if(sum == target) {
                counter++;
            }
        }
        return counter;
    }
}
