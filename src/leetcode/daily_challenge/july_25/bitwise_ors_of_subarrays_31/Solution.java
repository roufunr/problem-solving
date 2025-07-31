package leetcode.daily_challenge.july_25.bitwise_ors_of_subarrays_31;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                int subOR = 0;
                for(int k = i; k <= j; k++) {
                    subOR |= arr[k];
                }
                set.add(subOR);
            }
        }
        return set.size();
    }
}
