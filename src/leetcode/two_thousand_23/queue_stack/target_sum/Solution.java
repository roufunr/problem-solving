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

    private int maxN = 20;
    private int maxSum = 1000;
    private int minSum = 0;
    private int base = 0;
    private int [][]dp;
    private boolean [][]v;
    
    // To store the states of DP
    public Solution() {
        dp = new int[maxN][maxSum + minSum];
        v = new boolean[maxN][maxSum + minSum];
    }
    
 
    // Function to return the required count
    private int findCnt(int []arr, int i, int required_sum, int n)
    {
        // Base case
        if (i == n)
        {
            if (required_sum == 0)
                return 1;
            else
                return 0;
        }
    
        // If the state has been solved before
        // return the value of the state
        if (v[i][required_sum + base])
            return dp[i][required_sum + base];
    
        // Setting the state as solved
        v[i][required_sum + base] = true;
    
        // Recurrence relation
        dp[i][required_sum + base] =
            findCnt(arr, i + 1, required_sum, n) +
            findCnt(arr, i + 1, required_sum - arr[i], n);
        return dp[i][required_sum + base];
    }

    
    public int findTargetSumWays(int[] nums, int target) {
        return findCnt(nums, 0, target, nums.length);
    }

}
