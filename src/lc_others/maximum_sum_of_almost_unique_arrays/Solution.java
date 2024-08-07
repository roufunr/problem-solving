package lc_others.maximum_sum_of_almost_unique_arrays;

import java.util.*;

public class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long[] cumSum = new long[nums.size()];
        long sum = 0;
        Set<Integer> lastIdx = new HashSet<>();
        for(int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            if(i - k >= 0) {
                if(map.get(nums.get(i - k)) > 1) {
                    map.put(nums.get(i - k), map.get(nums.get(i - k)) - 1);
                } else {
                    map.remove(nums.get(i - k));
                }
            }
            sum += nums.get(i);
            if(map.size() < m) {
                lastIdx.add(i);
            }
            cumSum[i] = sum;
        }
        long max = lastIdx.contains(k - 1) ? 0 : cumSum[k - 1];
        for(int i = k; i < cumSum.length; i++) {
            if(!lastIdx.contains(i)) {
                max = Math.max(max, cumSum[i] - cumSum[i - k]);
            }
        }
        return max;
    }
}