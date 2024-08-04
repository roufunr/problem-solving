package leetcode.daily_challenge.august_24.range_sum_of_sorted_subarray_sum;

import java.util.*;

public class Solution {

    private int modulo = 1000 * 1000 * 1000 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        // Arrays.sort(nums);
        List<Integer> subArrSums = new ArrayList<>();
        int[] prefixSum = new int[n];
        int  sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        } 
        for(int  i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                subArrSums.add(prefixSum[i] - prefixSum[j]);
            }
            subArrSums.add(prefixSum[i]);
        }
        Collections.sort(subArrSums);
        int ans = 0;
        for(int i = left - 1; i < right; i++) {
            ans += subArrSums.get(i);
            ans %= modulo;
        }
        return ans;
    }
}