package leetcode.daily_challenge.april_25.count_complete_subarrays_in_an_array_23;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int count = 0;
        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(start < nums.length - set.size() + 1) {
            while(map.size() < set.size() && end < nums.length) {
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
                end++;
            }
            if(map.size() < set.size()) {
                break;
            }
            count += nums.length - end + 1;
            if(map.get(nums[start]) == 1) {
                map.remove(nums[start]);
            } else {
                map.put(nums[start], map.get(nums[start]) - 1); 
            }
            start++;
        }
        return count;
    }
}
