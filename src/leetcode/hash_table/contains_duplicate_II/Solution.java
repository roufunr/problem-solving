package leetcode.hash_table.contains_duplicate_II;

import java.util.HashMap;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1121/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int oldIdx = map.get(nums[i]);
                int newIdx = i;
                if(newIdx - oldIdx <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
