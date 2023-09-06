package leetcode.two_thousand_23.queue_stack.target_sum;

import java.util.*;
public class Solution {

    // bitwise solution
    // got TLE
    // public int findTargetSumWays(int[] nums, int target) {
    //     int len = nums.length;
    //     int maxNumber = (int) Math.pow(2, len);
    //     int counter = 0;
    //     for(int i = 0; i < maxNumber; i++) {
    //         String binary = Integer.toBinaryString(i);
    //         int binLen  = binary.length();
    //         for(int j = 0; j < len - binLen; j++) {
    //             binary = "0" + binary;
    //         }

    //         char[] presents = binary.toCharArray();
    //         int sum = 0;
    //         for(int j = 0; j < presents.length; j++) {
    //             if(presents[j]== '0') {
    //                 sum += (-1) * (nums[j]);
    //             } else {
    //                 sum += (+1) * (nums[j]);
    //             }
    //         }
    //         if(sum == target) {
    //             counter++;
    //         }
    //     }
    //     return counter;
    // }
    
    private int total;
    private int calculate(int[] nums, int sum, int i, int target, int[][] memorization) {
        if(i == nums.length) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if(memorization[i][total + sum] != Integer.MIN_VALUE) {
            return memorization[i][total + sum];
        } else {
            int add = calculate(nums, sum + nums[i], i + 1, target, memorization);
            int subtract = calculate(nums, sum - nums[i], i + 1, target, memorization);
            int totalSolution = add + subtract;
            memorization[i][total + sum] = totalSolution;
            return memorization[i][total + sum];
        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        total = 0;
        for(int n : nums) {
            total += n;
        }
        
        int[][] memorization = new int[nums.length][2 * total + 1];
        for(int i  = 0; i < memorization.length; i++) {
            for(int j = 0; j < memorization[0].length; j++) {
                memorization[i][j] = Integer.MIN_VALUE;
            }
        }

        int ans = calculate(nums, 0, 0, target, memorization);
        return ans;
    }
}
