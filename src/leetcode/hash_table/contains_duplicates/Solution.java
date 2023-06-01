package leetcode.hash_table.contains_duplicates;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int n : nums) {
            if(numSet.contains(n)) {
                return true;
            } else {
                numSet.add(n);
            }
        }
        return false;
    }
}
