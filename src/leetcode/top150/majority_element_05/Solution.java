package leetcode.top150.majority_element_05;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxCount = Integer.MIN_VALUE;
        int maxItem = Integer.MIN_VALUE;
        for(int key : map.keySet()) {
            if(maxCount < map.get(key)) {
                maxCount = map.get(key);
                maxItem = key;
            }
        }
        return maxItem;
    }
}
