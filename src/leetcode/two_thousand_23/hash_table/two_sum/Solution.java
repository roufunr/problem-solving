package leetcode.two_thousand_23.hash_table.two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                int[] ans = {map.get(target - nums[i]), i};
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
