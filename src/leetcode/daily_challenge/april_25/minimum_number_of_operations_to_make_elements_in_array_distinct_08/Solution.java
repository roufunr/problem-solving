package leetcode.daily_challenge.april_25.minimum_number_of_operations_to_make_elements_in_array_distinct_08;
import java.util.*;
public class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        int[] distinctCount = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            distinct.add(nums[i]);
            distinctCount[i] = distinct.size();
        }
        int idx = 0;
        int count = 0;
        while(idx < nums.length && distinctCount[idx] < nums.length - idx) {
            idx += 3;
            count++;
        }
        return count;
    }
}