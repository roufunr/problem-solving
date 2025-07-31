package leetcode.daily_challenge.july_25.bitwise_ors_of_subarrays_31;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // this is a brute force solution
    // it has O(n^3) time complexity
    // where n is the length of the input array
    // it is not efficient for large inputs
    // but it is simple and easy to understand
    // it calculates the bitwise OR for all subarrays
    // and stores the unique results in a set
    // finally, it returns the size of the set
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
