package leetcode.daily_challenge.april_25.minimum_operations_to_make_array_values_equal_to_k_09;
import java.util.*;
public class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> distinct = new HashSet<>();
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            distinct.add(nums[i]);
            minVal = Math.min(minVal, nums[i]);
        }
        if(minVal < k) {
            return -1;
        }
        return minVal == k ? distinct.size() - 1 : distinct.size();
    }
}