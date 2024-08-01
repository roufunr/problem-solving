package leetcode.daily_challenge.may_to_july_24.longest_continuous_subarray;

import java.util.TreeMap;

public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int start = 0;
        int end = 0;
        int maxLength = -1;
        while (end < nums.length) {
            window.put(nums[end], window.getOrDefault(nums[end], 0) + 1);
            while (window.lastKey() - window.firstKey() > limit && start <= end) {
                if (window.get(nums[start]) > 1) {
                    window.put(nums[start], window.get(nums[start]) - 1);
                } else {
                    window.remove(nums[start]);
                }
                start++;
            }
            if (window.lastKey() - window.firstKey() <= limit) {
                maxLength = maxLength < (end - start + 1) ? (end - start + 1) : maxLength;
            }
            end++;
        }
        return maxLength;
    }
}
