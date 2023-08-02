package leetcode.two_thousand_23.hash_table.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set hashset = new HashSet();
        for(int n : nums) {
            if(hashset.contains(n)) {
                return true;
            } else {
                hashset.add(n);
            }
        }
        return false;
    }
}
