package leetcode.daily_challenge.sum_of_all_subset_xor_total;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int getXORSum(List<Integer> nums) {
        int sum = 0;
        for(int n : nums) {
            sum = sum ^ n;
        }
        return sum;
    }
    private static String padBinaryString(String binStr, int totalLength) {
        // Calculate the number of zeros needed
        int paddingLength = totalLength - binStr.length();
        // Prepend the zeros using a StringBuilder for efficiency
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paddingLength; i++) {
            sb.append("0");
        }
        sb.append(binStr);
        return sb.toString();
    }
    public int subsetXORSum(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int totalSubSet = (int)Math.pow(2, nums.length);
        int totalSum = 0;
        for(int i = 0; i < totalSubSet; i++) {
            String binString = padBinaryString(Integer.toBinaryString(i), nums.length);
            List<Integer> subset = new ArrayList<>();
            for(int j = 0; j < binString.length(); j++) {
                if(binString.charAt(j) == '1') {
                    subset.add(nums[j]);
                }
            }
            totalSum += getXORSum(subset);
        }

        return totalSum;
    }
}
