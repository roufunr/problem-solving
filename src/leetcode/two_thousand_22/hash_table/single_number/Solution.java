package leetcode.two_thousand_22.hash_table.single_number;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176/
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numSet = new HashMap<>();
        for(int n : nums) {
            if(numSet.containsKey(n)) {
                numSet.put(n, numSet.get(n) + 1);
            } else {
                numSet.put(n, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : numSet.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return nums[0];
    }
}
