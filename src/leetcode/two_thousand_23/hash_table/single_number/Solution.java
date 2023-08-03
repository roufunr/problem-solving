package leetcode.two_thousand_23.hash_table.single_number;

import java.util.*;

public class Solution {
    // solved with n space. Will solve again with extra space
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> doubleNumberMap = new HashMap<>();
        for(int n : nums) {
            if(doubleNumberMap.containsKey(n)) {
                doubleNumberMap.put(n, doubleNumberMap.get(n) + 1);
            } else {
                doubleNumberMap.put(n, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : doubleNumberMap.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
