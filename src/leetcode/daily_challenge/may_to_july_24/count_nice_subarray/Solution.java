package leetcode.daily_challenge.may_to_july_24.count_nice_subarray;

import java.util.*;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> set = new HashMap<>();
        int count = 0;
        int ans = 0;
        set.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                count++;
            }
            set.put(count, set.getOrDefault(count, 0) + 1);
            if (set.containsKey(count - k)) {
                ans += set.get(count - k);
            }
        }
        return ans;
    }
}