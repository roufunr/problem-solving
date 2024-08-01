package leetcode.daily_challenge.may_to_july_24.subarray_sum_div_by_k;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0, 1);
        for (int n : nums) {
            sum += n;
            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k;
            }
            if (map.containsKey(remainder)) {
                ans += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return ans;
    }
}
